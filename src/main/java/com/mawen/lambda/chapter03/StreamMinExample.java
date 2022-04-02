package com.mawen.lambda.chapter03;

import com.google.common.collect.Lists;
import com.mawen.lambda.model.Track;

import java.util.Comparator;
import java.util.List;

/**
 * 流操作 - min
 * 求最小值
 */
public class StreamMinExample {

    private static final List<Track> tracks = Lists.newArrayList(new Track("Bakai", 524),
            new Track("Violets for your Furs", 378),
            new Track("Time Was", 451));


    public static void main(String[] args) {
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        System.out.println(shortestTrack.getLength() == 378);

        foreachMin();
    }

    private static void foreachMin() {
        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }

        System.out.println(shortestTrack.getLength() == 378);
    }
}
