package com.vline.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vline.currencyexchangeservice.bean.CurrencyExchange;
import com.vline.currencyexchangeservice.dao.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeServiceController {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeServiceController.class);

	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue (@PathVariable String from, @PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for : "+ from +" to "+ to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		logger.warn("Service running on port: "+currencyExchange.getEnvironment());
		
		return currencyExchange;
	}
}
