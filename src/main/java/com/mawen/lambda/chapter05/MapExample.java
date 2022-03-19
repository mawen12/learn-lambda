package com.mawen.lambda.chapter05;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流 - Map
 */
public class MapExample {

    private static final Map<String, Artist> artistCache = new HashMap<>();

    public static void main(String[] args) {
        artistCache.put("mawen", new Artist());

        MapExample example = new MapExample();
        example.getArtist("mawen");
        example.getArtistV1("mawen");
    }

    /**
     * 使用显示判断空值的方式缓存
     */
    public Artist getArtist(String name) {
        Artist artist = artistCache.get(name);
        if (artist == null) {
            artist = readArtistFromDB(name);
            artistCache.put(name, artist);
        }
        return artist;
    }

    /**
     * 使用computeIfAbsent缓存
     */
    public Artist getArtistV1(String name) {
        return artistCache.computeIfAbsent(name, this::readArtistFromDB);
    }

    /**
     * 一种丑陋的的迭代Map的方式
     */
    public void forEachMap(Map<Artist, List<Album>> albumsByArtist) {
        Map<Artist, Integer> countOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            Artist artist = entry.getKey();
            List<Album> albums = entry.getValue();
            countOfAlbums.put(artist, albums.size());
        }
    }

    /**
     * 使用内部迭代遍历Map里的值
     */
    public void forEachMapByInner(Map<Artist, List<Album>> albumsByArtist) {
        Map<Artist, Integer> countOfAlbums = new HashMap<>();
        albumsByArtist.forEach((artist, albums) -> {
            countOfAlbums.put(artist, albums.size());
        });
    }


    private Artist readArtistFromDB(String name) {
        return null;
    }
}
