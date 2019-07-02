package org.springframework.samples.petclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
	@Autowired
	private BillService billservice;
	
	/*@RequestMapping(value="/bills", method=RequestMethod.GET)
	public List<Bill> findAll(){
		return this.billservice.findAll();
	}*/
	
	/*@RequestMapping(value="/bills/{idBill}",method=RequestMethod.GET)
	public ResponseEntity<Bill> findById(@PathVariable("idBill") Integer id) {
		Bill b = this.billservice.findById(id);
		
		if(b != null) {
			return ResponseEntity.status(HttpStatus.OK).body(b);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}*/
	
	@RequestMapping(value="/bills", method=RequestMethod.POST)
	public Bill insertarBill (@RequestBody Bill miFactura){
		Bill insertarBill = billservice.insertarBill(miFactura);
		return insertarBill;
	}
	
	@RequestMapping(value="/bills/{idBill}", method=RequestMethod.PUT)
	public Bill updateBill (@RequestBody Bill miFactura, @PathVariable("idBill") Integer id){
		Bill bbdd  = this.billservice.findById(id);
		Bill updateBill = null;
		
		if(bbdd != null) {
			miFactura.setId(bbdd.getId());
			updateBill = billservice.updateBill(miFactura);
		}
		return updateBill;
	}
	
	@RequestMapping(value="/bills/{idBill}", method=RequestMethod.DELETE)
	public ResponseEntity<Bill> findByIdx(@PathVariable("idBill") Integer id){
		Bill bbdd  = this.billservice.findById(id);

		if( bbdd != null) {
			this.billservice.deletebill(id);
			return ResponseEntity.status(HttpStatus.OK).body(bbdd);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@RequestMapping(value="/bills", method=RequestMethod.DELETE)
	public void deleteAllBills(){
		this.deleteAllBills();
	}
	
	@RequestMapping(value="/bills?filter=", method=RequestMethod.GET)
	public List<Bill> selectconfiltro(@RequestParam("pagadas") String string){
		return billservice.selectfiltro();
	}
	
}