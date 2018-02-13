package com.zy.controller;

import com.zy.dto.Message;
import com.zy.dto.Recipe;
import com.zy.dto.User;
import com.zy.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private UserServiceInter userService;
	@Autowired
	private RecipeServiceInter recipeService;
	@Autowired
	private ConcernServiceInter concernService;
	@Autowired
	private UserRecipeServiceInter userRecipeService;
	@Autowired
	private MessageServiceInter messageService;

	@RequestMapping("/goLoginView")
	public String goLoginView(HttpSession session) {

		User user = (User) session.getAttribute("loginuser");
		if (user == null) {
			return "forward:/WEB-INF/info/login.jsp";
		} else {
			return "redirect:/info/goUserIndex.action?user_id=" + user.getId();
		}
	}

	@RequestMapping("/login")
	public ModelAndView loginCl(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		String checkcode = (String) request.getSession().getAttribute(
				"checkcode");
		if (!request.getParameter("checkcode").equals(checkcode)) {
			modelAndView.addObject("info", "验证码输入有误");
			modelAndView.setViewName("info/login");
			return modelAndView;
		}
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		User user = new User();
		user.setUsername(name);
		user.setPassword(pwd);
		user = userService.checkUser(user);
		if (user != null) {
			request.getSession().setAttribute("loginuser", user);
			try {
				response.sendRedirect("/info/goUserIndex.action?user_id="
						+ user.getId());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("info", "用户名密码不正确");
			modelAndView.setViewName("info/login");
		}
		return modelAndView;
	}

	@RequestMapping("/goRegisterUi")
	public ModelAndView goRegisterUi() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("info/register");
		return modelAndView;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.removeValue("loginuser");
		modelAndView.setViewName("info/login");
		return modelAndView;
	}

	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User user = new User();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String description = request.getParameter("description");
		user.setId(1);
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setFansnum(0);
		user.setDescription(description);
		userService.add(user);

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write("<script>alert(\"注册成功，请点击'我的宝典'登录\");window.location.href=\"/info/goLoginView.action\";</script>");
		return null;
	}

	@RequestMapping("/goUpdateUi")
	public ModelAndView goUpdateUi(HttpSession session,HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		User loginuser = (User) session.getAttribute("loginuser");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(loginuser==null){
			out.write("<script>alert(\"请先登录\");window.location.href=\"/info/goLoginView.action\";</script>");
			return null;
		}
		loginuser = userService.findUserByName(loginuser.getUsername());
		session.setAttribute("loginuser", loginuser);
		modelAndView.setViewName("info/update");
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView update(User user, HttpServletResponse response)
			throws IOException {
		User originalUser = (User) userService.findUserByName(user
				.getUsername());
		originalUser.setSex(user.getSex());
		originalUser.setPassword(user.getPassword());
		originalUser.setDescription(user.getDescription());
		userService.updateUser(originalUser);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write("<script>alert(\"修改成功\");window.location.href=\"/info/goLoginView.action\";</script>");
		return null;
	}

	@RequestMapping("/goUserIndex")
	public ModelAndView goUserIndex(int user_id, String pageTo,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) userService.findById(User.class, user_id);
		int pageNow = 1;
		int pageSize = 8;
		int pageCount = this.recipeService.getRecipePageCountByUser(pageSize,
				user_id);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Recipe> recipes = this.recipeService.getRecipeByUserByPage(
				pageNow, pageSize, user_id);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("recipes", recipes);
		modelAndView.addObject("concernNum", user.getConcernsForActorId()
				.size());
		modelAndView.addObject("recipeNum", user.getRecipes().size());
		modelAndView.addObject("fansNum", user.getConcernsForConcerneeId()
				.size());
		modelAndView.addObject("user", user);

		// �жϵ�¼�û����Ƿ��Ѿ���ע���û�
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null)
			modelAndView.addObject("hasConcerned", "no");
		else {
			if (concernService.judeHasConcerned(user, loginuser))
				modelAndView.addObject("hasConcerned", "yes");
			else
				modelAndView.addObject("hasConcerned", "no");
		}
		modelAndView.setViewName("info/userIndex");
		return modelAndView;
	}

	@RequestMapping("/goConcerns")
	public ModelAndView goConcerns(int user_id, String pageTo,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) userService.findById(User.class, user_id);
		modelAndView.addObject("title", "��ע����");
		modelAndView.addObject("concernNum", user.getConcernsForActorId()
				.size());
		modelAndView.addObject("fansNum", user.getConcernsForConcerneeId()
				.size());
		modelAndView.addObject("recipeNum", user.getRecipes().size());
		modelAndView.addObject("user", user);
		int pageNow = 1;
		int pageSize = 8;
		int pageCount = this.concernService.getConcernsPageCountByUser(user_id,
				pageSize);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<User> concerns = this.concernService.getConcernsByUserByPage(
				user_id, pageNow, pageSize);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("concerns", concerns);

		// �жϵ�¼�û����Ƿ��Ѿ���ע���û�
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null)
			modelAndView.addObject("hasConcerned", "no");
		else {
			if (concernService.judeHasConcerned(user, loginuser))
				modelAndView.addObject("hasConcerned", "yes");
			else
				modelAndView.addObject("hasConcerned", "no");
		}
		modelAndView.setViewName("info/concerns");
		return modelAndView;
	}

	@RequestMapping("/goFans")
	public ModelAndView goFans(int user_id, String pageTo, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) userService.findById(User.class, user_id);
		modelAndView.addObject("title", "�ķ�˿");
		modelAndView.addObject("concernNum", user.getConcernsForActorId()
				.size());
		modelAndView.addObject("fansNum", user.getConcernsForConcerneeId()
				.size());
		modelAndView.addObject("recipeNum", user.getRecipes().size());
		modelAndView.addObject("user", user);
		// ��ҳ��ѯ���û��ķ�˿
		int pageNow = 1;
		int pageSize = 8;
		int pageCount = this.concernService.getFansPageCountByUser(user_id,
				pageSize);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<User> fans = this.concernService.getFansByUserByPage(user_id,
				pageNow, pageSize);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("fans", fans);

		// �жϵ�¼�û����Ƿ��Ѿ���ע���û�
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null)
			modelAndView.addObject("hasConcerned", "no");
		else {
			if (concernService.judeHasConcerned(user, loginuser))
				modelAndView.addObject("hasConcerned", "yes");
			else
				modelAndView.addObject("hasConcerned", "no");
		}
		modelAndView.setViewName("info/fans");
		return modelAndView;
	}

	@RequestMapping("/goUserCollected")
	public ModelAndView goUserCollected(int user_id, String pageTo,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) userService.findById(User.class, user_id);
		// �û���ӵ�в��׷�ҳ
		int pageNow = 1;
		int pageSize = 8;
		int pageCount = this.userRecipeService.getCollectedPageCountByUser(
				pageSize, user_id);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Recipe> recipes = this.userRecipeService
				.getCollectedRecipeByPageByUser(pageNow, pageSize, user_id);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("recipes", recipes);
		modelAndView.addObject("concernNum", user.getConcernsForActorId()
				.size());
		modelAndView.addObject("recipeNum", user.getRecipes().size());
		modelAndView.addObject("fansNum", user.getConcernsForConcerneeId()
				.size());
		modelAndView.addObject("user", user);

		// �жϵ�¼�û����Ƿ��Ѿ���ע���û�
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null)
			modelAndView.addObject("hasConcerned", "no");
		else {
			if (concernService.judeHasConcerned(user, loginuser))
				modelAndView.addObject("hasConcerned", "yes");
			else
				modelAndView.addObject("hasConcerned", "no");
		}

		modelAndView.setViewName("info/userCollected");
		return modelAndView;
	}

	@RequestMapping("/goUserMessage")
	public ModelAndView goUserMessage(int user_id, String pageTo,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) userService.findById(User.class, user_id);
		// �û���ӵ�в��׷�ҳ
		int pageNow = 1;
		int pageSize = 4;
		int pageCount = this.messageService.getMessagePageCountByUser(pageSize,
				user_id);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Message> messages = this.messageService.getMessageByPageByUser(
				pageNow, pageSize, user_id);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("messages", messages);
		modelAndView.addObject("concernNum", user.getConcernsForActorId()
				.size());
		modelAndView.addObject("recipeNum", user.getRecipes().size());
		modelAndView.addObject("fansNum", user.getConcernsForConcerneeId()
				.size());
		modelAndView.addObject("user", user);

		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null)
			modelAndView.addObject("hasConcerned", "no");
		else {
			if (concernService.judeHasConcerned(user, loginuser))
				modelAndView.addObject("hasConcerned", "yes");
			else
				modelAndView.addObject("hasConcerned", "no");
		}

		modelAndView.setViewName("info/userMessage");
		return modelAndView;
	}

}
