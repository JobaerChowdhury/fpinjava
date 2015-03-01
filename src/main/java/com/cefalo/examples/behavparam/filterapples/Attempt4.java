package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;


public class Attempt4 {

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All apples");
        List<Apple> inventory = getInventory();

        System.out.println(inventory);
        List<Apple> greenApples = filterApples(inventory, new AppleGreenPredicate());
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyPredicate());
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());

        System.out.println("Green apples");
        System.out.println(greenApples);

        System.out.println("Heavy apples");
        System.out.println(heavyApples);

        System.out.println("Red and Heavy apples");
        System.out.println(redAndHeavyApples);
    }
}
