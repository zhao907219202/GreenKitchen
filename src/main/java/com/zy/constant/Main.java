package com.zy.constant;

import com.zy.dto.RecipeType;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String label = "����  ����   ��  �� ���� ɰ�� ����   ���з� ";
		String[] labels = label.split(" ");
		List<RecipeType> recipeTypes = new ArrayList<RecipeType>();
		for (int i = 0; i < labels.length; i++) {
			recipeTypes = LabelUtil.saveLabels(labels[i].trim(), recipeTypes);
		}
		System.out.println(recipeTypes);
		return;
	}

}
