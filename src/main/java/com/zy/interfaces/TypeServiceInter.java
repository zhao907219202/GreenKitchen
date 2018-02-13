package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Recipe;

import java.util.List;

public interface TypeServiceInter extends BasicServiceInter {

	// ���ݲ��������ҳ��ѯ����--��ʳ�ؼ�
	public int getTypeRecipePageCount(String type, String value, int pageSize);

	public List<Recipe> getTypeRecipeByPage(String type, String value,
                                          int pageNow, int pageSize);

	//��ѯָ�����������ݼ������ʳ��
	public List<Recipe> getSlimRecipe(String type, int num);

	//��ѯָ�������Ķ�ͯʳ��
	/**
	 * @param type    �������� --crowd
	 * @param values  ��ͯ��������ַ�������
	 * @param num     ָ������
	 * @return
	 */
	public List<Recipe> getChildRecipe(String type, String[] values, int num);

	// ��ҳ��ѯ���ݼ���ʳ��--��ɽ�۲�
	public int getSlimRecipePageCount(String type, int pageSize);

	public List<Recipe> getSlimRecipeByPage(String type, int pageNow, int pageSize);

	//��ҳ��ѯ��ͯʳ��--��ɽ�۲�
	public int getChildRecipePageCount(String type, String[] values, int pageSize);

	public List<Recipe> getChildRecipeByPage(String type, String[] values, int pageSize, int pageNow);
 	

}
