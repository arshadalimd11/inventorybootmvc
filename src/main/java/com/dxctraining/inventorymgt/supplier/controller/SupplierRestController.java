
package com.dxctraining.inventorymgt.supplier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@RestController
@RequestMapping("/suppplier")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public Supplier create(@RequestBody CreateSupplierRequest supplierData) {
		Supplier supplier=new Supplier(supplierData.getName(),supplierData.getPassword());
		supplier=service.add(supplier);
		return supplier;
	}
	
	@GetMapping("/get/{id}")
	public Supplier findSupplier(@PathVariable("id") int id) {
		Supplier supplier=service.findSupplierById(id);
		return supplier;
	}
	@PutMapping("/update")
	public Supplier updateSupplier(@RequestBody UpdateSupplierRequest supplierData) {
		Supplier supplier=new Supplier(supplierData.getName(),supplierData.getPassword());
		supplier.setId(supplierData.getId());
		supplier=service.add(supplier);
		return supplier;
	}
	

}