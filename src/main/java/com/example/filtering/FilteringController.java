package com.example.filtering;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		Set<String> fields = new HashSet<>();
		fields.add("field1");
		fields.add("field2");
		String filterName = "SomeBeanFilter";
		
		return getMapping(someBean, fields, filterName);
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveSomeBeans() {
		List<SomeBean> beans = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value21", "value22", "value23"));
		
		Set<String> fields = new HashSet<>();
		fields.add("field2");
		fields.add("field3");
		String filterName = "SomeBeanFilter";
		
		return getMapping(beans, fields, filterName);
	}
	
	private MappingJacksonValue getMapping(Object object, Set<String> fields, String filterName) {
		MappingJacksonValue mapping = new MappingJacksonValue(object);
		SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName,  beanPropertyFilter );
		mapping.setFilters(filterProvider );
		return mapping;
	}
	
}
