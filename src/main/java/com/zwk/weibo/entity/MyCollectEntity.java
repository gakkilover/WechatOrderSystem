package com.zwk.weibo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("my_collect")
public class MyCollectEntity {
	@TableId
	private Long colId;
	private Long userId;
	private Long foodId;
	private Long storeId;
	private char colState;

	public Long getColId() {
		return colId;
	}

	public void setColId(Long colId) {
		this.colId = colId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public char getColState() {
		return colState;
	}

	public void setColState(char colState) {
		this.colState = colState;
	}
}
