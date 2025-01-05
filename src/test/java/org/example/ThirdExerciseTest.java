package org.example;

import org.example.entities.Dependency;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class ThirdExerciseTest {

    private ThirdExercise jsonParser;

    @Before
    public void init() {
        jsonParser = new ThirdExercise();
    }

    @Test
    public void readJsonFileTest() throws IOException, ParseException {
        List<Dependency> dependencies = jsonParser.readJsonFile("src/test/resources/test.json");
        List<Dependency> expectedDependencies = List.of(
                new Dependency("pkg1", List.of(
                        new Dependency("pkg2", List.of(new Dependency("pkg3"))),
                        new Dependency("pkg3")
                )),
                new Dependency("pkg2", List.of(new Dependency("pkg3"))),
                new Dependency("pkg3")
        );

        assertEquals(expectedDependencies, dependencies);

    }

    @Test
    public void readMoreComplexJsonFileTest() throws IOException, ParseException {
        List<Dependency> dependencies = jsonParser.readJsonFile("src/test/resources/test2.json");
        List<Dependency> expectedDependencies = List.of(
                new Dependency("pkg1", List.of(
                        new Dependency("pkg2", List.of(
                                new Dependency("pkg3", List.of(
                                        new Dependency("pkg4", List.of(
                                                new Dependency("pkg5")
                                        ))
                                ))
                        )),
                        new Dependency("pkg3", List.of(
                                new Dependency("pkg4", List.of(
                                        new Dependency("pkg5")
                                ))
                        ))
                )),
                new Dependency("pkg2", List.of(
                        new Dependency("pkg3", List.of(
                                new Dependency("pkg4", List.of(
                                        new Dependency("pkg5")
                                ))
                        ))
                )),
                new Dependency("pkg3", List.of(
                        new Dependency("pkg4", List.of(
                                new Dependency("pkg5")
                        ))
                )),
                new Dependency("pkg4", List.of(
                        new Dependency("pkg5")
                )),
                new Dependency("pkg5")
        );

        assertEquals(expectedDependencies, dependencies);

    }

}
