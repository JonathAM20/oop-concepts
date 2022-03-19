package test.java.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.java.model.Encapsulation;

public class EncapsulationTest {

	private static Encapsulation encapsulation;

	@BeforeAll
	public static void init() {
		encapsulation = new Encapsulation();
	}

	@ParameterizedTest
	@MethodSource("provideOneWord")
	public void testGetNamePatternWithOneWord(String word) {
		String[] words = {word};
		assertAll("Class/Field name pattern test", 
				() -> {
					encapsulation.setClassNamePattern(words);
					assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(0))); 
				}, 
				() -> {
					encapsulation.setFieldNamePattern(words);
					assertTrue(Character.isLowerCase(encapsulation.getFieldNamePattern().charAt(0))); 
				}
				);
	}

	@ParameterizedTest
	@MethodSource("provideTwoWords")
	public void testGetNamePatternWithTwoWords(String word1, String word2) {
		String[] words = {word1, word2};
		assertAll("Class name pattern test", 
				() -> { 
					encapsulation.setClassNamePattern(words);
					assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(0)));
					assertTrue(Character.isUpperCase(encapsulation.getClassNamePattern().charAt(words[0].length()))); 
				},
				() -> { 
					encapsulation.setFieldNamePattern(words);
					assertTrue(Character.isLowerCase(encapsulation.getFieldNamePattern().charAt(0)));
					assertTrue(Character.isUpperCase(encapsulation.getFieldNamePattern().charAt(words[0].length()))); 
				}
				);
	}

	private static Stream<Arguments> provideOneWord() {
		return Stream.of(
				Arguments.of("word1"),
				Arguments.of("wORD1"),
				Arguments.of("WORD1"),
				Arguments.of("woRD1")
				);
	}

	private static Stream<Arguments> provideTwoWords() {
		return Stream.of(
				Arguments.of("word1", "word2"),
				Arguments.of("wORD1", "wORD2"),
				Arguments.of("WORD1", "WORD2"),
				Arguments.of("woRD1", "woRD2")
				);
	}
}
