package com.trial.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
	
	private Logger logger =  LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sampleApi")
	//@Retry(name="sample-api", fallbackMethod="hardcodedFallbackResponseMethod")
	//@CircuitBreaker(name="default", fallbackMethod="hardcodedFallbackResponseMethod")
	@RateLimiter(name="default")
	public String sampleApi() {
		logger.info("sample API Call received");
		/*
		 * ResponseEntity<String> forEntity = new
		 * RestTemplate().getForEntity("localhost:8080/some-dummy-url",String.class);
		 * return forEntity.getBody();
		 */
		return "sample api";
	}
	
	public String hardcodedFallbackResponseMethod(Exception ex) {
		return "Server-down!!! Fallback Response! "+ ex;
	}
}
