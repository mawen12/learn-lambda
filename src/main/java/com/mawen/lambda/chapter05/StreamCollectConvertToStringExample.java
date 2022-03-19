package com.mawen.lambda.chapter05;

import com.mawen.lambda.model.Artist;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * 流 - 收集器 - 字符串
 * - joiningBy
 */
public class StreamCollectConvertToStringExample {

    public static void main(String[] args) {

    }

    /**
     * 使用for循环格式化艺术家姓名
     */
    public static String genArtistNameByForeach(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            builder.append(artist.getName());
        }
        builder.append("]");

        return builder.toString();
    }

    /**
     * 使用流和收集器格式化艺术家姓名
     */
    public static String genArtistNameByStreamCollect(Stream<Artist> artists) {
        return artists
                .map(artist -> artist.getName()) // 提取艺术家姓名
                .collect(joining(", ", "[", "]"));
    }

}
