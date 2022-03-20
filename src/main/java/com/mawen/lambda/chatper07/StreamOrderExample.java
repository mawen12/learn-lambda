package com.mawen.lambda.chatper07;

import com.mawen.lambda.model.Album;
import com.mawen.lambda.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * 流 - Order模式
 */
public class StreamOrderExample {

    public static void main(String[] args) {

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDomain {

        private List<Album> albums;

        // ====================命令式实现========================

        public long countRunningTime() {
            long count = 0;
            for (Album album : albums) {
                for (Track track : album.getTracks()) {
                    count += track.getLength();
                }
            }
            return count;
        }

        public long countMusicians() {
            long count = 0;
            for (Album album : albums) {
                count += album.getMusicians().size();
            }
            return count;
        }

        public long countTracks() {
            long count = 0;
            for (Album album : albums) {
                count += album.getTracks().size();
            }
            return count;
        }

        // ====================流重构========================

        public long refactorCountRunningTime() {
            return albums.stream()
                    .mapToLong(album -> album.getTracks().stream().mapToLong(Track::getLength).sum())
                    .sum();
        }

        public long refactorCountMusicians() {
            return albums.stream()
                    .mapToLong(album -> album.getMusicians().size())
                    .sum();
        }

        public long refactorCountTracks() {
            return albums.stream()
                    .mapToLong(album -> album.getTracks().size())
                    .sum();
        }

        // ====================领域重构========================

        public long countFeature(ToLongFunction<Album> function) {
            return albums.stream()
                    .mapToLong(function)
                    .sum();
        }

        public long refactorCountRunningTimeV2() {
            return countFeature(album -> album.getTracks().stream().mapToLong(track -> track.getLength()).sum());
        }

        public long refactorCountMusiciansV2(List<Album> albums) {
            return countFeature(album -> album.getMusicians().size());
        }

        public long refactorCountTracksV2(List<Album> albums) {
            return countFeature(album -> album.getTracks().size());
        }
    }
}
