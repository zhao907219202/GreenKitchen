package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.RecipeStep;

import java.util.List;

public interface StepServiceInter extends BasicServiceInter {
	
	public List<RecipeStep> getRecipeStep(int recipe_id);
}
