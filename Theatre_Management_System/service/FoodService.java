package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.FoodDao;
import com.project.Theatre_Management_System.dto.Food;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	public Food saveFood (Food food) {
		return  foodDao.saveFood(food);		
	}

	public Food  fetchFoodById(int foodId) {
		return foodDao.fetchFoodById(foodId);
	}

	public Food  deleteFoodById(int foodId) {
		return foodDao.deleteFoodById(foodId);	
	}

	public Food  updateFoodById(int oldFoodId,Food newFood) {
		newFood.setFoodId(oldFoodId);;
		return foodDao.saveFood(newFood);
	}

	public List<Food> fetchAllFood () {
		return foodDao.fetchAllFood();
}
	}
