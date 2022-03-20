package com.mawen.lambda.chatper07;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Artist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * 惰性求值与调试
 * - 日志和打印消息
 * - peek
 * - 在流中间设置断点
 */
public class StreamDebugExample {

    public static void main(String[] args) {
        Album album = new Album("mawen", null, List.of());
        album.setMusicians(List.of(
                new Artist("The a", null, "china"),
                new Artist("a", null, "usa")
        ));

        foreach(album);
        peek(album);
        peekEmpty(album);
    }

    /**
     * 记录中间值，以便调试 for 循环
     */
    public static Set<String> foreach(Album album) {
        Set<String> nationalities = new HashSet<>();
        for (Artist artist : album.getMusicians()) {
            if (artist.getName().startsWith("The")) {
                String nationality = artist.getNationality();
                System.out.println("Found nationality: " + nationality);
                nationalities.add(nationality);
            }
        }
        return nationalities;
    }

    /**
     * 记录中间值，以便调试 peek 循环
     */
    public static Set<String> peek(Album album) {
        return album.getMusicians().stream()
                .map(Artist::getNationality)
                .peek(System.out::println)
                .collect(toSet());
    }

    /**
     * 记录空值，以便调试  本地无法实现
     */
    public static Set<String> peekEmpty(Album album) {
        return album.getMusicians().stream()
                .map(Artist::getNationality)
                .peek(nation -> {})
                .collect(toSet());
    }

}
