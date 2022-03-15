package com.mawen.lambda.chapter03;

import com.mawen.lambda.model.Album;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * 流操作 - 整合操作
 * 通过整合不同流操作来解决问题
 */
public class StreamMultiOperatorExample {
    private static Album album;

    public static void main(String[] args) {
        handle();
    }

    /**
     * 1.找出专辑上的所有表演者
     * 2.分辨出哪些表演者是乐队
     * 3.找出每个乐队的国籍
     * 4.将找出的国籍放入一个集合
     */
    private static void handle() {
        Set<String> origins = album.getMusicians()
                .stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getOrigin())
                .collect(toSet());
    }
}
