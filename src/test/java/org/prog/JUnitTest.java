package org.prog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JUnitTest {

    @BeforeAll
    public static void setUp() {
        System.out.println("Tests start!");
    }

    @BeforeEach
    public void beforeTest() {
        System.out.println("=========TEST START=============");
    }

    @AfterEach
    public void afterTest() {
        System.out.println("=========TEST END=============");
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void myTest(String input) {
        System.out.println(input);
    }

    @Test
    public void myTest2() {
        System.out.println("Test 2");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Tests end!");
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("string 1"),
                Arguments.of("string 2"),
                Arguments.of("string 3"),
                Arguments.of("string 4"),
                Arguments.of("string 5"),
                Arguments.of("string 6")
        );
    }
}
