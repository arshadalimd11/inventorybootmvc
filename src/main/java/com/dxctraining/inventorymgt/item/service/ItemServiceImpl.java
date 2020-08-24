package com.dxctraining.inventorymgt.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ItemServiceImpl implements IItemService{
	@Autowired
    private IItemDao dao;
	
	@Override
    public Computer findComputerById(int id) {
       Computer computer= dao.findComputerById(id);
        return computer;
    }
	@Override
    public Phone findPhoneById(int id) {
       Phone phone= dao.findPhoneById(id);
        return phone;
    }
	 @Override
	    public Computer add(Computer computer) {
	        validate(computer);
	        computer=dao.add(computer);
	        return computer;
	    }
	 @Override
	    public Phone add(Phone phone) {
	        validate(phone);
	        phone=dao.add(phone);
	        return phone;
	    }
	 
	 @Override
	    public void removeComputer(int id) {
	       dao.removeComputer(id);
	    }
	 @Override
	    public void removePhone(int id) {
	       dao.removePhone(id);
	    }
	   public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Argument is null ");
	        }
	    }
	   @Override
	    public List<Computer> allComputer(){
	        List<Computer>allcomputer=dao.allComputer();
	        return allcomputer;
	    }
	   @Override
	    public List<Phone> allPhone(){
	        List<Phone>allPhone=dao.allPhone();
	        return allPhone;
	    }

}