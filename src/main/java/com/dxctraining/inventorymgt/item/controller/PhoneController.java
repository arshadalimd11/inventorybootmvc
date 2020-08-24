package com.dxctraining.inventorymgt.item.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.item.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class PhoneController {
	@Autowired
	private IItemService service;
	
	@Autowired
	private ISupplierService service2;
	
	
	@PostConstruct
	public void init() {
		Supplier supplier1=new Supplier("Arshu","123");
		Phone phone1=new Phone("samsung",3);
		service2.add(supplier1);
		service.add(phone1);
	}
	@GetMapping("/listallphonedetails")
    public ModelAndView allPhones(){
    	 List<Phone>phone=service.allPhone();
        ModelAndView modelAndView=new ModelAndView("plist","phone",phone);
        return modelAndView;
    }
	@GetMapping("/viewPhoneDet")
    public ModelAndView phoneDetails(@RequestParam("id")int id){
       Phone phone=service.findPhoneById(id);
       ModelAndView modelAndView=new ModelAndView("pdetails","phone",phone);
       return modelAndView;
    }
	@GetMapping("/addPhone")
    public ModelAndView phonePage(){
        ModelAndView modelView=new ModelAndView("addPhone");
        return modelView;
    }
    @GetMapping("/processAddPhone")
    public ModelAndView processRegisterPhone(@RequestParam("phonename") String name,@RequestParam("storageMemory") int storageMemory){
       Phone phone=new Phone(name,storageMemory);
        phone=service.add(phone);
        ModelAndView modelView=new ModelAndView("pdetails","phone",phone);
        return modelView;
    }
    @GetMapping("/postAddPhone")
    public ModelAndView postRegisteringPhone(){
        CreatePhoneRequest phoneData=new CreatePhoneRequest();
        ModelAndView modelView=new ModelAndView("postAddPhone","phone",phoneData);
        return modelView;
    }
    @PostMapping("/processpostaddPhone")
    public ModelAndView processRegisterPhone(@ModelAttribute("phone") CreatePhoneRequest phoneData){
        Phone phone=new Phone(phoneData.getName(),phoneData.getStorageMemory());
        phone=service.add(phone);
        ModelAndView mv=new ModelAndView("pdetails","phone",phone);
        return mv;
    }

}