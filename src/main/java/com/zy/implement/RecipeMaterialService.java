package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Recipe;
import com.zy.dto.RecipeMaterial;
import com.zy.interfaces.RecipeMaterialServiceInter;

import java.util.ArrayList;
import java.util.List;

public class RecipeMaterialService extends BasicService implements
		RecipeMaterialServiceInter {

	@Override
	public int getRecipePageCount(int material_id, int pageSize) {

		String hql = "select count(*) from RecipeMaterial where materialtwo.id = ?";
		Object[] parameters = { material_id };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	/*
	 * hql���д�� select recipe from RecipeMaterial where materialtwo.id = ? �ᱨ��
	 * ����ԭ���� ������hibernate����ʶ�����������ӵĲ�ѯ
	 * ���Բ��ö��η�װ��װ  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getRecipeByMaterial(int material_id, int pageNow,
                                          int pageSize) {
		String hql = "from RecipeMaterial where materialtwo.id = ?";
		Object[] parameters = { material_id };
		List<RecipeMaterial> recipeMaterials = super.executeQueryByPage(hql, parameters,
				pageNow, pageSize);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for(int i=0;i<recipeMaterials.size();i++){
			recipes.add(recipeMaterials.get(i).getRecipe());
		}
		return recipes;
	}

}
