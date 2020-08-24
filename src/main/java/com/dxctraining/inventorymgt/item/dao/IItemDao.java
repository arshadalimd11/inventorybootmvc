package com.dxctraining.inventorymgt.item.dao;

import java.util.List;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Phone;

public interface IItemDao {
	
	Computer findComputerById(int id);
	Phone findPhoneById(int id);
    Computer add(Computer Computer);
    Phone add(Phone phone);
    void removeComputer(int id);
    void removePhone(int id);
    List<Computer> allComputer();
    List<Phone> allPhone();
    
}