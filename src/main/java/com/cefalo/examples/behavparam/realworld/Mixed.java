package com.cefalo.examples.behavparam.realworld;

import com.cefalo.examples.Apple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

import static com.cefalo.examples.AppleInventory.getInventory;
import static java.util.Comparator.comparing;

public class Mixed {
    public static void main(String[] args) {
        sortInDifferentWays();
        threadRunWithLambda();
        eventHandlingWithLambda();
    }

    private static void eventHandlingWithLambda() {
        Label l = new Label("...");
        Button b = new Button();

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("Sending...");
            }
        });

        b.addActionListener((ActionEvent e) -> l.setText("Sending ..."));
    }

    private static void threadRunWithLambda() {
        Thread regular = new Thread( new Runnable() {
            @Override
            public void run() {
                System.out.println("I am from one runnable");
            }
        });

        Thread lambda =
            new Thread(
                () -> System.out.println("I am from lambda"));
    }

    private static void sortInDifferentWays() {
        sortWithComparator();
        sortWithAnonComparator();
        sortWithLambda();
        sortWithReference();
    }


    private static void sortWithAnonComparator() {
        List<Apple> inventory = getInventory();

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        System.out.println("After sorting > ");
        System.out.println(inventory);
    }

    private static void sortWithLambda() {
        List<Apple> inventory = getInventory();

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        System.out.println(inventory);
    }

    private static void sortWithReference() {
        List<Apple> inventory = getInventory();

        inventory.sort(comparing(Apple::getWeight));

        System.out.println(inventory);

    }

    private static void sortWithComparator() {
        List<Apple> inventory = getInventory();
        System.out.println("Before sorting > ");
        System.out.println(inventory);

        inventory.sort(new AppleComparator());

        System.out.println("After sorting ");
        System.out.println(inventory);
    }

    private static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
