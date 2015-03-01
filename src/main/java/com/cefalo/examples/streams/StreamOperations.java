package com.cefalo.examples.streams;

import java.util.Arrays;
import java.util.List;

public class StreamOperations {
    public static void main(String[] args) {
        testReduce();
    }

    private static void testReduce() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = sum(ints);
        Integer product = product(ints);
        System.out.printf("Sum is %d. Product is %d.\n", sum, product);

        Integer sumByReduce = ints.stream().reduce(0, (a, b) -> a + b);
        Integer prodByReduce = ints.stream().reduce(1, (a, b) -> a * b);
        System.out.printf("Sum is %d. Product is %d.\n", sumByReduce, prodByReduce);
    }

    private static Integer sum(List<Integer> numbers ) {
        int result = 0;
        for (Integer number : numbers) {
            result = result + number;
        }
        return result;
    }

    private static Integer product(List<Integer> numbers) {
        int result = 1;
        for(Integer num : numbers) {
            result = result * num;
        }
        return result;
    }
}
