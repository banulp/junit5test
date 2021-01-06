package com.banulp.toy.junit5test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

@DisplayName("\uD83D\uDE0D \uD83D\uDE3B \uD83D\uDC69\u200D\uD83C\uDF3E")
class FamilyServiceTest {

//    private FamilyService s;
//    @BeforeEach
//    void setUp() {
//        s = new FamilyService();
//    }

    private final FamilyService s = new FamilyService();

    @Test
    void getFamilyName() {
        assertEquals("ys", s.getFamilyName(1));
        assertEquals("hy", s.getFamilyName(2));
    }

    @Test
    void getFamilyName1() {
        assumingThat("ny".equals(s.getFamilyName(3)),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals("hy", s.getFamilyName(2));
                });

        assumeTrue("ny".equals(s.getFamilyName(3)));
        assertThat(s.getFamilyName(1), is(equalTo("ys")));
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9})
    void getFamilyName2(int bestOrder) {
        assertThat(s.getFamilyName(bestOrder), is(equalTo("my Family")));
    }

    @ParameterizedTest
    @EnumSource(RelationGrades.class)
    void testWithEnumSource(RelationGrades unit) {
        assertNotNull(unit);
    }

    @ParameterizedTest
    @EnumSource(names = {"BEST", "GOOD"})
//  그냥 pojo는 public static 있는거 찾아서
    void testWithEnumSourceInclude(RelationGrades unit) {
        assertTrue(EnumSet.of(RelationGrades.BEST, RelationGrades.GOOD).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(mode = MATCH_ALL, names = "^.*BAD$")
    void testWithEnumSourceRegex(RelationGrades unit) {
        assertTrue(EnumSet.of(RelationGrades.NOTBAD, RelationGrades.BAD).contains(unit));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource
    void testWithDefaultLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testWithDefaultLocalMethodSource() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }
}