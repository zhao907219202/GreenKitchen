package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.User;
import com.zy.interfaces.UserServiceInter;

import java.util.ArrayList;
import java.util.List;

public class UserService extends BasicService implements UserServiceInter {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getHotUser(int num) {

		String hql = "select user.id,count(id) from Recipe group by user.id order by count(id) desc";
		List<Object[]> list = super.queryLimit(hql, null, 0, num);
		ArrayList<User> arrayList = new ArrayList<User>();
		User user = null;
		int cnt = num<=list.size()?num:list.size();
		for (int i = 0; i < cnt; i++) {
			Object[] objs = list.get(i);
			user = (User) super.findById(User.class, (Integer) objs[0]);
			arrayList.add(user);
		}
		return arrayList;
	}

	@Override
	public int getHotUserPageCount(int pageSize) {
		String hql = "select count(*) from User ";
		int pageCount = super.queryPageCount(hql, null, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getHotUserByPage(int pageNow, int pageSize) {
		String hql = "select user.id,count(id) from Recipe group by user.id order by count(id) desc";
		List<Object[]> list = super.executeQueryByPage(hql, null, pageNow,
				pageSize);
		ArrayList<User> arrayList = new ArrayList<User>();
		User user = null;
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = list.get(i);
			user = (User) super.findById(User.class, (Integer) objs[0]);
			arrayList.add(user);
		}
		return arrayList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User checkUser(User user) {
		String hql = "from User where username=? and password=?";
		String[] parameters = { user.getUsername(), user.getPassword() };
		List<User> list = this.execuyteQuery(hql, parameters);
		if (list.size() == 1)
			return (User) list.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByName(String username) {
		String hql = "from User where username=?";
		String[] parameters = { username };
		List<User> list = this.execuyteQuery(hql, parameters);
		if (list.size() == 1)
			return (User) list.get(0);
		else
			return null;
	}

	@Override
	public void addUser(User user) {
		super.add(user);
		return;
	}

	@Override
	public void updateUser(User user) {
		super.update(user);
		return;
	}

}
