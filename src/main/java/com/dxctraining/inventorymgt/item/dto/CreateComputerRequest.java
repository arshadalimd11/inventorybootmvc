package com.dxctraining.inventorymgt.item.dto;

public class CreateComputerRequest {
	private String itemname;
	private int discSize;
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getDiscSize() {
		return discSize;
	}
	public void setDeskSpace(int discSize) {
		this.discSize=discSize;
	}
	

}