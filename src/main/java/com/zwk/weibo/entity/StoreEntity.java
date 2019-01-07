package com.zwk.weibo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("store")
public class StoreEntity {
	@TableId
	private Long storeId;
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
