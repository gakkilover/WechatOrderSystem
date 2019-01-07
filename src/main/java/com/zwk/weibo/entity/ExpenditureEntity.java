package com.zwk.weibo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("expenditure")
public class ExpenditureEntity {
	@TableId
	private Long expenditureId;
	private String orderNumber;
	private float money;
	private String payee;
	private Date time;
	private Long userId;

	public Long getExpenditureId() {
		return expenditureId;
	}

	public void setExpenditureId(Long expenditureId) {
		this.expenditureId = expenditureId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
