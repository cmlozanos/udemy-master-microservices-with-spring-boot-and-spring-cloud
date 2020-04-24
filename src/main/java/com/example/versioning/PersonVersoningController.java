package com.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * In this Controller resume the ways to versioning a bean from lower to higher used style
 * @author Carlos Lozano
 *
 */

@RestController
public class PersonVersoningController {
	
	/**
	 * Parameter versioning
	 * @return
	 */
	@GetMapping(value="/person", params="version=1")
	public PersonV1 personParamsV1() {
		return new PersonV1("Bob");
	}
	
	/**
	 * Parameter versioning
	 * @return
	 */
	@GetMapping(value="/person", params="version=2")
	public PersonV2 personParamsV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	/**
	 * Header versioning
	 * @return
	 */
	@GetMapping(value="/person", headers="x-api-version=1")
	public PersonV1 personHeadersV1() {
		return new PersonV1("Bob");
	}
	
	/**
	 * Header versioning
	 * @return
	 */
	@GetMapping(value="/person", headers="x-api-version=2")
	public PersonV2 personHeadersV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	/**
	 * Media Type versioning
	 * @return
	 */
	@GetMapping(value="/person", produces="application/vnd.company.app-v1+json")
	public PersonV1 personProducesV1() {
		return new PersonV1("Bob");
	}
	
	/**
	 * Media Type versioning
	 * @return
	 */
	@GetMapping(value="/person", produces="application/vnd.company.app-v2+json")
	public PersonV2 personProducesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	
}
