package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
@Entity
@Table(name ="computers_info")
public class Computer {
	@Id
	@GeneratedValue
	private int id;
	private int discSize;
	private String itemName;
	
	@ManyToOne //manytoone
	private Supplier supplier;
	
	public Computer() {
		
	}
	public Computer(String itemName,int discSize) {
		this.itemName=itemName;
		this.discSize=discSize;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getItemname() {
		return itemName;
	}
	public void setItemname(String itemName) {
		this.itemName = itemName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscSize() {
		return discSize;
	}
	public void setDiscSize(int discSize) {
		this.discSize = discSize;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Computer that = (Computer) obj;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
	
	

}