package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Employee;
import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	public Food saveFood (Food food) {
		return  foodRepo.save(food);		
	}

	public Food   fetchFoodById(int foodId) {
		return foodRepo.findById(foodId).get();
	}

	public Food   deleteFoodById(int foodId) {
		Food food= foodRepo.findById(foodId).get();
		foodRepo.delete(food);
		return food;
	}

	public Food  updateFoodById(int oldFoodId,Food newFood) {
		newFood.setFoodId(oldFoodId);;
		return foodRepo.save(newFood);
	}

	public List<Food> fetchAllFood () {
		return foodRepo.findAll();
	}
}
