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
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class ComputerController {
	@Autowired
	private IItemService service;
	
	@Autowired
	private ISupplierService service2;
	
	@PostConstruct
	public void init() {
		Supplier supplier1=new Supplier("Arshad","123");
		service2.add(supplier1);
		Computer computer1=new Computer("hp",400);
		service.add(computer1);
	}
	
	@GetMapping("/listallcmp")
    public ModelAndView allComputers(){
    	 List<Computer>computer=service.allComputer();
        ModelAndView modelAndView=new ModelAndView("clist","computer",computer);
        return modelAndView;
    }
	@GetMapping("/viewComputerDet")
    public ModelAndView computerDetails(@RequestParam("id")int id){
       Computer computer=service.findComputerById(id);
       ModelAndView modelAndView=new ModelAndView("cdetails","computer",computer);
       return modelAndView;
    }
	@GetMapping("/addComputer")
    public ModelAndView computerPage(){
        ModelAndView modelView=new ModelAndView("addComputer");
        return modelView;
    }
    @GetMapping("/processAddComputer")
    public ModelAndView processRegisterComputer(@RequestParam("computername") String name,@RequestParam("discSize") int discSize){
        Computer computer=new Computer(name,discSize);
        computer=service.add(computer);
        ModelAndView modelView=new ModelAndView("cdetails","computer",computer);
        return modelView;
    }
    @GetMapping("/postAddComputer")
    public ModelAndView postRegisteringComputer(){
        CreateComputerRequest computerData=new CreateComputerRequest();
        ModelAndView modelView=new ModelAndView("postAddComputer","computer",computerData);
        return modelView;
    }
    @PostMapping("/processpostaddComputer")
    public ModelAndView processRegisterComputer(@ModelAttribute("computer") CreateComputerRequest computerData){
        Computer computer=new Computer(computerData.getItemname(),computerData.getDiscSize());
        computer=service.add(computer);
        ModelAndView mv=new ModelAndView("cdetails","computer",computer);
        return mv;
    }


}