package com.dxctraining.inventorymgt.item.dto;

public class CreatePhoneRequest {
	private String name;
	private int storageMemory;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStorageMemory() {
		return storageMemory;
	}
	public void setStorageMemory(int storageMemory) {
		this.storageMemory = storageMemory;
	}
	

}