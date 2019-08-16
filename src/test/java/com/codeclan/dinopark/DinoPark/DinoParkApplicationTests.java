package com.codeclan.dinopark.DinoPark;
import com.codeclan.dinopark.DinoPark.models.*;
import org.junit.Before;
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
	
	Herbivore herbivore;
	Carnivore carnivore;

	@Before
	public void setUp() {
		herbivore = new Herbivore("Monty", true,100, HerbivoreType.ATOPODENTATUS);
		carnivore = new Carnivore("Toothy", false,50, CarnivoreType.SPINOSAURUS);
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

	@Test
	public void hasType() {
		assertEquals(HerbivoreType.ATOPODENTATUS, herbivore.getType());
	}

	@Test
	public void canCreatePaddock() {
		Paddock paddock = new Paddock(true);
		paddockRepository.save(paddock);
		assertEquals(new Long(1), paddock.getId());
	}

	@Test
	public void carnivoreHasName() {
		assertEquals("Toothy", carnivore.getName());
	}

	@Test
	public void carnivoreIsNotHerbivore() {
		assertEquals(false, carnivore.isHerbivore());
	}

	@Test
	public void carnivoreHasFullnessLevel() {
		assertEquals(50, carnivore.getFullnessLevel());
	}

	@Test
	public void carnivoreHasType() {
		assertEquals(CarnivoreType.SPINOSAURUS, carnivore.getType());
	}

}
