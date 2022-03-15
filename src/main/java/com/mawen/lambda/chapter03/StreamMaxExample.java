package com.mawen.lambda.chapter03;

import com.mawen.lambda.model.Track;

import java.util.Comparator;
import java.util.List;

/**
 * 流操作 - max
 * 求最大值
 */
public class StreamMaxExample {

    private static final List<Track> tracks = List.of(new Track("Bakai", 524),
            new Track("Violets for your Furs", 378),
            new Track("Time Was", 451));


    public static void main(String[] args) {
        Track longestTrack = tracks.stream()
                .max(Comparator.comparing(track -> track.getLength()))
                .get();

        System.out.println(longestTrack.getLength() == 524);

        foreachMax();
    }

    private static void foreachMax() {
        Track longestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() > longestTrack.getLength()) {
                longestTrack = track;
            }
        }

        System.out.println(longestTrack.getLength() == 524);
    }




}
