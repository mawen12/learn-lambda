package com.mawen.lambda.chatper07;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Lambda 表达式的单元测试
 */
public class StreamJunitExample {

    public static void main(String[] args) {

    }

    /**
     * 将字符串转换为大写方式
     */
    public static List<String> allToUpperCase(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(toList());
    }

    /**
     * 将列表中元素的第一个字母转换成大写
     */
    public static List<String> elementFirstToUpperCaseLambda(List<String> words) {
        return words.stream()
                .map(value -> {
                    char firstChar = Character.toUpperCase(value.charAt(0));
                    return firstChar + value.substring(1);
                })
                .collect(toList());
    }

    public static String firstToUppercase(String value) {
        char firstChar = Character.toUpperCase(value.charAt(0));
        return firstChar + value.substring(1);
    }

    /**
     * 将首字母转换为大写，应用到所有列表元素
     */
    public static List<String> elementFirstToUppercase(List<String> words) {
        return words.stream()
                .map(StreamJunitExample::firstToUppercase)
                .collect(toList());
    }

}
