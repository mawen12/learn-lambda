package com.mawen.lambda.chatper07;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StreamJunitExampleTest {

    /**
     * 测试大写转换
     */
    @Test
    public void multipleWordsToUpperCase() {
        List<String> input = asList("a", "b", "hello");
        List<String> result = StreamJunitExample.allToUpperCase(input);
        assertEquals(asList("A", "B", "HELLO"), result);
    }

    /**
     * 测试字符串包含两个字符的情况，第一个字母被转换成大写
     */
    @Test
    public void twoLetterStringConvertedToUppercaseLambdas() {
        List<String> input = asList("ab");
        List<String> result = StreamJunitExample.elementFirstToUpperCaseLambda(input);
        assertEquals(asList("Ab"), result);
    }

    /**
     * 测试单独的方法
     */
    @Test
    public void twoLetterStringConvertedToUppercase() {
        String input = "ab";
        String result = StreamJunitExample.firstToUppercase(input);
        assertEquals("Ab", result);
    }
}