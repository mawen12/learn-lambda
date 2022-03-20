package com.mawen.lambda.chapter06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * 练习 06
 */
public class StreamPractise06Example {

    public static void main(String[] args) {
        System.out.println(sequentialSumOfSquares(IntStream.range(0, 5)));
        System.out.println(parallelSumOfSquares(IntStream.range(0, 5)));
        System.out.println(multiplyThrough(List.of(1, 2, 3)));
        System.out.println(parallelMultiplyThrough(List.of(1, 2, 3)));
        System.out.println(slowSumOfSquares(List.of(1, 2, 3)));
        System.out.println(fastSumOfSquares(List.of(1, 2, 3)));
    }

    /**
     * 顺序求列表中数字的平方和
     */
    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

    /**
     * 并行求列表中数字的平方和
     */
    public static int parallelSumOfSquares(IntStream range) {
        int[] values = range.toArray();
        Arrays.parallelSetAll(values, x -> x * x);
        return Arrays.stream(values).sum();
    }

    /**
     * 把列表中的数字相乘，然后再将所得结果乘以5
     */
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> acc * x);
    }

    /**
     * 使用并行流优化上述
     */
    public static int parallelMultiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream()
                .reduce(1, (acc, x) -> acc * x) * 5;
    }

    /**
     * 求列元素的平方和，该实现方式性能不高
     */
    public static int slowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public static int fastSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream()
                .mapToInt(x -> x * x)
                .sum();
    }

}
