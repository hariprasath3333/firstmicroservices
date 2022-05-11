package com.trial.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.microservices.currencyexchangeservice.pojo.CurrencyExchange;

public interface CurrencyExchangeRepository  extends JpaRepository<CurrencyExchange, Long>{
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
