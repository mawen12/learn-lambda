package com.mawen.lambda.chapter03;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * 流操作 - reduce
 * 从一组值中生成一个值
 */
public class StreamReduceExample {

    public static void main(String[] args) {
        Integer count = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element);

        System.out.println(count == 10);

        openReduce();
        foreachReduce();
    }

    private static void openReduce() {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        Integer count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);

        System.out.println(count == 6);
    }

    private static void foreachReduce() {
        int acc = 0;
        for (Integer element : Lists.newArrayList(1, 2, 3)) {
            acc = acc + element;
        }

        System.out.println(acc == 6);
    }

}
