package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.User;

import java.util.List;

public interface UserServiceInter extends BasicServiceInter {
	
	//��ѯָ����Ŀ�������û�
	public List<User> getHotUser(int num);
	
	//��ҳ��ѯ�����û�
	public int getHotUserPageCount(int pageSize);
	
	public List<User> getHotUserByPage(int pageNow, int pageSize);
	
	public User checkUser(User user);
	
	public User findUserByName(String username);
	
	public void addUser(User user);
	
	public void updateUser(User user);
}
