package com.example.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(value= {"field1", "field2"})
public class SomeBean {
	private final String field1;
	private final String field2;
	private final String field3;
	
}
