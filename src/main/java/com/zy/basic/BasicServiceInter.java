package com.zy.basic;

import java.io.Serializable;
import java.util.List;

public interface BasicServiceInter {
	
	//����һЩ���õķ���
	//1.ͨ��id��ȡ����
	public Object findById(Class clazz, Serializable id);
	//2.��ѯ����
	public List execuyteQuery(String hql, Object[] paramethers);
	//3.��ѯ��������ҳ
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pageSize);
	//4.��Ӷ���
	public void add(Object obj);
	//5.ͳһ��ִ�У�ɾ���޸ģ�
	public int executeUpdate(String hql, Object[] parameters);
	//6.����һ������
	public Object uniqueQuery(String hql, Object[] parameters);
	//7.����pageCount
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
	//8.����id��ɾ������
	public void delById(Class clazz, Serializable id);
	//9.����Object�޸�
	public void update(Object obj);
	//10.�Բ�ѯ������Ƹ���
	public List queryLimit(String hql, Object[] parameters, int firstResult, int maxResults);
}
