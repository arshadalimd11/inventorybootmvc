package com.dxctraining.inventorymgt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNotFoundException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class UiMain {
	
	@Autowired
	private ISupplierService supplierService;
	
	@Autowired
	private IItemService itemService;
	
	@PostConstruct
	public void runUi() {
		try {
			List<Item> list = new ArrayList<>();
			Supplier supplier1 = new Supplier("Arshad","11");
			supplierService.add(supplier1);
			Supplier supplier2 = new Supplier("adil","2222");
			supplierService.add(supplier2);
			
			
			Item item1 = new Item("phone", supplier1);
			list.add(item1);
			
			Item item2 = new Item("Computer", supplier2);
			list.add(item2);
		
		
			List<Phone> plist = new ArrayList<>();
			List<Computer> clist = new ArrayList<>();
		
			
			Phone p1 = new Phone("Oneplus", 128);
			plist.add(p1);
			itemService.add(p1);
			
			Computer c1 = new Computer("Hp",512);
			clist.add(c1);
			itemService.add(c1);
			Computer c2 = new Computer("Dell",16);
			clist.add(c2);
			itemService.add(c2);
			
			System.out.println("*****Fetching supplier by id*****");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findSupplierById(id1);
			System.out.println("fetched id is "+fetched.getId()+" fetched supplier = "+fetched.getName());
			
			
			System.out.println("******Fetching item by id******");
			int itemid1 = item1.getId();
			Phone itemfetched = itemService.findPhoneById(itemid1);
			Supplier itemSupplier = itemfetched.getSupplier();
			System.out.println("fetched item id is "+itemid1+" fetched item name is "+itemfetched.getName()+" item supplier is "+itemSupplier.getName());
			
			System.out.println("*****Displaying all items*****");
			for(Item item:list) {
				displayAllItems(item);
			}
			
		}catch (InvalidArgumentException e) {
			e.printStackTrace();
		}catch (SupplierNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void displayAllItems(Item item) {
		// TODO Auto-generated method stub
		
	}
	}
	