package com.cefalo.examples.usingoptional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> opt1 = Optional.empty();
        String opt1String = opt1.orElse("Unknown");
        System.out.println(opt1String);

        Optional<String> opt2 = Optional.of("Something Present");
        String opt2String = opt2.orElse("Unknown");
        System.out.println(opt2String);

    }
}
