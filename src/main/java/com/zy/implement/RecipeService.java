package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Recipe;
import com.zy.dto.User;
import com.zy.interfaces.RecipeServiceInter;

import java.util.List;

public class RecipeService extends BasicService implements RecipeServiceInter {

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getHotRecipes(int num) {
		String hql = "from Recipe order by collectednum desc, commentednum desc,likednum desc";
		List<Recipe> list = super.queryLimit(hql, null, 0, num);
		return list;
	}

	@Override
	public int getHotRecipesPageCount(int pageSize) {
		String hql = "select count(*) from Recipe";
		int pageCount = super.queryPageCount(hql, null, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getHotRecipeByPage(int pageNow, int pageSize) {

		String hql = "from Recipe order by collectednum desc, commentednum desc,likednum desc";
		List<Recipe> recipes = super.executeQueryByPage(hql, null, pageNow,
				pageSize);
		return recipes;
	}

	@Override
	public int getRecipePageCountByUser(int pageSize, int user_id) {

		String hql = "select count(*) from Recipe where user.id = ?";
		Object[] parameters = { user_id };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getRecipeByUserByPage(int pageNow, int pageSize,
                                            int user_id) {

		String hql = "from Recipe where user.id = ?";
		Object[] parameters = { user_id };
		List<Recipe> recipes = super.executeQueryByPage(hql, parameters,
				pageNow, pageSize);
		return recipes;
	}

	@Override
	public Recipe getNewestRecipeByUser(User loginuser) {
		String hql = "from Recipe where user.id = ? order by timestamp desc";
		Object[] parameters = { loginuser.getId() };
		@SuppressWarnings("unchecked")
		List<Recipe> list = super.queryLimit(hql, parameters, 0, 1);
		Recipe recipe = list.get(0);
		return recipe;
	}

}
