/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 * @author Dave Syer
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    /**
     * Holds value of property date.
     */
    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;

    /**
     * Holds value of property pet.
     */
    @Column(name = "pet_id")
    private Integer petId;


    /**
     * Creates a new instance of Visit for the current date
     */
    public Visit() {
        this.date = new Date();
    }


    /**
     * Getter for property date.
     *
     * @return Value of property date.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Setter for property date.
     *
     * @param date New value of property date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for property description.
     *
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     *
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property pet id.
     *
     * @return Value of property pet id.
     */
    public Integer getPetId() {
        return this.petId;
    }

    /**
     * Setter for property pet id.
     *
     * @param petId New value of property pet id.
     */
    public void setPetId(Integer petId) {
        this.petId = petId;
    }
    
    // Hibernate
    
    @OneToOne(fetch = FetchType.LAZY)
    private Bill bill;

    @JsonBackReference
    public Bill getBill() {
	return bill;
    }

    public void setBill(Bill bill) {
 	this.bill = bill;
    }
    
    public String toString() {
    	String mensaje = "";
    	
    	mensaje += "Visita con id: " + this.getId() + "\n";
    	mensaje += "==================\n";
    	mensaje += "Fecha: " + this.getDate() +"\n";
    	mensaje += "Descripcion: " + this.getDescription() +"\n";
    	mensaje += "Id de factura: " + ((this.getBill() == null || (this.getBill() != null && this.getBill().getId() == null)) ? "No existe" : this.getBill().getId()) +"\n";
    		
    	return mensaje;
    }



}
