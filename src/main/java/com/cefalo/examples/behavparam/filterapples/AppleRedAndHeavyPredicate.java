package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() >= 150;
    }
}
