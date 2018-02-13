package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Recipe;
import com.zy.dto.RecipeType;
import com.zy.interfaces.TypeServiceInter;

import java.util.ArrayList;
import java.util.List;

public class TypeService extends BasicService implements TypeServiceInter {

	@SuppressWarnings("unchecked")
	public List<Recipe> getTypeRecipeByPage(String type, String value,
			int pageNow, int pageSize) {

		String hql = "select recipe from RecipeType where " + type + " = ? ";
		String[] parameters = { value };
		List<Recipe> recipes = super.executeQueryByPage(hql, parameters,
				pageNow, pageSize);
		return recipes;
	}

	public int getTypeRecipePageCount(String type, String value, int pageSize) {

		String hql = "select count(*) from RecipeType where " + type + " = ? ";
		String[] parameters = { value };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getSlimRecipe(String type, int num) {

		String hql = "from RecipeType where "
				+ type
				+ " != null order by recipe.collectednum desc, recipe.commentednum desc,recipe.likednum desc";
		List<RecipeType> recipeTypes = super.queryLimit(hql, null, 0, num);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (RecipeType recipeType : recipeTypes) {
			if (!recipes.contains(recipeType.getRecipe())) {
				recipes.add(recipeType.getRecipe());
			}
		}
		return recipes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getChildRecipe(String type, String[] values, int num) {

		String hql = "from RecipeType where "
				+ type
				+ "=?  order by recipe.collectednum desc, recipe.commentednum desc,recipe.likednum desc";
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		List<RecipeType> recipeTypes = null;
		for (int i = 0; i < values.length; i++) {
			recipeTypes = super.queryLimit(hql, new String[] { values[i] }, 0,
					num);
			for (RecipeType recipeType : recipeTypes) {
				if (!recipes.contains(recipeType.getRecipe())) {
					recipes.add(recipeType.getRecipe());
				}
			}
		}
		return recipes;
	}

	@Override
	public int getSlimRecipePageCount(String type, int pageSize) {

		String hql = "select count(*) from RecipeType where " + type
				+ " != null ";
		int pageCount = super.queryPageCount(hql, null, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getSlimRecipeByPage(String type, int pageNow,
			int pageSize) {

		String hql = "from RecipeType where "
				+ type
				+ " != null order by recipe.collectednum desc, recipe.commentednum desc,recipe.likednum desc";
		List<RecipeType> recipeTypes = super.executeQueryByPage(hql, null,
				pageNow, pageSize);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (RecipeType recipeType : recipeTypes) {
			if (!recipes.contains(recipeType.getRecipe())) {
				recipes.add(recipeType.getRecipe());
			}
		}
		return recipes;
	}

	@Override
	public int getChildRecipePageCount(String type, String[] values,
			int pageSize) {

		String hql = "select count(*) from RecipeType where " + type + "= ?";
		int rowCount = 0;
		for (int i = 0; i < values.length; i++) {
			rowCount += Integer.parseInt(super.uniqueQuery(hql,
					new String[] { values[i] }).toString());
		}
		return (rowCount - 1) / pageSize + 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getChildRecipeByPage(String type, String[] values,
			int pageSize, int pageNow) {
		String hql = "from RecipeType where "
				+ type
				+ "=?  order by recipe.collectednum desc, recipe.commentednum desc,recipe.likednum desc";
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		List<RecipeType> recipeTypes = null;
		for (int i = 0; i < values.length; i++) {
			recipeTypes = super.executeQueryByPage(hql,
					new String[] { values[i] }, pageNow, pageSize);
			for (RecipeType recipeType : recipeTypes) {
				if (!recipes.contains(recipeType.getRecipe())) {
					recipes.add(recipeType.getRecipe());
				}
			}
		}
		return recipes;
	}
}
