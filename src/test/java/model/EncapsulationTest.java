package test.java.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.model.Encapsulation;

public class EncapsulationTest {

	@Test
	public void testGetClassNamePattern() {
		Encapsulation encapsulation = new Encapsulation();
		String[] oneWordNameTest = {"word1"};
		String[] twoWordsNameTest = {"word1","word2"};

		assertAll("Class name pattern test",
				() -> {
					encapsulation.setClassNamePattern(oneWordNameTest);			
					assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(0)));
				},
				() -> {
					encapsulation.setClassNamePattern(twoWordsNameTest);
					assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(0)));
					assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(twoWordsNameTest[0].length())));	
				});

		assertAll("Field name pattern test",
				() -> {
					encapsulation.setFieldNamePattern(oneWordNameTest);			
					assertTrue(Character.isLowerCase(encapsulation.getFieldNamePattern().charAt(0)));
				},
				() -> {
					encapsulation.setFieldNamePattern(twoWordsNameTest);			
					assertTrue(Character.isLowerCase(encapsulation.getFieldNamePattern().charAt(0)));
					assertTrue(Character.isUpperCase(encapsulation.getFieldNamePattern().charAt(twoWordsNameTest[0].length())));	
				});
	}
}
