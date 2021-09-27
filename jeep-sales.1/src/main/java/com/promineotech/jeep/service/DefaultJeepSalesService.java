package com.promineotech.jeep.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.entity.JeepModel;
import com.promineotech.entity.Jeeps;
import com.promineotech.jeep.dao.JeepSalesDao;


@Service
public class DefaultJeepSalesService implements JeepSalesService {
	Logger logged = LoggerFactory.getLogger(DefaultJeepSalesService.class);
	
	@Autowired
	private JeepSalesDao jeepSalesDao;
	
	@Override
	public List<Jeeps> fetchJeeps(JeepModel model, String trim) {
		logged.info("The fetchJeeps method was called with model = {} "
				+ "and trim = {}", model, trim);
		
		List<Jeeps> jeeps = jeepSalesDao.fetchJeeps(model, trim);
		Collections.sort(jeeps);
		return jeeps;
	}

}
