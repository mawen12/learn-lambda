package com.mawen.lambda.chapter03;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 流操作 - collect(toList())
 * 由Stream里的值生成一个列表，是一个及早求值操作
 */
public class StreamCollectExample {

    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(toList());

        CollectionUtils.isEqualCollection(Arrays.asList("a", "b", "c"), collected);
    }




}
