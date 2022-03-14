package com.mawen.lambda.simple;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class LambdaExample {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello World");

        ActionListener oneArgument = event -> System.out.println("button clicked");

        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        BinaryOperator<Long> add = (x, y) -> x + y;

        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }

}
