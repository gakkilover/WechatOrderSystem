package com.zwk.weibo.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;


public class FoodVO {

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
	private String storeName;
	private String storePic;
	private String storeBackground;
	private String storeNickname;
	private String storeSummary;
	private String storeCorporation;
	private String storeTel;
	private String socialCreditCode;
	private String storeSecondCode;
	private String storeState;
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


	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStorePic() {
		return storePic;
	}

	public void setStorePic(String storePic) {
		this.storePic = storePic;
	}

	public String getStoreBackground() {
		return storeBackground;
	}

	public void setStoreBackground(String storeBackground) {
		this.storeBackground = storeBackground;
	}

	public String getStoreNickname() {
		return storeNickname;
	}

	public void setStoreNickname(String storeNickname) {
		this.storeNickname = storeNickname;
	}

	public String getStoreSummary() {
		return storeSummary;
	}

	public void setStoreSummary(String storeSummary) {
		this.storeSummary = storeSummary;
	}

	public String getStoreCorporation() {
		return storeCorporation;
	}

	public void setStoreCorporation(String storeCorporation) {
		this.storeCorporation = storeCorporation;
	}

	public String getStoreTel() {
		return storeTel;
	}

	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}

	public String getSocialCreditCode() {
		return socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}

	public String getStoreSecondCode() {
		return storeSecondCode;
	}

	public void setStoreSecondCode(String storeSecondCode) {
		this.storeSecondCode = storeSecondCode;
	}

	public String getStoreState() {
		return storeState;
	}

	public void setStoreState(String storeState) {
		this.storeState = storeState;
	}
}
