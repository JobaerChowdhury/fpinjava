package com.cefalo.examples;

import java.util.Arrays;
import java.util.List;

public class AppleInventory {
    public static List<Apple> getInventory() {
        return Arrays.asList(
            new Apple("green", 120),
            new Apple("red", 190),
            new Apple("green", 100),
            new Apple("red", 90),
            new Apple("green", 95),
            new Apple("green", 220),
            new Apple("red", 200),
            new Apple("white", 111),
            new Apple("green", 150));
    }
}
