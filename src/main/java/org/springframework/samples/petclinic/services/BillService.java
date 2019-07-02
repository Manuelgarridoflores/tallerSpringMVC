package org.springframework.samples.petclinic.services;

import java.util.ArrayList;
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
	
	public Bill insertarBill(Bill bill)  {
		return billRepository.save(bill);
	}
	
	public Bill updateBill(Bill bill)  {
		return billRepository.save(bill);
	}
	
	public void deletebill(Integer id)  {
		billRepository.delete(id);
	}
	
	public List<Bill> selectfiltro()  {
		List<Bill> bbdd  = findAll();
		
		List<Bill> lista = new ArrayList<Bill>();
		
		for(int i=0; i>= bbdd.size(); i++) {
			if(bbdd.get(i).getVisit() != null) {
				lista.add(bbdd.get(i));
			}
		}
		return lista;
	}
	
	
}