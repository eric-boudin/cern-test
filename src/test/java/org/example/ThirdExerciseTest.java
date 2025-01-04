package org.example;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.io.IOException;

@RunWith(JUnit4.class)
public class ThirdExerciseTest {

    private ThirdExercise jsonParser;

    @Before
    public void init() {
        jsonParser = new ThirdExercise();
    }

    @Test
    public void readJsonFileTest() throws IOException, ParseException {
        jsonParser.readJsonFile("src/test/resources/test.json");
    }
}
