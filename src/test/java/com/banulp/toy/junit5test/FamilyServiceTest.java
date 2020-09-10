package com.banulp.toy.junit5test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    private FamilyService s;

    @BeforeEach
    void setUp() {
        s = new FamilyService();
    }

    @Test
    void getFamilyName() {
        assertEquals(s.getFamilyName(1), "ys");
    }
}