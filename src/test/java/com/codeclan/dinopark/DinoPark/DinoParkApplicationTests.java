package com.codeclan.dinopark.DinoPark;

import com.codeclan.dinopark.DinoPark.models.Paddock;
import com.codeclan.dinopark.DinoPark.repositories.PaddockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DinoParkApplicationTests {

	@Autowired
	PaddockRepository paddockRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreatePaddock() {
		Paddock paddock = new Paddock(true);
		paddockRepository.save(paddock);
		assertEquals(new Long(1), paddock.getId());
	}

}
