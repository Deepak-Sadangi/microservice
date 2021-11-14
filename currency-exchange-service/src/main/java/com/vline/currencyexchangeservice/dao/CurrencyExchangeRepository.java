package com.vline.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vline.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromAndTo(String from, String to);
}
