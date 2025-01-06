package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FirstExercise {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static <T> List<T> checkDuplicate(List<T> list) {
        return list.stream().distinct()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toList());
    }

}