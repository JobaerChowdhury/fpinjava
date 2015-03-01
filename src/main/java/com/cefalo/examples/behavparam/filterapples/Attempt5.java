package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;

public class Attempt5 {

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All apples");
        List<Apple> inventory = getInventory();

        System.out.println(inventory);
        List<Apple> greenApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        List<Apple> heavyApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() >= 150;
            }
        });

        System.out.println("Green apples");
        System.out.println(greenApples);

        System.out.println("Heavy apples");
        System.out.println(heavyApples);
    }
}
