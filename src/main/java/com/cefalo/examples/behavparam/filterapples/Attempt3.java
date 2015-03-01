package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;

public class Attempt3 {

    private static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if((flag && color.equals(apple.getColor())) || (!flag && apple.getWeight() >= weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All apples");
        List<Apple> inventory = getInventory();

        System.out.println(inventory);
        List<Apple> greenApples = filterApples(inventory, "green", 0, true);
        List<Apple> redApples = filterApples(inventory, "red", 0, true);
        List<Apple> heavyApples = filterApples(inventory, "", 150, false);

        System.out.println("Green apples");
        System.out.println(greenApples);

        System.out.println("Red apples");
        System.out.println(redApples);

        System.out.println("Heavy apples");
        System.out.println(heavyApples);

    }
}
