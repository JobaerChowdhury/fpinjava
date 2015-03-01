package com.cefalo.examples.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamTest {
    private static List<Dish> menu = Menu.getItems();

    public static void main(String[] args) {
        initialExample();
        find3HighCalorieDishes();
        externalVsInternalIteration();
    }

    private static void initialExample() {
        //Get the low calorie dish names, sorted by calorie

        //Java 7 way
        List<Dish> lowCals = new ArrayList<Dish>();
        for (Dish dish : menu) {
            if(dish.getCalories() < 400){
                lowCals.add(dish);
            }
        }
        Collections.sort(lowCals, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        List<String> lowCalNames = new ArrayList<>();
        for (Dish lowCal : lowCals) {
            lowCalNames.add(lowCal.getName());
        }
        System.out.println(lowCalNames);

        //Java 8 way
        List<String> newLowCalNames =
            menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        System.out.println(newLowCalNames);
    }

    private static void externalVsInternalIteration() {
        //External iteration
        List<String> names = new ArrayList<>();
        for(Dish d : menu) {
            names.add(d.getName());
        }
        System.out.println(names);

        List<String> names2 = menu.stream().map(Dish::getName).collect(toList());
        System.out.println(names2);

    }

    private static void find3HighCalorieDishes() {
        List<String> threeHighCalDishes = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(toList());
        System.out.println(threeHighCalDishes);
    }


}
