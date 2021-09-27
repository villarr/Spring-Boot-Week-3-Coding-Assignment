package com.promineotech.jeep.service;

import java.util.List;

import com.promineotech.entity.JeepModel;
import com.promineotech.entity.Jeeps;

public interface JeepSalesService {

	List<Jeeps> fetchJeeps(JeepModel model, String trim);

}
