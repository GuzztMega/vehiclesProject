package com.guzz.vehiclesProject.dto;

import com.guzz.vehiclesProject.domain.Vehicle;

public class VehicleDTO {
	
	private Integer id;
	private String name;
    private String assembler;
    private Integer year;

    public VehicleDTO(){}
    
    public VehicleDTO(Vehicle obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.assembler = obj.getAssembler();
		this.year = obj.getYear();
	}
    
    public VehicleDTO(Integer id, String name, String assembler, Integer year) {
		super();
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
