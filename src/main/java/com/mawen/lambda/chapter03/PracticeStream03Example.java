package com.mawen.lambda.chapter03;

import com.google.common.collect.Lists;
import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Artist;
import com.mawen.lambda.model.Track;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * 练习 03 常见流操作
 */
public class PracticeStream03Example {

    public static void main(String[] args) {
        System.out.println(addUp(Stream.of(1,2,3)));

        List<Artist> artists = Lists.newArrayList(new Artist("mawen", null, "China"));
        System.out.println(collectNameAndOrigin(artists));

        List<Album> albums = Lists.newArrayList(
                new Album("mawen", Lists.newArrayList(new Track("a", 30),
                new Track("b", 40),
                new Track("c", 50)),
                Lists.newArrayList()),
                new Album("jack", Lists.newArrayList(new Track("a", 30),
                new Track("c", 50)),
                Lists.newArrayList()));
        System.out.println(gtThreeSongs(albums));

        String str = "MaWen";
        System.out.println(countCharOfString(str));

        List<String> list = Lists.newArrayList("Mawen", "Jack", "Luc");
        System.out.println(minLetter(list));
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
    private static List<String> collectNameAndOrigin(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getName() + "," + artist.getOrigin())
                .collect(toList());
    }

    private static List<Album> gtThreeSongs(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().size() > 3)
                .collect(Collectors.toList());
    }

    private static int foreachCountCharOfString(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 计算一个字符串中小写字母的个数
     * @param str 字符串
     * @return 小写字母的个数
     */
    private static long countCharOfString(String str) {
        return str.chars().filter(Character::isLowerCase).count();
    }

    /**
     * 在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回Optional<String>对象
     * @param list
     * @return
     */
    private static Optional<String> minLetter(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Optional.empty();
        }

        return list.stream()
                .min(comparing(PracticeStream03Example::countCharOfString));
    }
}
