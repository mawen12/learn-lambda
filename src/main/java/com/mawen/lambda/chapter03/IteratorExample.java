package com.mawen.lambda.chapter03;

import com.mawen.lambda.model.Artist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 外部迭代 与 内部迭代
 */
public class IteratorExample {

    private static List<Artist> allArtists = new ArrayList<>();

    public static void main(String[] args) {

    }

    /**
     * 外部迭代 foreach 计算从伦敦来的艺术家的人数
     * 外部迭代会将行为和方法混为一谈
     */
    private static void outerIterator() {
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
    }

    /**
     * 外部迭代 iterator 计算从伦敦来的艺术家的人数
     */
    private static void iterator() {
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while(iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
    }

    /**
     * 内部迭代 stream 计算从伦敦来的艺术家的人数
     */
    private static void innerIterator() {
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London")) // 找出所有来自伦敦的艺术家 - 惰性求值
                .count(); // 计算他们的总数 - 及早求值
    }


}
