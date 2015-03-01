package com.cefalo.examples.composelambda;

import java.util.function.Function;

public class ComposeFunctions {
    public static void main(String[] args) {
        composeFunctions();
        textTransformation();
    }

    private static void composeFunctions() {
        //Let's say we have two simple functions
        Function<Integer, Integer> inc = a -> a + 1;
        Function<Integer, Integer> dub = a -> a * 2;

        //We can create a new function like this
        Function<Integer, Integer> incThenDub = inc.andThen(dub);
        System.out.println(incThenDub.apply(9));

        //We can also compose like follows
        Function<Integer, Integer> incOfDub = inc.compose(dub);
        System.out.println(incOfDub.apply(9));
    }

    private static void textTransformation() {
        //Pipeline of first adding header, then check spelling, then add footer
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline1
            = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        System.out.println(transformationPipeline1.apply("labda comes from lambda calculus."));

        //Second pipeline, only add header and footer
        Function<String, String> addHeader2 = Letter::addHeader;
        Function<String, String> transformationPipeline2
            = addHeader.andThen(Letter::addFooter);
        System.out.println(transformationPipeline2.apply("labda comes from lambda calculus."));
    }
}

class Letter {
    public static String addHeader(String text) {
        return "From Bob: " + text;
    }

    public static String addFooter(String text) {
        return text + "\nKind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}