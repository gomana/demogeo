package com.geo.bo;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class BoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Bean
	public JtsModule jtsModule(){
		return new JtsModule();
	}
}
