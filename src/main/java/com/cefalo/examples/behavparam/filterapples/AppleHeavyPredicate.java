package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

public class AppleHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() >= 150;
    }
}
