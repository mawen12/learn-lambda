package com.mawen.lambda.chapter04;

import java.util.Optional;

/**
 * Optional
 */
public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> a = Optional.of("a");
        System.out.println(a.get());

        Optional empty = Optional.empty();
        Optional<Object> alsoEmpty = Optional.ofNullable(null);

        System.out.println(empty.isPresent());
        System.out.println(a.isPresent());

        empty.orElse("b");
        empty.orElseGet(() -> "c");
    }

}
