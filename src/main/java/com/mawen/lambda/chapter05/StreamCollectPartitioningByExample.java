package com.mawen.lambda.chapter05;

import com.mawen.lambda.model.Artist;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * 流 - 收集器 - 数据分块
 * - partitioningBy
 */
public class StreamCollectPartitioningByExample {

    public static void main(String[] args) {

    }

    /**
     * 指明艺术家是否为独唱歌手，将艺术家组成的流分成乐队和独唱歌手两部分
     */
    public static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }

    /**
     * 使用方法引用将艺术家组成的流分成乐队和独唱歌手两部分
     */
    public static Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }

}
