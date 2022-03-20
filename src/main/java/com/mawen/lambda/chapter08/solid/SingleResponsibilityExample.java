package com.mawen.lambda.chapter08.solid;

import java.util.stream.IntStream;

/**
 * 单一功能原则
 */
public class SingleResponsibilityExample {

    // =================初始版本：多重职责耦合=================

    /**
     * 计算质数个数，一个方法里塞进了多重职责
     * - 计数
     * - 判断一个数是否是质数
     */
    public long countPrimes(int upTo) {
        long tally = 0;
        for (int i = 0; i < upTo; i++) {
            boolean isPrime = true;
            for (int j = 0; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                tally++;
            }
        }
        return tally;
    }

    // =================第一次迭代：解耦职责=================

    /**
     * 将 isPrime 重构成另外一个方法后，计算质数个数的方法
     */
    public long countPrimesV1(int upTo) {
        long tally = 0;
        for (int i = 0; i < upTo; i++) {
            if (isPrimeV1(i)) {
                tally++;
            }
        }
        return tally;
    }

    private boolean isPrimeV1(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // =================第二次迭代：集合流=================

    /**
     * 使用集合流重构质数计数程序
     */
    public long countPrimesV2(int upTo) {
        return IntStream.range(1, upTo)
                .filter(this::isPrimeV2)
                .count();
    }

    private boolean isPrimeV2(int number) {
        return IntStream.range(2, number)
                .allMatch(x -> (number % x) != 0);
    }

    // =================第三次迭代：并行集合流=================

    /**
     * 并行运行基于集合流的质数计数程序
     */
    public long countPrimesV3(int upTo) {
        return IntStream.range(1, upTo)
                .parallel()
                .filter(this::isPrimeV3)
                .count();
    }

    private boolean isPrimeV3(int number) {
        return IntStream.range(2, number)
                .parallel()
                .allMatch(x -> (number % 2) != 0);
    }
}
