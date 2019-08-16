package com.codeclan.dinopark.DinoPark;

import com.codeclan.dinopark.DinoPark.models.Herbivore;
import com.codeclan.dinopark.DinoPark.models.HerbivoreType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DinoParkApplicationTests {

	Herbivore herbivore;

	@Before
	public void setUp() {
		herbivore = new Herbivore("Monty", true,100, HerbivoreType.ATOPODENTATUS);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void hasName() {
		assertEquals("Monty", herbivore.getName());
	}

	@Test
	public void isHerbivore() {
		assertEquals(true, herbivore.isHerbivore());
	}

	@Test
	public void hasFullnessLevel() {
		assertEquals(100, herbivore.getFullnessLevel());
	}

}
