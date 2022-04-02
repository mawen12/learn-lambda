package com.mawen.lambda.chapter04;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * 重载方法
 */
public interface OverloadExample extends BinaryOperator<Integer> {

    public static void main(String[] args) {
        overloadedMethod((x, y) -> x + y);
//        overloadedMethod((x) -> true); // 当IntPredicate未继承Predicate时，就会报错，添加继承可以解决问题
    }

    public static void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.println("BinaryOperator");
    }

    public static void overloadedMethod(IntegerBiFunction lambda) {
        System.out.println("IntegerBiFunction");
    }

    public static void overloadedMethod(Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }

    public static void overloadedMethod(IntPredicate predicate) {
        System.out.println("IntPredicate");
    }

    interface IntegerBiFunction extends BinaryOperator<Integer> {
    }

    interface IntPredicate {
        boolean test(int value);
    }

}
