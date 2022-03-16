package com.mawen.lambda.chapter04;

import com.mawen.lambda.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 练习 04
 */
public class PracticeStream04Example {

    public static void main(String[] args) {
        Performance performance = new PerformanceImpl("mawen",
                List.of(new Artist("lucy", List.of("a", "b", "c"), null),
                        new Artist("jack", List.of("e", "f", "g"), null)));

        performance.getAllMusicians().forEach(System.out::println);


        Artists artists = new Artists(List.of(new Artist("mawen", null, null)));
        System.out.println(artists.getArtistName(0));
    }

    /**
     * 艺术家的演出-专辑或演唱会
     */
    public interface Performance {
        public String getName();

        public Stream<Artist> getMusicians();

        public default Stream<String> getAllMusicians() {
            if (getMusicians() == null) return Stream.empty();

            return getMusicians().flatMap(artist -> artist.getMembers().stream());
        }
    }

    public static class PerformanceImpl implements Performance {
        private String name;
        private List<Artist> artists;

        public PerformanceImpl(String name, List<Artist> artists) {
            this.name = name;
            this.artists = artists;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Stream<Artist> getMusicians() {
            return Optional.ofNullable(artists).orElse(List.of()).stream();
        }
    }

    public static class Artists {

        private List<Artist> artists;

        public Artists(List<Artist> artists) {
            this.artists = artists;
        }

        public Optional<Artist> getArtist(int index) {
            if (index < 0 || index >= artists.size()) {
                return Optional.empty();
            }
            return Optional.of(artists.get(index));
        }

        @Deprecated
        private void indexException(int index) {
            throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
        }

        public String getArtistName(int index) {
            Optional<Artist> artist = getArtist(index);
            if (artist.isPresent()) {
                return artist.get().getName();
            }
            return "unknown";
        }
    }


}
