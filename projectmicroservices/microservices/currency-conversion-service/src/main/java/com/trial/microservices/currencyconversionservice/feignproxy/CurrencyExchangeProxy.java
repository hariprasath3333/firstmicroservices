package com.trial.microservices.currencyconversionservice.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trial.microservices.currencyconversionservice.pojo.CurrencyConversion;


//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
@Component
public interface CurrencyExchangeProxy {
	
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
