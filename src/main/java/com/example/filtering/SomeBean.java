package com.example.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@Data
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	private final String field1;
	private final String field2;
	private final String field3;
	
}
