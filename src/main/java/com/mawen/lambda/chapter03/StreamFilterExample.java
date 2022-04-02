package com.mawen.lambda.chapter03;

import com.google.common.collect.Lists;
import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.stream.Collectors.toList;

/**
 * 流操作 - filter
 * 遍历数据并检查其中的元素中
 */
public class StreamFilterExample {

    public static void main(String[] args) {
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());

        System.out.println(ListUtils.isEqualList(Lists.newArrayList("1abc"), beginningWithNumbers));

        foreachFilter();
    }

    private static void foreachFilter() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }

        System.out.println(ListUtils.isEqualList(Lists.newArrayList("1abc"), beginningWithNumbers));
    }
}
