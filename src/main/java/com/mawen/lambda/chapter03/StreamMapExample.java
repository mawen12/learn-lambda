package com.mawen.lambda.chapter03;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流操作 - map
 * 将一个流中的值转换成一个新的流
 */
public class StreamMapExample {

    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "c")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(ListUtils.isEqualList(Arrays.asList("A", "B", "HELLO"), collected));

        foreachMap();
    }

    private static void foreachMap() {
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }

        System.out.println(ListUtils.isEqualList(Arrays.asList("A", "B", "HELLO"), collected));
    }

}
