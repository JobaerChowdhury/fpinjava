package com.cefalo.examples.testlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by jobaer on 2/28/15.
 */
public class TestingLambda {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("This will be a lambda testing playground!");
        System.out.println(adder(integers));
        System.out.println(adder().apply(10, 23));

        List<Integer> res1 = map(integers, (a -> a * 10));
        System.out.println(res1);

        List<Integer> res2 = integers.stream().map((a -> a * 10)).collect(toList());
        System.out.println(res2);

        // Currying, partial application
        Integer res3 = times().apply(3, 14);
        System.out.println(res3);
        Function<Integer, Integer> times3 = ((Integer a) -> times().apply(3, a));
        System.out.println(times3.apply(14));

        System.out.println(isPrimeImperative(100));
        System.out.println(isPrime(100));
    }

    public static Integer add(Integer a, Integer b) {
        return a + b;
    }

    public static BiFunction<Integer, Integer, Integer> adder() {
        return (Integer a, Integer b) -> a + b ;
    }

    public static BiFunction<Integer, Integer, Integer> times() {
        return (Integer a, Integer b) -> a * b ;
    }


    public static<A,B> List<B> map(List<A> input, Function<A,B> operation){
        List<B> result = new ArrayList<>();
        for (A a : input) {
            result.add(operation.apply(a));
        }
        return result;
    }

    public static Integer adder(List<Integer> as) {
        Integer result = 0;
        for (Integer a : as) {
            result += a;
        }
        return result;
    }


    public static boolean isPrimeImperative(int n) {
        for(int i=2; i<n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static boolean isPrime(final int n) {
        Predicate<Integer> divides = divisor -> n % divisor == 0;
        return n > 1 && IntStream.range(2, n).noneMatch(elem -> divides.test(elem));
    }


    public static <T> T reducer(T initial, List<T> ls, BiFunction<T,T,T> operation){
        T result = initial;
        for (T l : ls) {
            result = operation.apply(result, l);
        }

        return result;
    }
}
