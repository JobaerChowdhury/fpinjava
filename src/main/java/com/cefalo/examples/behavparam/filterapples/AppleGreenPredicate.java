package com.cefalo.examples.behavparam.filterapples;

import com.cefalo.examples.Apple;

public class AppleGreenPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
