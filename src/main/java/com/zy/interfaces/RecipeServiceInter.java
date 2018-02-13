package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Recipe;
import com.zy.dto.User;

import java.util.List;

public interface RecipeServiceInter extends BasicServiceInter {
	
	//��ѯָ����Ŀ������ʳ��
	public List<Recipe> getHotRecipes(int num);
	
	//��ҳ��ѯ����ʳ��
	public int getHotRecipesPageCount(int pageSize);
	
	public List<Recipe> getHotRecipeByPage(int pageNow, int pageSize);
	
	//��ҳ��ѯ�����û�ʳ��
	public int getRecipePageCountByUser(int pageSize, int user_id);

	public List<Recipe> getRecipeByUserByPage(int pageNow, int pageSize, int user_id);
	
	//����ָ���û�������û������ϴ��Ĳ���
	public Recipe getNewestRecipeByUser(User loginuser);
	
}
