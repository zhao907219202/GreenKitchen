package com.zy.constant;

import com.zy.dto.RecipeType;

import java.util.List;

public class LabelUtil {
	
	public static List<RecipeType> saveLabels(String label, List<RecipeType> recipeTypes) {
		String[] style = GreenKitchenConst.style;
		for (int i = 0; i < style.length; i++) {
			if (StringUtil.compareStrings(style[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getStyle() == null){
						recipeTypes.get(j).setStyle(style[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setStyle(style[i]);
				}
			}
		}
		
		String[] method = GreenKitchenConst.method;
		for (int i = 0; i < method.length; i++) {
			if (StringUtil.compareStrings(method[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getMethod() == null){
						recipeTypes.get(j).setMethod(method[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setMethod(method[i]);
				}
			}
		}
		
		String[] flavor = GreenKitchenConst.flavor;
		for (int i = 0; i < flavor.length; i++) {
			if (StringUtil.compareStrings(flavor[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getFlavor() == null){
						recipeTypes.get(j).setFlavor(flavor[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setFlavor(flavor[i]);
				}
			}
		}
		
		String[] kind = GreenKitchenConst.kind;
		for (int i = 0; i < kind.length; i++) {
			if (StringUtil.compareStrings(kind[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getKind() == null){
						recipeTypes.get(j).setKind(kind[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setKind(kind[i]);
				}
			}
		}
		
		String[] stape = GreenKitchenConst.stape;
		for (int i = 0; i < stape.length; i++) {
			if (StringUtil.compareStrings(stape[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getStape() == null){
						recipeTypes.get(j).setStape(stape[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setStape(stape[i]);
				}
			}
		}
		
		String[] bake = GreenKitchenConst.bake;
		for (int i = 0; i < bake.length; i++) {
			if (StringUtil.compareStrings(bake[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getBake() == null){
						recipeTypes.get(j).setBake(bake[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setBake(bake[i]);
				}
			}
		}
		
		String[] crowd = GreenKitchenConst.crowd;
		for (int i = 0; i < crowd.length; i++) {
			if (StringUtil.compareStrings(crowd[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getCrowd() == null){
						recipeTypes.get(j).setCrowd(crowd[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setCrowd(crowd[i]);
				}
			}
		}
		
		String[] tool = GreenKitchenConst.tool;
		for (int i = 0; i < tool.length; i++) {
			if (StringUtil.compareStrings(tool[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getTool() == null){
						recipeTypes.get(j).setTool(tool[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setTool(tool[i]);
				}
			}
		}
		
		String[] scene = GreenKitchenConst.scene;
		for (int i = 0; i < scene.length; i++) {
			if (StringUtil.compareStrings(scene[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getScene() == null){
						recipeTypes.get(j).setScene(scene[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setScene(scene[i]);
				}
			}
		}
		
		String[] slim = GreenKitchenConst.slim;
		for (int i = 0; i < slim.length; i++) {
			if (StringUtil.compareStrings(slim[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getSlim() == null){
						recipeTypes.get(j).setSlim(slim[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setSlim(slim[i]);
				}
			}
		}
		
		String[] effect = GreenKitchenConst.effect;
		for (int i = 0; i < effect.length; i++) {
			if (StringUtil.compareStrings(effect[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getEffect() == null){
						recipeTypes.get(j).setEffect(effect[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setEffect(effect[i]);
				}
			}
		}
		
		String[] nurse = GreenKitchenConst.nurse;
		for (int i = 0; i < nurse.length; i++) {
			if (StringUtil.compareStrings(nurse[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getNurse() == null){
						recipeTypes.get(j).setNurse(nurse[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setNurse(nurse[i]);
				}
			}
		}
		
		String[] festival = GreenKitchenConst.festival;
		for (int i = 0; i < festival.length; i++) {
			if (StringUtil.compareStrings(festival[i], label)) {
				int j = 0;
				for(j=0;j<recipeTypes.size();j++){
					if(recipeTypes.get(j).getFestival() == null){
						recipeTypes.get(j).setFestival(festival[i]);
						break;
					}
				}
				if(j==recipeTypes.size()){
					recipeTypes.add(new RecipeType());
					recipeTypes.get(recipeTypes.size()-1).setFestival(festival[i]);
				}
			}
		}
		
		return recipeTypes;
	}
}
