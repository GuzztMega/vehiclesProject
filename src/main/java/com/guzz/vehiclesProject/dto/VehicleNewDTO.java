package com.guzz.vehiclesProject.dto;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

public class VehicleNewDTO {

	@NotEmpty(message = "Required field")
    @Length(min = 5, max = 80, message = "The name must be between 5 and 80 characters long")
    private String name;

    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 80, message = "The name must be between 5 and 80 characters long")
    private String assembler;

    @NotEmpty(message = "Required field. Inser the year of the vehicle")
    @NumberFormat
    private Integer year;

    VehicleNewDTO(){}

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
