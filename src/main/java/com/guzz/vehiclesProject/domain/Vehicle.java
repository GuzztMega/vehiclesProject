package com.guzz.vehiclesProject.domain;

import javax.persistence.*;

@Entity
@Table(name = "veiculos")
public class Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String assembler;
    private Integer year;	

    public Vehicle(){}

    public Vehicle(Integer id, String name, String assembler, Integer year) {
        this.id = id;
        this.name = name;
        this.assembler = assembler;
        this.year = year;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssembler() {
		return assembler;
	}

	public void setAssembler(String assembler) {
		this.assembler = assembler;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

    
}
