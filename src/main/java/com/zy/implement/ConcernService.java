package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Concern;
import com.zy.dto.User;
import com.zy.interfaces.ConcernServiceInter;

import java.util.ArrayList;
import java.util.List;

public class ConcernService extends BasicService implements ConcernServiceInter {

	@Override
	public int getConcernsPageCountByUser(int actor_id, int pageSize) {
		String hql = "select count(*) from Concern where userByActorId.id = ?";
		Object[] parameters = { actor_id };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getConcernsByUserByPage(int actor_id, int pageNow,
			int pageSize) {
		String hql = "from Concern where userByActorId.id = ?";
		Object[] parameters = { actor_id };
		List<Concern> concerns = super.executeQueryByPage(hql, parameters,
				pageNow, pageSize);
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < concerns.size(); i++) {
			users.add(concerns.get(i).getUserByConcerneeId());
		}
		return users;
	}

	@Override
	public int getFansPageCountByUser(int concernee_id, int pageSize) {
		String hql = "select count(*) from Concern where userByConcerneeId.id = ?";
		Object[] parameters = { concernee_id };
		int pageCount = super.queryPageCount(hql, parameters, pageSize);
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getFansByUserByPage(int concernee_id, int pageNow,
			int pageSize) {
		String hql = "from Concern where userByConcerneeId.id = ?";
		Object[] parameters = { concernee_id };
		List<Concern> concerns = super.executeQueryByPage(hql, parameters,
				pageNow, pageSize);
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < concerns.size(); i++) {
			users.add(concerns.get(i).getUserByActorId());
		}
		return users;
	}

	@Override
	public boolean judeHasConcerned(User user, User loginuser) {
		String hql = "from Concern where userByActorId.id = ? and userByConcerneeId.id=?";
		Object[] parameters = { loginuser.getId(), user.getId() };
		Concern concern = (Concern) super.uniqueQuery(hql, parameters);
		if (concern == null)
			return false;
		else
			return true;
	}

	@Override
	public void doConcernAndUpdateFansnum(Concern concern) {
		super.add(concern);
		User concernee = concern.getUserByConcerneeId();
		concernee.setFansnum(concernee.getFansnum() + 1);
		super.update(concernee);
		return;
	}

	public void cancelConcernAndUpdateFansnum(User user, User loginuser) {
		String hql = "delete from Concern where userByActorId.id = ? and userByConcerneeId.id=?";
		Object[] parameters = { loginuser.getId(), user.getId() };
		super.executeUpdate(hql, parameters);
		user.setFansnum(user.getFansnum() - 1);
		super.update(user);
		return;
	}

}
