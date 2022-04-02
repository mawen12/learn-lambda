package com.mawen.lambda.chapter03;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 流操作 - flatMap
 * Stream值转换，将多个Stream连接成一个Stream
 */
public class StreamFlatMapExample {

    public static void main(String[] args) {
        List<Integer> together = Stream.of(Lists.newArrayList(1, 2), Lists.newArrayList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());

        System.out.println(ListUtils.isEqualList(Lists.newArrayList(1,2,3,4), together));

    }


}
