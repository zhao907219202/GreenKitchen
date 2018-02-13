package com.zy.controller;

import com.zy.dto.Materialone;
import com.zy.dto.Materialtwo;
import com.zy.dto.Recipe;
import com.zy.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialServiceInter materialService;
	@Autowired
	private RecipeMaterialServiceInter recipeMaterialService;

	@RequestMapping("/goMaterialIndex")
	public ModelAndView goMaterialIndex() {

		ModelAndView modelAndView = new ModelAndView();

		List<Materialone> materialones = this.materialService
				.getAllMeterialone();
		List<Materialtwo> materialtwos = null;
		for (int i = 0; i < materialones.size(); i++) {
			materialtwos = this.materialService
					.getTenMaterialtwoByOne(materialones.get(i).getId());
			modelAndView.addObject("materialtwos_" + i, materialtwos);
		}
		modelAndView.setViewName("recipe/recipeMaterialIndex");
		return modelAndView;
	}

	@RequestMapping("/goMaterialDetail")
	public ModelAndView goMaterialDetail(int material_id, String pageTo) {

		ModelAndView modelAndView = new ModelAndView();
		Materialtwo materialtwo = this.materialService
				.getMaterialtwoById(material_id);
		modelAndView.addObject("material", materialtwo);

		int pageNow = 1;
		int pageSize = 8;
		int pageCount = this.recipeMaterialService.getRecipePageCount(
				material_id, pageSize);
		if (pageTo != null)
			pageNow = Integer.parseInt(pageTo);
		List<Recipe> recipes = this.recipeMaterialService.getRecipeByMaterial(
				material_id, pageNow, pageSize);
		modelAndView.addObject("material_id", material_id);
		modelAndView.addObject("pageCount", pageCount);
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("recipes", recipes);
		modelAndView.setViewName("recipe/recipeMaterialDetail");
		return modelAndView;
	}
	
	@RequestMapping("/goMaterialList")
	public ModelAndView goMaterialList(int materialone_id) {

		ModelAndView modelAndView = new ModelAndView();
		List<Materialtwo> materialtwos = this.materialService.getMaterialtwoByOne(materialone_id);
		Materialone materialone = this.materialService.getMaterialoneById(materialone_id);
		modelAndView.addObject("materialone", materialone);
		modelAndView.addObject("materialtwos", materialtwos);
		
		modelAndView.setViewName("recipe/recipeMaterialList");
		return modelAndView;
	}
	
	@RequestMapping("/goMaterialTypeList")
	public ModelAndView goMaterialTypeList(String type) throws UnsupportedEncodingException {

		ModelAndView modelAndView = new ModelAndView();
		String type_zh = new String(type.getBytes("iso8859-1"), "utf-8");
		List<Materialone> materialones = this.materialService.getMaterialoneByType(type_zh);
		List<List<Materialtwo>> list = new ArrayList<List<Materialtwo>>();
		List<Materialtwo> materialtwos =null;
		for(Materialone one:materialones){
			materialtwos = this.materialService.getTenMaterialtwoByOne(one.getId());
			list.add(materialtwos);
			
		}
		modelAndView.addObject("type", type_zh);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("recipe/recipeMaterialTypeList");
		return modelAndView;
	}
	
}
