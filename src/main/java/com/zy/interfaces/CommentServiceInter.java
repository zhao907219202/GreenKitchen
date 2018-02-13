package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Comment;

import java.util.List;

public interface CommentServiceInter extends BasicServiceInter {

	public List<Comment> getRecipeCommentByPage(int recipe_id, int pageNow,
                                              int pageSize);

	public int getCommentPageCount(int recipe_id, int pageSize);

	// ��Ӳ��׵����۲��޸Ĳ���������
	public void addCommentAndUpdateCommentNum(Comment comment);

}
