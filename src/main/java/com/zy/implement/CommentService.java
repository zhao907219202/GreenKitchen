package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Comment;
import com.zy.dto.Recipe;
import com.zy.interfaces.CommentServiceInter;

import java.util.List;

public class CommentService extends BasicService implements CommentServiceInter {

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getRecipeCommentByPage(int recipe_id,int pageNow,int pageSize) {
		
		String hql = "from Comment where recipe.id = ?";
		Object[] parameters = {recipe_id};
		List<Comment> comments = super.executeQueryByPage(hql, parameters, pageNow, pageSize);
		return comments;
	}

	@Override
	public int getCommentPageCount(int recipe_id, int pageSize) {
		
		String hql = "select count(*) from Comment where recipe.id = ?";
		Object[] parameters = {recipe_id};
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}
	
	@Override
	public void addCommentAndUpdateCommentNum(Comment comment) {
		super.add(comment);
		Recipe recipe = comment.getRecipe();
		recipe.setCommentednum(recipe.getCommentednum()+1);
		return;
	}

}
