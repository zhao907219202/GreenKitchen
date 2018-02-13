package com.zy.controller;

import com.zy.dto.Concern;
import com.zy.dto.Recipe;
import com.zy.dto.User;
import com.zy.dto.UserRecipe;
import com.zy.interfaces.ConcernServiceInter;
import com.zy.interfaces.RecipeServiceInter;
import com.zy.interfaces.UserRecipeServiceInter;
import com.zy.interfaces.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private UserRecipeServiceInter userRecipeService;
	@Autowired
	private RecipeServiceInter recipeService;
	@Autowired 
	private UserServiceInter userService;
	@Autowired
	private ConcernServiceInter concernService;
	

	@RequestMapping("/doCollect")
	public ModelAndView doCollect(int recipe_id, HttpServletResponse response,
			HttpSession session) throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-control", "no-cache");
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null) {
			out.write("false");
			return null;
		}

		UserRecipe userRecipe = new UserRecipe();
		userRecipe.setId(1);
		userRecipe.setRecipe((Recipe) recipeService.findById(Recipe.class,
				recipe_id));
		userRecipe.setUser(loginuser);
		userRecipeService.doCollectAndUpdateRecipe(userRecipe);
		out.write("true");
		return null;
	}

	@RequestMapping("/cancelCollect")
	public ModelAndView cancelCollect(int recipe_id,
			HttpServletResponse response, HttpSession session)
			throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ʹ��ajax Ҫ���û���
		response.setHeader("Cache-control", "no-cache");
		// �ж��û��Ƿ��Ѿ���¼
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null) {
			out.write("false");
			return null;
		}
		Recipe recipe = (Recipe) recipeService
				.findById(Recipe.class, recipe_id);
		userRecipeService.cancelCollectAndUpdateRecipe(loginuser, recipe);
		out.write("true");
		return null;
	}
	
	@RequestMapping("/doConcern")
	public ModelAndView doConcern(int user_id, HttpServletResponse response,
			HttpSession session) throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-control", "no-cache");
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null) {
			out.write("false");
			return null;
		}

		Concern concern = new Concern();
		concern.setId(1);
		concern.setUserByActorId(loginuser);
		concern.setUserByConcerneeId((User)userService.findById(User.class, user_id));
		concernService.doConcernAndUpdateFansnum(concern);
		out.write("true");
		return null;
	}
	
	@RequestMapping("/cancelConcern")
	public ModelAndView cancelConcern(int user_id,
			HttpServletResponse response, HttpSession session)
			throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-control", "no-cache");
		User loginuser = (User) session.getAttribute("loginuser");
		if (loginuser == null) {
			out.write("false");
			return null;
		}
		
		User user = (User) userService.findById(User.class, user_id);
		concernService.cancelConcernAndUpdateFansnum(user, loginuser);
		out.write("true");
		return null;
	}

}
