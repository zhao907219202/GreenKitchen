package com.zy.interfaces;

import com.zy.basic.BasicServiceInter;
import com.zy.dto.Materialone;
import com.zy.dto.Materialtwo;

import java.util.List;

public interface MaterialServiceInter extends BasicServiceInter {

	public List<Materialtwo> getIndexMaterial();

	public List<Materialone> getAllMeterialone();

	public List<Materialtwo> getTenMaterialtwoByOne(int first_id);

	public Materialtwo getMaterialtwoById(int second_id);
	
	public Materialone getMaterialoneById(int first_id);
	
	public List<Materialtwo> getMaterialtwoByOne(int first_id);
	
	public List<Materialone> getMaterialoneByType(String type);
	
	//��ȡ���е�ʳ��materialtwo
	public List<Materialtwo> getAllMaterialtwo();
	
}
