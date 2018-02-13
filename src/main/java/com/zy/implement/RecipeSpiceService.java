package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.RecipeSpice;
import com.zy.interfaces.RecipeSpiceServiceInter;

import java.util.List;

public class RecipeSpiceService extends BasicService implements
		RecipeSpiceServiceInter {

	@SuppressWarnings("unchecked")
	@Override
	public List<RecipeSpice> getAllSpiceByRecipe(int recipe_id) {

		String hql = "from RecipeSpice where recipe.id = ?";
		Object[] parameters = { recipe_id };
		List<RecipeSpice> recipeSpices = super.execuyteQuery(hql, parameters);
		return recipeSpices;
	}

}
