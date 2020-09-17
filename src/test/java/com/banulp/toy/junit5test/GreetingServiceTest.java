package com.banulp.toy.junit5test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

    @Mock
    private FamilyService familyService;

    @InjectMocks
    private GreetingService greetingService;

    @BeforeEach
    void setup() {
    }

    @Test
    void greetingToFamily() {
        when(familyService.getFamilyName(1)).thenReturn("banulp");
        assertThat( greetingService.greetingToFamily(1)).isEqualTo("hello banulp");
    }
}