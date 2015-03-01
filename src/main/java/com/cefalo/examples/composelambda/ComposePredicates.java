package com.cefalo.examples.composelambda;

import com.cefalo.examples.Apple;
import com.cefalo.examples.AppleInventory;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class ComposePredicates {
    public static void main(String[] args) {
        List<Apple> inventory = AppleInventory.getInventory();

        Predicate<Apple> redApple = apple -> "red".equals(apple.getColor());
        List<Apple> redApples = inventory.stream().filter(redApple).collect(toList());
        System.out.println(redApples);

        // Get a reverse predicate by negating it.
        Predicate<Apple> notRedApple = redApple.negate();
        List<Apple> notRedApples = inventory.stream().filter(notRedApple).collect(toList());
        System.out.println(notRedApples);

        // compose two predicates
        Predicate<Apple> redAndHeavy = redApple.and(apple -> apple.getWeight() > 150);
        List<Apple> redAndHeavyApples = inventory.stream().filter(redAndHeavy).collect(toList());
        System.out.println(redAndHeavyApples);

        //Compose multiple. Precedence is from left to right
        Predicate<Apple> redAndHeavyOrGreen =
            redApple.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));
        List<Apple> redAndHeavyOrGreenApples = inventory.stream().filter(redAndHeavyOrGreen).collect(toList());
        System.out.println(redAndHeavyOrGreenApples);


    }
}
