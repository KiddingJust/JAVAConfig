package org.kidding.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kidding.config.RootConfig;
import org.kidding.mapper.TimeMapper;
import org.kidding.service.SampleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTest {

	@Setter(onMethod_=@Autowired)
	private SampleBean bean;
	
	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	
	@Setter(onMethod_= @Autowired)
	private TimeMapper mapper;
	

	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testCon() {
		try(Connection con = ds.getConnection()){
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExist() {
		log.info("--------------------");
		log.info(bean.doA("dfadfaf"));
		log.info("--------------------");
		log.info("--------------------");

	}
	
	@Test
	public void testTransaction() {

		String str = "앞뒤가 똑같은 전화번호";
		
		bean.doB(str);

	}
}
