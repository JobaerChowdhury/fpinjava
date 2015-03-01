package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;

public class Attempt1 {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All apples");
        List<Apple> inventory = getInventory();

        System.out.println(inventory);
        List<Apple> greenApples = filterGreenApples(inventory);

        System.out.println("Green apples");
        System.out.println(greenApples);
    }
}
