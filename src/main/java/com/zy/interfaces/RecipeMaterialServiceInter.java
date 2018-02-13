package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Recipe;

import java.util.List;

public interface RecipeMaterialServiceInter extends BasicServiceInter {

	//����ʳ�ķ�ҳ��ѯʳ��
	public int getRecipePageCount(int material_id, int pageSize);

	public List<Recipe> getRecipeByMaterial(int material_id, int pageNow,
                                          int pageSize);
}
