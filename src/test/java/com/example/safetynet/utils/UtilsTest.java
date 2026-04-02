package com.example.safetynet.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    private static DateUtils dateUtils;

    @Test
    public void calculateAgeTest(){
        String birthdate = "11/08/2000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(birthdate, formatter);
        int testedAge = Period.between(birthDate, LocalDate.now()).getYears();
        int age = 25;
        assertEquals(age, testedAge);
    }
}


