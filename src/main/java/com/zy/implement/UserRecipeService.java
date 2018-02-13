package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Recipe;
import com.zy.dto.User;
import com.zy.dto.UserRecipe;
import com.zy.interfaces.UserRecipeServiceInter;

import java.util.ArrayList;
import java.util.List;

public class UserRecipeService extends BasicService implements
		UserRecipeServiceInter {

	@Override
	public int getCollectedPageCountByUser(int pageSize, int user_id) {
		String hql = "select count(*) from UserRecipe where user.id = ?";
		Object[] parameters = { user_id };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getCollectedRecipeByPageByUser(int pageNow,
                                                     int pageSize, int user_id) {
		String hql = "from UserRecipe where user.id = ?";
		Object[] parameters = { user_id };
		List<UserRecipe> userRecipes = super.executeQueryByPage(hql,
				parameters, pageNow, pageSize);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (int i = 0; i < userRecipes.size(); i++) {
			recipes.add(userRecipes.get(i).getRecipe());
		}
		return recipes;
	}

	@Override
	public boolean judgeHasCollected(User user, Recipe recipe) {
		String hql = "from UserRecipe where user.id = ? and recipe.id = ?";
		Object[] parameters = { user.getId(), recipe.getId() };
		UserRecipe userRecipe = (UserRecipe) super.uniqueQuery(hql, parameters);
		if (userRecipe == null)
			return false;
		else
			return true;
	}

	@Override
	public void doCollectAndUpdateRecipe(UserRecipe userRecipe) {
		super.add(userRecipe);
		Recipe recipe = userRecipe.getRecipe();
		recipe.setCollectednum(recipe.getCollectednum() + 1);
		super.update(recipe);
		return;
	}

	@Override
	public void cancelCollectAndUpdateRecipe(User user, Recipe recipe) {
		String hql = "delete from UserRecipe where user.id =? and recipe.id = ?";
		Object[] parameters = { user.getId(), recipe.getId() };
		super.executeUpdate(hql, parameters);
		recipe.setCollectednum(recipe.getCollectednum() - 1);
		super.update(recipe);
		return;
	}

}
