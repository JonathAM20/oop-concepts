package br.com.cleoassistant.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncapsulationTest {

	@Test
	public void testGetClassNamePattern() {
		Encapsulation encapsulation = new Encapsulation();
		String[] oneWordNameTest = {"word1"};
		String[] twoWordsNameTest = {"word1","word2"};

		//Class name tests
		//test 1
		encapsulation.setClassNamePattern(oneWordNameTest);
		System.out.println(encapsulation.getClassNamePattern());
		assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(0)));
		//test 2
		encapsulation.setClassNamePattern(twoWordsNameTest);
		System.out.println(encapsulation.getClassNamePattern());
		assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(0)));
		assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(twoWordsNameTest[0].length())));

		//Field name tests
		//Test 1
		encapsulation.setFieldNamePattern(oneWordNameTest);
		System.out.println(encapsulation.getFieldNamePattern());
		assertTrue(Character.isLowerCase(encapsulation.getFieldNamePattern().charAt(0)));
		//Test 2 
		encapsulation.setFieldNamePattern(twoWordsNameTest);
		System.out.println(encapsulation.getFieldNamePattern());
		assertTrue(Character.isLowerCase(encapsulation.getFieldNamePattern().charAt(0)));
		assertTrue(Character.isUpperCase(encapsulation.getFieldNamePattern().charAt(twoWordsNameTest[0].length())));
	}
}
