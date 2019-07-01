package org.springframework.samples.petclinic.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Service;

@Service
public class VetService {
	
	@Autowired
	private VetRepository vetRepository;
	
	public Collection<Vet> findById(int id) {
		return this.vetRepository.findAll();
	}
}