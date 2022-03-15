package com.mawen.lambda.chapter03;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 练习 03 常见流操作
 */
public class PracticeStream03Example {

    public static void main(String[] args) {
        System.out.println(addUp(Stream.of(1,2,3)));

    }

    /**
     * 求和函数
     * @param numbers 数字流
     * @return 和
     */
    private static int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(i -> i).sum();
    }

    /**
     * 返回包含艺术家的姓名和国籍的字符串列表
     * @param artists 艺术家列表
     * @return 返回包含艺术家的姓名和国籍的字符串列表
     */
    private static List<String> collectNameANdOrigin(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getName() + "," + artist.getOrigin())
                .collect(toList());
    }

    private static List<Album> gtThreeSongs(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().size() > 3)
                .collect(Collectors.toList());
    }


}
