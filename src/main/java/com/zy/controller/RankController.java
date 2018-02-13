package com.zy.controller;

import com.zy.dto.Recipe;
import com.zy.dto.User;
import com.zy.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rank")
public class RankController {

	@Autowired
	private RecipeServiceInter recipeService;
	@Autowired
	private UserServiceInter userService;
	@Autowired
	private TypeServiceInter typeService;

	@RequestMapping("/goRankIndex")
	public ModelAndView goRankIndex() {

		ModelAndView modelAndView = new ModelAndView();
		List<Recipe> recipes = this.recipeService.getHotRecipes(10);
		List<User> users = this.userService.getHotUser(10);
		List<Recipe> slim_dishes = this.typeService.getSlimRecipe("slim", 10);
		String[] values = { "�׶�ʳ��", "ѧ��ǰ", "��ͯ", "������" };
		List<Recipe> child_dishes = this.typeService.getChildRecipe("crowd",
				values, 10);

		modelAndView.addObject("recipes", recipes);
		modelAndView.addObject("users", users);
		modelAndView.addObject("slim_dishes", slim_dishes);
		modelAndView.addObject("child_dishes", child_dishes);
		modelAndView.setViewName("rank/rankIndex");
		return modelAndView;
	}

	@RequestMapping("/goRankDetail")
	public ModelAndView goRankDetail(int title_id, String pageTo) {

		ModelAndView modelAndView = new ModelAndView();
		int pageSize = 15;
		int pageNow = 1;
		int pageCount;
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Recipe> recipes = null;

		switch (title_id) {
			case 1: { // hot recipe
				modelAndView.addObject("title", "���Ų��װ�");
				pageCount = this.recipeService.getHotRecipesPageCount(pageSize);
				recipes = this.recipeService.getHotRecipeByPage(pageNow, pageSize);
				modelAndView.addObject("recipes", recipes);
				modelAndView.addObject("pageCount", pageCount);
				modelAndView.addObject("pageNow", pageNow);
				break;
			}
			case 2: { // slim recipe
				modelAndView.addObject("title", "���ݼ��ʰ�");
				pageCount = this.typeService.getSlimRecipePageCount("slim",
						pageSize);
				recipes = this.typeService.getSlimRecipeByPage("slim", pageNow,
						pageSize);
				modelAndView.addObject("recipes", recipes);
				modelAndView.addObject("pageCount", pageCount);
				modelAndView.addObject("pageNow", pageNow);
				break;
			}
			case 3: { // child recipe
				modelAndView.addObject("title", "��ͯʳ�װ�");
				String[] values = { "�׶�ʳ��", "ѧ��ǰ", "��ͯ", "������" };
				pageCount = this.typeService.getChildRecipePageCount("crowd", values, pageSize);
				recipes = this.typeService.getChildRecipeByPage("crowd", values, pageSize, pageNow);
				modelAndView.addObject("recipes", recipes);
				modelAndView.addObject("pageCount", pageCount);
				modelAndView.addObject("pageNow", pageNow);
				break;
			}
		}
		modelAndView.addObject("title_id", title_id);
		modelAndView.setViewName("rank/rankDetail");
		return modelAndView;
	}
	
	
	@RequestMapping("/goRankUserDetail")
	public ModelAndView goRankUserDetail(String pageTo) {
		
		ModelAndView modelAndView = new ModelAndView();
		int pageSize = 15;
		int pageNow = 1;
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		int pageCount = this.userService.getHotUserPageCount(pageSize);
		List<User> users = this.userService.getHotUserByPage(pageNow, pageSize);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("users", users);
		modelAndView.addObject("title", "�����û���");
		modelAndView.setViewName("rank/rankUserDetail");
		return modelAndView;
	}

}
