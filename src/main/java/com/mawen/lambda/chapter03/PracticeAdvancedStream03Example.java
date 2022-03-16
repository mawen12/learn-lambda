package com.mawen.lambda.chapter03;

import com.mawen.lambda.model.Album;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.function.Function;

/**
 * 练习 03 进阶练习
 */
public class PracticeAdvancedStream03Example {

    public static void main(String[] args) {
        System.out.println(reduceString(List.of("a", "b", "c")));
    }

    // TODO by mawen 待优化返回List P33
    private static String reduceString(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.stream().reduce("", (acc, element) -> acc + element);
    }

    // TODO by mawen 待实现filter P33
    private static String reduceFilter() {
        return null;
    }


}
