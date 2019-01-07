package com.zwk.weibo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("attache_pic")
public class AttachePicEntity {
	@TableId
	private Long attacheId;
	private String attacheName;
	private String attacheAddress;

	public Long getAttacheId() {
		return attacheId;
	}

	public void setAttacheId(Long attacheId) {
		this.attacheId = attacheId;
	}

	public String getAttacheName() {
		return attacheName;
	}

	public void setAttacheName(String attacheName) {
		this.attacheName = attacheName;
	}

	public String getAttacheAddress() {
		return attacheAddress;
	}

	public void setAttacheAddress(String attacheAddress) {
		this.attacheAddress = attacheAddress;
	}
}
