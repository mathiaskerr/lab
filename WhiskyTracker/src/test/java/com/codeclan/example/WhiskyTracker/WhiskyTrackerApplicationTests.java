package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	private WhiskyRepository whiskyRepository;
	@Autowired
	private DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskyByYear() {
		List<Whisky> foundWhisky = whiskyRepository.findByYear(2018);
		assertEquals(6,foundWhisky.size());
	}

	@Test
	public void canFindByDistilleryAndAge(){
		Distillery distillery = distilleryRepository.getById(5L);
		String value = distillery.getName();
		List<Whisky> foundWhisky = whiskyRepository.findByDistilleryNameAndAge(value, 12);
		assertEquals("Viking Honour",foundWhisky.get(0).getName());
	}
	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistillery = distilleryRepository.findByRegion("Island");
		assertEquals(3,foundDistillery.size());
	}

}
