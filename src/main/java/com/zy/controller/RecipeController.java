package com.zy.controller;

import com.zy.constant.GreenKitchenConst;
import com.zy.dto.*;
import com.zy.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeServiceInter recipeService;
	@Autowired
	private UserServiceInter userService;
	@Autowired
	private MaterialServiceInter materialService;
	@Autowired
	private StepServiceInter stepService;
	@Autowired
	private CommentServiceInter commentService;
	@Autowired
	private TypeServiceInter typeService;
	@Autowired
	private UserRecipeServiceInter userRecipeService;

	@RequestMapping("/goIndexUI")
	public ModelAndView goIndexUI() {

		List<Recipe> recipes = this.recipeService.getHotRecipes(8);
		List<User> users = this.userService.getHotUser(5);
		List<Materialtwo> materials = this.materialService.getIndexMaterial();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("recipes", recipes);
		modelAndView.addObject("users", users);
		modelAndView.addObject("materials", materials);
		modelAndView.setViewName("index/index");
		return modelAndView;
	}

	@RequestMapping("/goRecipeDetail")
	public ModelAndView goRecipeDetail(int recipe_id, String pageTo,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		Recipe recipe = (Recipe) this.recipeService.findById(Recipe.class,
				recipe_id);
		List<RecipeStep> steps = this.stepService.getRecipeStep(recipe_id);
		if (recipe.getNote() != null) {
			String note = recipe.getNote();
			recipe.setNote(note.replaceAll("\n", "<br/>"));
		}
		modelAndView.addObject("recipe", recipe);
		modelAndView.addObject("steps", steps);

		// ���۷�ҳ
		int pageNow = 1;
		int pageSize = 2;
		int pageCount = this.commentService.getCommentPageCount(recipe_id,
				pageSize);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Comment> comments = this.commentService.getRecipeCommentByPage(
				recipe_id, pageNow, pageSize);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("comments", comments);

		// �ж��Ƿ��ղ�
		User loginuser = (User) session.getAttribute("loginuser");
		if(loginuser==null){
			modelAndView.addObject("hasCollected", "no");
		}else{
			boolean hasCollected = userRecipeService.judgeHasCollected(loginuser, recipe);
			if(hasCollected)
				modelAndView.addObject("hasCollected", "yes");
			else
				modelAndView.addObject("hasCollected", "no");
				
		}

		modelAndView.setViewName("recipe/recipeDetail");
		return modelAndView;
	}

	@RequestMapping("/goTypeIndex")
	public ModelAndView goTypeIndex() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("styles", GreenKitchenConst.style);
		modelAndView.addObject("methods", GreenKitchenConst.method);
		modelAndView.addObject("flavors", GreenKitchenConst.flavor);
		modelAndView.addObject("kinds", GreenKitchenConst.kind);
		modelAndView.addObject("stapes", GreenKitchenConst.stape);
		modelAndView.addObject("bakes", GreenKitchenConst.bake);
		modelAndView.addObject("crowds", GreenKitchenConst.crowd);
		modelAndView.addObject("tools", GreenKitchenConst.tool);
		modelAndView.addObject("scenes", GreenKitchenConst.scene);
		modelAndView.addObject("slims", GreenKitchenConst.slim);
		modelAndView.addObject("effects", GreenKitchenConst.effect);
		modelAndView.addObject("nurses", GreenKitchenConst.nurse);
		modelAndView.addObject("festivals", GreenKitchenConst.festival);
		modelAndView.setViewName("recipe/recipeTypeIndex");
		return modelAndView;
	}

	@RequestMapping("/goTypeDetail")
	public ModelAndView goTypeDetail(String type, String value, String pageTo)
			throws UnsupportedEncodingException {

		ModelAndView modelAndView = new ModelAndView();
		String value_zh = new String(value.getBytes("iso8859-1"), "utf-8");
		int pageNow = 1;
		int pageSize = 8;
		int pageCount = this.typeService.getTypeRecipePageCount(type, value_zh,
				pageSize);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Recipe> recipes = this.typeService.getTypeRecipeByPage(type,
				value_zh, pageNow, pageSize);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("recipes", recipes);
		modelAndView.addObject("value", value_zh);
		modelAndView.addObject("type", type);
		modelAndView.setViewName("recipe/recipeTypeDetail");
		return modelAndView;
	}

	@RequestMapping("/goSelected")
	public ModelAndView goSelected(String pageTo) {

		int pageNow = 1;
		int pageSize = 12;
		int pageCount = 3;
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		ModelAndView modelAndView = new ModelAndView();
		List<Recipe> list = this.recipeService.getHotRecipes(36);

		int fromIndex = (pageNow - 1) * pageSize;
		int toIndex = pageNow * pageSize;

		List<Recipe> recipes = null;
		if (fromIndex >= list.size()) {
			recipes = new ArrayList<Recipe>();
		} else if (fromIndex < list.size() && toIndex >= list.size()) {
			recipes = list.subList(fromIndex, list.size());
		} else if (toIndex < list.size()) {
			recipes = list.subList(fromIndex, toIndex);
		}
		modelAndView.addObject("recipes", recipes);
		modelAndView.setViewName("recipe/recipeSelected");
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		return modelAndView;
	}
}
