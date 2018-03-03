package com.zy.controller;

import com.zy.constant.LabelUtil;
import com.zy.constant.StringUtil;
import com.zy.dto.*;
import com.zy.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	private RecipeServiceInter recipeService;
	@Autowired
	private RecipeSpiceServiceInter recipeSpiceService;
	@Autowired
	private StepServiceInter stepService;
	@Autowired
	private TypeServiceInter typeService;
	@Autowired
	private MaterialServiceInter materialService;
	@Autowired
	private RecipeMaterialServiceInter recipeMaterialService;

	@RequestMapping("/goIssueUi")
	public String goIssueUi(HttpSession session, HttpServletResponse response)
			throws IOException {

		User loginuser = (User) session.getAttribute("loginuser");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if (loginuser == null) {
			out.write("<script>alert(\"请先登录\");window.location.href=\"/info/goLoginView.action\";</script>");
			return null;
		}
		return "issue/issue_step_1";
	}

	@RequestMapping("/stepOne")
	public ModelAndView stepOne(Recipe recipe, MultipartFile recipe_pic,
			HttpSession session) throws IOException {

		Recipe recipeNew = new Recipe();
		recipeNew.setId(1);
		recipeNew.setLikednum(0);
		recipeNew.setCommentednum(0);
		recipeNew.setCollectednum(0);
		recipeNew.setDifficulty(recipe.getDifficulty());
		recipeNew.setTime(recipe.getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		recipeNew.setTimestamp(dateFormat.format(new Date()));
		User loginuser = (User) session.getAttribute("loginuser");
		recipeNew.setUser(loginuser);
		recipeNew.setTitle(recipe.getTitle());
		String description = recipe.getDescription();
		if (description != null)
			recipeNew.setDescription(description);
		recipeService.add(recipeNew);

		String pic_path = "/Users/zy-dl/Desktop/user/zhaoyu/server/PictureServer/upload/temp/recipe";
		Recipe recipeReal = recipeService.getNewestRecipeByUser(loginuser);
		String filename = recipeReal.getId() + ".jpg";
		File newFile = new File(pic_path + filename);
		recipe_pic.transferTo(newFile);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("recipe_id", recipeReal.getId());
		modelAndView.setViewName("issue/issue_step_2");
		return modelAndView;
	}

	@RequestMapping("/stepTwo")
	public ModelAndView stepTwo(int recipe_id, int stepNum,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam("files") MultipartFile[] files, String note,
			String label) throws Exception {

		String main_spice = null;
		String main_amount = null;
		String assist_spice = null;
		String assist_amount = null;
		for (int i = 1; i <= 6; i++) {
			main_spice = request.getParameter("main_spice_" + i);
			main_amount = request.getParameter("main_amount_" + i);
			assist_spice = request.getParameter("assist_spice_" + i);
			assist_amount = request.getParameter("assist_amount_" + i);
			if (!StringUtil.isEmpty(main_spice) && !StringUtil.isEmpty(main_amount)) {
				RecipeSpice recipeSpice = new RecipeSpice();
				recipeSpice.setId(1);
				recipeSpice.setIsmain(1);
				recipeSpice.setRecipe((Recipe) recipeService.findById(
						Recipe.class, recipe_id));
				recipeSpice.setSpicename(main_spice);
				recipeSpice.setAmount(main_amount);
				recipeSpiceService.add(recipeSpice);
			}
			if (!StringUtil.isEmpty(assist_spice) && !StringUtil.isEmpty(assist_amount)) {
				RecipeSpice recipeSpice = new RecipeSpice();
				recipeSpice.setId(1);
				recipeSpice.setIsmain(0);
				recipeSpice.setRecipe((Recipe) recipeService.findById(
						Recipe.class, recipe_id));
				recipeSpice.setSpicename(assist_spice);
				recipeSpice.setAmount(assist_amount);
				recipeSpiceService.add(recipeSpice);
			}
		}

		if (files != null && files.length > 0) {
			for (int i = 1; i <= files.length; i++) {
				MultipartFile file = files[i - 1];
				String pic_path = "D:\\JavaWeb\\PictureServer\\upload\\temp\\recipe\\";
				String filename = recipe_id + "-" + i + ".jpg";
				File newFile = new File(pic_path + filename);
				file.transferTo(newFile);
			}
		}

		for (int i = 1; i < stepNum; i++) {
			String stepContent = request.getParameter("step_content_" + i);
			if (!StringUtil.isEmpty(stepContent)) {
				RecipeStep recipeStep = new RecipeStep();
				recipeStep.setId(1);
				recipeStep.setRecipe((Recipe) recipeService.findById(
						Recipe.class, recipe_id));
				recipeStep.setStep(stepContent);
				stepService.add(recipeStep);
			}
		}

		if (!StringUtil.isEmpty(note)) {
			Recipe recipe = (Recipe) recipeService.findById(Recipe.class,
					recipe_id);
			recipe.setNote(note);
			recipeService.update(recipe);
		}

		if (!StringUtil.isEmpty(label)) {
			String[] labels = label.split(" ");
			List<RecipeType> recipeTypes = new ArrayList<RecipeType>();
			for (int i = 0; i < labels.length; i++) {
				recipeTypes = LabelUtil.saveLabels(labels[i].trim(),
						recipeTypes);
			}
			RecipeType recipeType = null;
			for (int j = 0; j < recipeTypes.size(); j++) {
				recipeType = recipeTypes.get(j);
				recipeType.setId(1);
				recipeType.setRecipe((Recipe) recipeService.findById(Recipe.class,
					recipe_id));
				typeService.add(recipeType);
			}
		}
		
		this.saveMaterial(recipe_id);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write("<script>alert(\"发布成功\");window.location.href=\"/GreenKitchen/info/goLoginView.action\";</script>");
		return null;
	}

	private void saveMaterial(int recipe_id) {
		
		Recipe recipe = (Recipe)recipeService.findById(Recipe.class, recipe_id);
		List<Materialtwo> materialtwos = materialService.getAllMaterialtwo();
		List<RecipeSpice> recipeSpices = recipeSpiceService.getAllSpiceByRecipe(recipe_id);
		for(int i=0;i<recipeSpices.size();i++){
			for(int j=0;j<materialtwos.size();j++){
				if(StringUtil.compareStrings(materialtwos.get(j).getName(),recipeSpices.get(i).getSpicename())){
					RecipeMaterial recipeMaterial = new RecipeMaterial();
					recipeMaterial.setId(1);
					recipeMaterial.setMaterialtwo(materialtwos.get(j));
					recipeMaterial.setRecipe(recipe);
					recipeMaterialService.add(recipeMaterial);
				}
			}
		}
	}

}
