package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.RecipeStep;
import com.zy.interfaces.StepServiceInter;

import java.util.List;

public class StepService extends BasicService implements StepServiceInter {

	@SuppressWarnings("unchecked")
	@Override
	public List<RecipeStep> getRecipeStep(int recipe_id) {
		
		String hql = "from RecipeStep where recipe.id=? order by id asc";
		Object[] parameters ={recipe_id};
		List<RecipeStep> list = super.execuyteQuery(hql, parameters);
		return list;
	}

}
