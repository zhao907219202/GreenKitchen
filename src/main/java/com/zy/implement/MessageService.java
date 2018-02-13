package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Message;
import com.zy.interfaces.MessageServiceInter;

import java.util.List;

public class MessageService extends BasicService implements MessageServiceInter {

	@Override
	public int getMessagePageCountByUser(int pageSize, int user_id) {
		String hql = "select count(*) from Message where userByReceiverId.id = ?";
		Object[] parameters = { user_id };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessageByPageByUser(int pageNow, int pageSize,
                                              int user_id) {
		String hql = "from Message where userByReceiverId.id = ?";
		Object[] parameters = { user_id };
		List<Message> messages = super.executeQueryByPage(hql, parameters, pageNow, pageSize);
		return messages;
	}

}
