package com.mawen.lambda.chapter03;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 * 重构代码
 */
public class RefactorExample {

    public static void main(String[] args) {

    }

    private static Set<String> refactorBefore(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.forEach(album -> {
            album.getTracks()
                    .forEach(track -> { // flatMap
                        if (track.getLength() > 60) { // filter
                            String name = track.getName(); // map
                            trackNames.add(name); // toSet
                        }
                    });
        });

        return trackNames;
    }

    private static Set<String> refactorAfter(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet());
    }

}
