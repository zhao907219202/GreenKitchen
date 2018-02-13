package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Message;

import java.util.List;

public interface MessageServiceInter extends BasicServiceInter {
	
	//��ҳ��ѯ�û�������
	public int getMessagePageCountByUser(int pageSize, int user_id);

	public List<Message> getMessageByPageByUser(int pageNow, int pageSize, int user_id);
}
