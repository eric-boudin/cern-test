package org.example;

import org.example.entities.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnit4.class)
public class FirstExerciseTest {

    @Test
    public void checkDuplicateStringTest() {
        List<String> duplicateString = Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d");
        List<String> result = FirstExercise.checkDuplicate(duplicateString);
        List<String> expectedResult = Arrays.asList("a", "c", "d");

        assertEquals(expectedResult, result);
    }

    @Test
    public void checkDuplicateIntegerTest() {
        List<Integer> duplicateInteger = Arrays.asList(1,4,4,3,1,4,6);
        List<Integer> result = FirstExercise.checkDuplicate(duplicateInteger);
        List<Integer> expectedResult = Arrays.asList(1,4);

        assertEquals(expectedResult, result);
    }

    @Test
    public void checkDuplicatePersonTest() {
        List<Person> duplicatePerson = Arrays.asList(
                new Person("Jean", "Dupont"),
                new Person("Auguste", "Lejeune"),
                new Person("Agathe", "Bernard"),
                new Person("Jean", "Dupont"),
                new Person("Agathe", "Bernard"));
        List<Person> result = FirstExercise.checkDuplicate(duplicatePerson);
        List<Person> expectedResult = Arrays.asList(
                new Person("Jean", "Dupont"),
                new Person("Agathe", "Bernard"));

        assertEquals(expectedResult, result);
    }

}
