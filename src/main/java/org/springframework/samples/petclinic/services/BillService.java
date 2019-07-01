package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repository.BillRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	@Autowired
	private BillRepository billRepository;
	
	public List<Bill>findAll(){
		return this.billRepository.findAll();
	}
	
	public Bill findById(Integer id) {
		return this.billRepository.findOne(id);
	}
}