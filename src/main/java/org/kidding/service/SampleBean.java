package org.kidding.service;

import org.kidding.mapper.TimeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class SampleBean {

	private TimeMapper mapper;
	
	public String doA(String name) {
		
		return new StringBuffer(name).reverse().toString();
	}
	
	@Transactional
	public void doB(String str) {
		
		int result1 = mapper.insert1(str);
		int result2 = mapper.insert2(str);
		log.info(result1 + " : " + result2);
	}
}
