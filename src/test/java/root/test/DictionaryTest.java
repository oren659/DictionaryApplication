package root.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import root.controller.RecieverController;

/**
 * This class holds the tests of the dictionary application the tests assume
 * that there are specific phrases in the DaoService, we should consider having
 * the phrases in this class in order to decouple them from the current phrases
 * in the DaoService. 
 * It is also very useful to use this class during
 * development (TDD) in order to test the correctness of the algorithm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryTest {

	@Autowired
	private RecieverController controller;

	@Test
	public void test1() throws Exception {
		final String input1 = "Vice President of Sales and Marketing";
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("Sales", 18);
		map1.put("Vice President", 0);
		map1.put("Marketing", 28);
		assertTrue(map1.equals(controller.handleMessage(input1)));
	}

	@Test
	public void test2() throws Exception {
		final String input2 = "u2 counting crows cranberries";
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("u2 counting crows cranberries", 0);
		assertTrue(map2.equals(controller.handleMessage(input2)));
	}

	@Test
	public void test3() throws Exception {
		final String input3 = "mom tiger u2 counting crows cranberries";
		Map<String, Integer> map3 = new HashMap<>();
		map3.put("mom", 0);
		map3.put("u2 counting crows cranberries", 10);
		assertTrue(map3.equals(controller.handleMessage(input3)));
	}

	@Test
	public void test4() throws Exception {
		final String input4 = "tiger mom President wolf tiger dog counting CTO cranberries";
		Map<String, Integer> map4 = new HashMap<>();
		map4.put("mom", 6);
		map4.put("President", 10);
		map4.put("dog", 31);
		map4.put("CTO", 44);
		assertTrue(map4.equals(controller.handleMessage(input4)));
	}

	@Test
	public void test5() throws Exception {
		final String input5 = "u2 Boy counting crows cranberries Marketing Banking CFO CfO ron President";
		Map<String, Integer> map5 = new HashMap<>();
		map5.put("President", 64);
		map5.put("Banking CFO CfO ron", 44);
		map5.put("counting crows", 7);
		map5.put("Boy", 3);
		map5.put("Marketing", 34);
		assertTrue(map5.equals(controller.handleMessage(input5)));
	}

	@Test
	public void test6() throws Exception {
		final String input6 = "wolf dog tiger";
		Map<String, Integer> map6 = new HashMap<>();
		map6.put("dog", 5);
		assertTrue(map6.equals(controller.handleMessage(input6)));
	}

	@Test
	public void test7() throws Exception {
		final String input7 = "wolf   dog tiger";
		Map<String, Integer> map7 = new HashMap<>();
		map7.put("dog", 7);
		assertTrue(map7.equals(controller.handleMessage(input7)));
	}

	@Test
	public void test8() throws Exception {
		final String input8 = "";
		Map<String, Integer> map8 = new HashMap<>();
		assertTrue(map8.equals(controller.handleMessage(input8)));
	}

	@Test
	public void test9() throws Exception {
		final String input9 = "Vice President mom mom mom mom mom mom dog mom counting crows Marketing Sales Dog";
		Map<String, Integer> map9 = new HashMap<>();
		map9.put("Sales", 72);
		map9.put("counting crows", 47);
		map9.put("Vice President", 0);
		map9.put("mom", 43);
		map9.put("dog", 39);
		map9.put("Marketing", 62);
		assertTrue(map9.equals(controller.handleMessage(input9)));
	}

	@Test
	public void test10() throws Exception {
		final String input10 = "dogdogdog mommommom";
		Map<String, Integer> map10 = new HashMap<>();
		assertTrue(map10.equals(controller.handleMessage(input10)));
	}
}