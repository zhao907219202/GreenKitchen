package com.zy.implement;

import com.zy.basic.BasicService;
import com.zy.dto.Materialone;
import com.zy.dto.Materialtwo;
import com.zy.interfaces.MaterialServiceInter;

import java.util.ArrayList;
import java.util.List;

public class MaterialService extends BasicService implements
		MaterialServiceInter {

	@SuppressWarnings("unchecked")
	@Override
	public List<Materialtwo> getIndexMaterial() {

		String hql = "select materialtwo.id,count(id) from RecipeMaterial group by materialtwo.id order by count(id) desc";
		List<Object[]> list = super.queryLimit(hql, null, 0, 14);
		ArrayList<Materialtwo> arrayList = new ArrayList<Materialtwo>();
		Materialtwo materialtwo = null;
		for (int i = 0; i < 14; i++) {
			Object[] objs = list.get(i);
			materialtwo = (Materialtwo) super.findById(Materialtwo.class,
					(Integer) objs[0]);
			arrayList.add(materialtwo);
		}
		return arrayList;
	}

	@SuppressWarnings("unchecked")
	public List<Materialone> getAllMeterialone() {

		String hql = "from Materialone";
		List<Materialone> list = super.execuyteQuery(hql, null);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Materialtwo> getTenMaterialtwoByOne(int first_id) {

		String hql = "from Materialtwo where materialone.id = ?";
		Object[] parameters = { first_id };
		List<Materialtwo> list = super.queryLimit(hql, parameters, 0, 10);
		return list;
	}

	public Materialtwo getMaterialtwoById(int second_id) {

		String hql = "from Materialtwo where id = ?";
		Object[] parameters = { second_id };
		Materialtwo materialtwo = (Materialtwo) super.uniqueQuery(hql,
				parameters);
		return materialtwo;
	}

	@Override
	public Materialone getMaterialoneById(int first_id) {

		Materialone materialone = (Materialone) super.findById(Materialone.class, first_id);
		return materialone;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materialtwo> getMaterialtwoByOne(int first_id) {

		String hql = "from Materialtwo where materialone.id = ?";
		Object[] parameters = { first_id };
		List<Materialtwo> list = super.execuyteQuery(hql, parameters);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materialone> getMaterialoneByType(String type) {

		String hql = "from Materialone where type = ?";
		Object[] parameters = { type };
		List<Materialone> materialones = super.execuyteQuery(hql, parameters);
		return materialones;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materialtwo> getAllMaterialtwo() {
		String hql = "from Materialtwo";
		List<Materialtwo> materialtwos = super.execuyteQuery(hql, null);
		return materialtwos;
	}
	
	

}
