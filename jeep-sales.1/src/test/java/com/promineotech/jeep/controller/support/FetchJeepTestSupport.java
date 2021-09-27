package com.promineotech.jeep.controller.support;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.promineotech.entity.JeepModel;
import com.promineotech.entity.Jeeps;

public class FetchJeepTestSupport extends BaseTest  {

  public static List<Jeeps> buildExpected() {
			List<Jeeps> list = new LinkedList<>();
			//// @formatter:off
			list.add(Jeeps.builder().modelId(JeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(2)
				.wheelSize(17)
				.basePrice(new BigDecimal("28475.00"))
				.build());
					
			list.add(Jeeps.builder().modelId(JeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(4)
				.wheelSize(17)
				.basePrice(new BigDecimal("31975.00"))
				.build());
			// @formatter:on
			Collections.sort(list);
			return list;
		}  

  }
