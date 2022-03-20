package com.mawen.lambda.chapter06;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * 并行化数组操作
 */
public class StreamParallelArrayExample {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(simpleMovingAverage(new double[]{0, 1, 2, 3, 4, 3.5}, 3)));
    }

    /**
     * 使用 for 循环初始化数组
     */
    public static double[] imperativeInitialize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }

    /**
     * 使用并行化数组操作初始化数组
     */
    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    /**
     * 计算简单滑动平均数
     */
    public static double[] simpleMovingAverage(double[] values, int n) {
        // 复制原数组
        double[] sums = Arrays.copyOf(values, values.length);
        // 元素累加
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length)// 获取所需元素的下标
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n; // 使用总和减去窗口起始值，再除以n得到平均数
                })
                .toArray(); // 转换为数组
    }
}
