package com.promineotech.jeep.dao;

import java.util.List;

import com.promineotech.entity.JeepModel;
import com.promineotech.entity.Jeeps;

public interface JeepSalesDao {

	List<Jeeps> fetchJeeps(JeepModel model, String trim);

}
