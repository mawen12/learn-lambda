package com.mawen.lambda.chapter05;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Artist;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * 流 - 收集器 - 转换成值
 * - maxBy
 * - minBy
 * - averagingDouble
 */
public class StreamCollectConvertToNumberExample {

    public static void main(String[] args) {

    }

    /**
     * 找出成员最多的乐队
     *
     * @param artists
     * @return
     */
    public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
        // 比较器
        Function<Artist, Integer> getCount = artist -> artist.getMembers().size();
        return artists.collect(maxBy(comparing(getCount)));
    }

    /**
     * 找出成员最少的乐队
     */
    public static Optional<Artist> smallestGroup(Stream<Artist> artists) {
        Function<Artist, Integer> getCount = artist -> artist.getMembers().size();
        return artists.collect(minBy(comparing(getCount)));
    }

    /**
     * 找出一组专辑上曲目的平均数
     *
     * @param albums 一组专辑
     * @return 曲目的平均数
     */
    public static double averageNumberOfTracks(List<Album> albums) {
        return albums.stream()
                .collect(averagingDouble(album -> album.getMusicians().size()));
    }
}
