package com.cefalo.examples.composelambda;

import com.cefalo.examples.App;
import com.cefalo.examples.Apple;
import com.cefalo.examples.AppleInventory;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComposeComparators {
    public static void main(String[] args) {
        List<Apple> inventory = AppleInventory.getInventory();
        //regular sorting in ascending order
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

        //sort in reverse
        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        //first sort by color, then by weight
        inventory.sort(comparing(Apple::getColor).thenComparing(Apple::getWeight));
        System.out.println(inventory);
    }
}
