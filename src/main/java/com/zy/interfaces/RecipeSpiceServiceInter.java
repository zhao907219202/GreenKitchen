package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.RecipeSpice;

import java.util.List;

public interface RecipeSpiceServiceInter extends BasicServiceInter {
	
	//��ȡĳ�����׵��������ϸ���
	public List<RecipeSpice> getAllSpiceByRecipe(int recipe_id);

}
