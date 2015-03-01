package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

import java.util.ArrayList;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;

public class Attempt2 {

    private static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All apples");
        List<Apple> inventory = getInventory();

        System.out.println(inventory);
        List<Apple> greenApples = filterAppleByColor(inventory, "green");
        List<Apple> redApples = filterAppleByColor(inventory, "red");

        System.out.println("Green apples");
        System.out.println(greenApples);
        System.out.println("Red apples");
        System.out.println(redApples);

    }
}


