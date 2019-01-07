package com.zwk.weibo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("food")
public class FoodEntity {
	@TableId
	private Long foodId;
	private String foodName;
	private float foodPrice;
	private String foodPic;
	private String foodMajor;
	private String foodMinor;
	private String foodHunsu;
	private String foodMethod;
	private String foodTaste;
	private String foodCharacter;
	private int foodSales;
	private char foodState;
	private Long storeId;
	private String foodDetail;
	private Long genreId;
	private Long foodNum;

	public Long getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(Long foodNum) {
		this.foodNum = foodNum;
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodPic() {
		return foodPic;
	}

	public void setFoodPic(String foodPic) {
		this.foodPic = foodPic;
	}

	public String getFoodMajor() {
		return foodMajor;
	}

	public void setFoodMajor(String foodMajor) {
		this.foodMajor = foodMajor;
	}

	public String getFoodMinor() {
		return foodMinor;
	}

	public void setFoodMinor(String foodMinor) {
		this.foodMinor = foodMinor;
	}

	public String getFoodHunsu() {
		return foodHunsu;
	}

	public void setFoodHunsu(String foodHunsu) {
		this.foodHunsu = foodHunsu;
	}

	public String getFoodMethod() {
		return foodMethod;
	}

	public void setFoodMethod(String foodMethod) {
		this.foodMethod = foodMethod;
	}

	public String getFoodTaste() {
		return foodTaste;
	}

	public void setFoodTaste(String foodTaste) {
		this.foodTaste = foodTaste;
	}

	public String getFoodCharacter() {
		return foodCharacter;
	}

	public void setFoodCharacter(String foodCharacter) {
		this.foodCharacter = foodCharacter;
	}

	public int getFoodSales() {
		return foodSales;
	}

	public void setFoodSales(int foodSales) {
		this.foodSales = foodSales;
	}

	public char getFoodState() {
		return foodState;
	}

	public void setFoodState(char foodState) {
		this.foodState = foodState;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getFoodDetail() {
		return foodDetail;
	}

	public void setFoodDetail(String foodDetail) {
		this.foodDetail = foodDetail;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}
}
