package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FirstExercise {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static <T extends Object > List<T> checkDuplicate(List<T> list) {
        return list.stream().distinct()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toList());
    }

}


        /*Set<T> tempSet = new LinkedHashSet<>();
        Set<T> resultSet = list.stream()
                .filter(elem -> !tempSet.add(elem))
                .collect(Collectors.toCollection(LinkedHashSet::new));

       for(int i = 0; i<list.size(); i++) {
            for(int j= i+1; j<list.size(); j++) {
                if(i!=j && list.get(i).equals(list.get(j))){
                    tempSet.add(list.get(i));
                    break;
                }
            }
        }

        Map<T, Long> occurences = list.stream().collect(Collectors.groupingBy(n-> n, Collectors.counting()));
        List<T> result = new ArrayList<>();
        for (Map.Entry<T, Long> entry : occurences.entrySet()) {
            if(entry.getValue()>1) {
                result.add(entry.getKey());
            }
        }*/