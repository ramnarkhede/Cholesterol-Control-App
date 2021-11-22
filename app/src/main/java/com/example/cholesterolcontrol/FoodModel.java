package com.example.cholesterolcontrol;

public class FoodModel {
    private String foodName;

    public FoodModel(String foodName){
        this.foodName=foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
