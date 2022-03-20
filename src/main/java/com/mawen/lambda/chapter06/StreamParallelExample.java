package com.mawen.lambda.chapter06;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Track;

import java.util.List;

/**
 * 流 - 并行化流操作
 * - 串行化并不一定会比并行化快
 */
public class StreamParallelExample {

    public static void main(String[] args) {

    }

    /**
     * 串行化计算专辑曲目长度
     */
    public static int serialArraySum(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTracks().stream()) // 获取每张专辑的曲目信息
                .mapToInt(Track::getLength) // 获取曲目长度
                .sum(); // 相加得出曲目总长度
    }

    /**
     * 并行化计算专辑曲目长度
     */
    public static int parallelArraySum(List<Album> albums) {
        return albums.parallelStream()
                .flatMap(album -> album.getTracks().stream())
                .mapToInt(Track::getLength)
                .sum();
    }

    /**
     * 并行求和
     */
    public static int addIntegers(List<Integer> values) {
        return values.stream()
                .mapToInt(i -> i)
                .sum();
    }
}
