package com.mawen.lambda.chapter04;

import com.google.common.collect.Lists;
import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Track;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 基本类型
 */
public class BaseTypeExample {

    public static void main(String[] args) {
        Album album = new Album("mawen",
                Lists.newArrayList(new Track("a", 10),
                        new Track("b", 20),
                        new Track("c", 30)),
                Lists.newArrayList());
        printTrackLengthStatistics(album);
    }

    /**
     * 使用 summaryStatistics 方法统计曲目长度
     * @param album 专辑
     */
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTracks().stream()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }

}
