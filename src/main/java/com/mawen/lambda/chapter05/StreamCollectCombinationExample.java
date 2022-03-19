package com.mawen.lambda.chapter05;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 流 - 收集器 - 组合收集器
 */
public class StreamCollectCombinationExample {

    public static void main(String[] args) {

    }

    /**
     * 计算每个艺术家专辑数的简单方式
     * - 方式简单
     * - 杂乱无章
     * - 命令式代码
     * - 无法并行化操作
     */
    public static Map<Artist, Integer> numberOfAlbumsSimple(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(album -> album.getMainMusician()));

        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }

        return numberOfAlbums;
    }

    /**
     * 使用收集器计算每个艺术家的专辑数
     */
    public static Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician(), counting()));
    }

    /**
     * 使用简单方法求每个艺术家的专辑名
     */
    public static Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(album -> album.getMainMusician()));

        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue().stream().map(Album::getName).collect(toList()));
        }

        return nameOfAlbums;
    }

    /**
     * 使用收集器求每个艺术家的专辑名
     */
    public static Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        // 主收集器 => 生成最终结果
        return albums.collect(groupingBy(album -> album.getMainMusician(),
                mapping(Album::getName,
                        // 下游收集器 => 生成部分结果
                        toList())));
    }


}
