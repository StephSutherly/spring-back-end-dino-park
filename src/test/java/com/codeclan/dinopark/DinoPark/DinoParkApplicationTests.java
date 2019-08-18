package com.codeclan.dinopark.DinoPark;
import com.codeclan.dinopark.DinoPark.models.*;
import com.codeclan.dinopark.DinoPark.repositories.dinosaur_repository.DinosaurRepository;
import org.junit.Before;
import com.codeclan.dinopark.DinoPark.models.Paddock;
import com.codeclan.dinopark.DinoPark.repositories.paddock_repository.PaddockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DinoParkApplicationTests {

	@Autowired
	PaddockRepository paddockRepository;

	@Autowired
	DinosaurRepository dinosaurRepository;
	
	Herbivore herbivore;
	Carnivore carnivore;
	Paddock paddockHerbi;
	Paddock paddockCarni;
	Paddock paddock;


	@Before
	public void setUp() {
		paddock = new Paddock(true);
		paddockRepository.save(paddock);

		paddockHerbi = new Paddock(true);
		paddockRepository.save(paddockHerbi);

		paddockCarni = new Paddock(false);
		paddockRepository.save(paddockCarni);

		herbivore = new Herbivore("Monty", true,100, HerbivoreType.ATOPODENTATUS, paddockHerbi);
		carnivore = new Carnivore("Toothy", false,50, CarnivoreType.SPINOSAURUS, paddockHerbi);

		paddock.addDinosaur(herbivore);

		dinosaurRepository.save(herbivore);
		paddock.addDinosaur(carnivore);
		dinosaurRepository.save(carnivore);
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
		assertEquals(new Long(19), paddock.getId());
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

	@Test
	public void dinoHasPaddock() {
		assertEquals(paddockHerbi, herbivore.getPaddock());
	}

	@Test
	public void canChangePaddock() {
		assertEquals(paddockHerbi, carnivore.getPaddock());
		carnivore.setPaddock(paddockCarni);
		assertEquals(paddockCarni, carnivore.getPaddock());
	}

	@Test
	public void canFindDinosaurByPaddockId() {
		List<Dinosaur> found = dinosaurRepository.findDinosaurByPaddockId(2L);
		assertEquals(2, found.size());
	}

	public void canFindPaddocksByDinosaurName() {
		List<Paddock> found = paddockRepository.findPaddocksWithDinosaursNamed("Monty");
		assertEquals(new Long(1), found.get(0).getId());
	}

}
