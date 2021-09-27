package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.web.client.RestTemplate;

import com.promineotech.entity.JeepModel;
import com.promineotech.entity.Jeeps;
import com.promineotech.jeep.JeepSales;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;

@SpringBootTest(classes = JeepSales.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:migrations/V1.0__Jeep_Schema.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))

class FetchJeepTest extends FetchJeepTestSupport {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test 
	void dbTest(){
		int numRows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "customers");
		System.out.println(numRows);
	}
	@Test
	void testThatJeepsAreReturnedInAValidJeepModelAndTrim() {
    //given a valid model trim and URI
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
      String uri = String.format("%s?model=%s&trim=%s",getBaseUri(),model,trim);
      
    //when a connection is made to the URI
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<List<Jeeps>> response = 
    		  restTemplate.exchange(uri, HttpMethod.GET, null, 
            		  new ParameterizedTypeReference<>() {});
    
    //then a list of jeeps are returned - a status code
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    // and the actual list returned is the same as the expected list
    List<Jeeps> actual = response.getBody();
    List<Jeeps> expected = buildExpected();
//    actual.forEach(jeep -> jeep.setModelPK(null));
    
    assertThat(actual).isEqualTo(expected);
	}
  }
