package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;

public class Attempt7 {
    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All apples");
        List<Apple> inventory = getInventory();
        System.out.println(inventory);

        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        List<Apple> heavyApples = filter(inventory, (Apple a) -> a.getWeight() >= 150);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        System.out.println("Green apples");
        System.out.println(greenApples);

        System.out.println("Heavy apples");
        System.out.println(heavyApples);
    }
}
