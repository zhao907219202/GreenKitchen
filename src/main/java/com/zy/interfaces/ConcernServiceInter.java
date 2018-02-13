package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Concern;
import com.zy.dto.User;

import java.util.List;

public interface ConcernServiceInter extends BasicServiceInter {

	// ��ҳ��ѯĳ�û���ע����
	public int getConcernsPageCountByUser(int actor_id, int pageSize);

	public List<User> getConcernsByUserByPage(int actor_id, int pageNow,
                                            int pageSize);

	// ��ҳ��ѯĳ�û��ķ�˿
	public int getFansPageCountByUser(int concernee_id, int pageSize);

	public List<User> getFansByUserByPage(int concernee_id, int pageNow,
                                        int pageSize);

	//�жϵ�¼�û��Ƿ��Ѿ���ע���û�
	public boolean judeHasConcerned(User user, User loginuser);
	
	//��ӹ�ע�����޸ı���ע�ߵķ�˿��Ŀ
	public void doConcernAndUpdateFansnum(Concern concern);
	
	//ȡ����ע�����޸ı���ע�ߵķ�˿��Ŀ
	public void cancelConcernAndUpdateFansnum(User user, User loginuser);
}
