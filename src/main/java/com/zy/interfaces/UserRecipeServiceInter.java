package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Recipe;
import com.zy.dto.User;
import com.zy.dto.UserRecipe;

import java.util.List;

public interface UserRecipeServiceInter extends BasicServiceInter {

	// ��ҳ��ѯĳ�û��ղصĲ���
	public int getCollectedPageCountByUser(int pageSize, int user_id);

	public List<Recipe> getCollectedRecipeByPageByUser(int pageNow,
                                                     int pageSize, int user_id);

	// �û��ղز��ײ��޸Ĳ��׵��ղ���
	public void doCollectAndUpdateRecipe(UserRecipe userRecipe);

	// ȡ���ղز��޸Ĳ��׵��ղ���
	public void cancelCollectAndUpdateRecipe(User user, Recipe recipe);

	// �ж��û��Ƿ��ղ�ĳ����
	public boolean judgeHasCollected(User user, Recipe recipe);

}
