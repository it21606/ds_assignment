package com.distributedsystems;

import com.distributedsystems.model.Application;
import com.distributedsystems.repository.ApplicationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Test
	public void contextLoads() {

	}
	@Test
	public void  findbyId() {
		int id = 1;
		int income = 100;
		Application application = applicationRepository.findById(id);
		assertEquals(application.getIncome(),income);
	}

}
