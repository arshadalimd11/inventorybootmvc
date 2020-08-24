package com.dxctraining.inventorymgt.item.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.exceptions.ItemNotFoundException;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Repository
public class ItemDaoImpl implements IItemDao{
	@PersistenceContext
    private EntityManager entityManager;
	
	 @Override
	    public Computer findComputerById(int id) {
	        Computer computer=entityManager.find(Computer.class,id);
	        if(computer==null){
	            throw new ItemNotFoundException("computer not found for id="+id);
	        }
	        return computer;
	    }
	 @Override
	    public Phone findPhoneById(int id) {
	        Phone phone=entityManager.find(Phone.class,id);
	        if(phone==null){
	            throw new ItemNotFoundException("phone not found for id="+id);
	        }
	        return phone;
	    }
	 @Override
	    public Computer add(Computer computer) {
	        entityManager.persist(computer);
	        return computer;
	    }
	 @Override
	    public Phone add(Phone phone) {
	        entityManager.persist(phone);
	        return phone;
	    }
	 @Override
	    public void removeComputer(int id) {
	     Computer computer= findComputerById(id) ;
	     entityManager.remove(computer);
	    }
	 @Override
	    public void removePhone(int id) {
	     Phone phone= findPhoneById(id) ;
	     entityManager.remove(phone);
	    }
	 @Override
	    public List<Computer> allComputer() {
	        String jpaql=" Computer";
	        TypedQuery<Computer>query=entityManager.createQuery(jpaql,Computer.class);
	        List<Computer>computerList=query.getResultList();
	        return computerList;
	    }
	 @Override
	    public List<Phone> allPhone() {
	        String jpaql=" Phone";
	        TypedQuery<Phone>query=entityManager.createQuery(jpaql,Phone.class);
	        List<Phone>phoneList=query.getResultList();
	        return phoneList;
	    }


}