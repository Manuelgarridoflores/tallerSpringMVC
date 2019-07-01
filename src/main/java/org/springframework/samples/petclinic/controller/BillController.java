package org.springframework.samples.petclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
	@Autowired
	private BillService billservice;
	
	@RequestMapping(value="/bills", method=RequestMethod.GET)
	public List<Bill> findAll(){
		return this.billservice.findAll();
	}
	
	@RequestMapping(value="/bills/{idBill}",method=RequestMethod.GET)
	public Bill findById(@PathVariable("idBill") Integer id) {
		Bill b = this.billservice.findById(id);
		return b;
	}
}