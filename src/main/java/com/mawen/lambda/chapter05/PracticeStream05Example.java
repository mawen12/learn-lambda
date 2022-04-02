package com.mawen.lambda.chapter05;

import com.google.common.collect.Lists;
import com.mawen.lambda.model.Artist;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 练习 05
 */
public class PracticeStream05Example {

    public static void main(String[] args) {
        toUpperByMethodReference();
        countByReduce();

        longestNameByCollect();
        longestNameByReduce();
        countOfWord();
        customCollectGroupBy();
    }

    public static void toUpperByMethodReference() {
        List<String> list = Arrays.asList("a", "b", "c");
        List<String> collect = list.stream().map(String::toUpperCase).collect(toList());
        System.out.println(collect);
    }

    // ==================找出名字最长的艺术家=============================

    public static void countByReduce() {
        Integer count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);

        System.out.println(count);
    }

    public static void longestNameByCollect() {
        Stream<String> names = Stream.of("John Lennon",
                "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

        Optional<String> longestName = names.collect(maxBy(Comparator.comparing(String::length)));
        System.out.println(longestName);
    }

    // ==================计算单词出现的次数=============================

    public static void longestNameByReduce() {
        Stream<String> names = Stream.of("John Lennon",
                "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

        Optional<String> longestName = names.reduce((left, right) -> left.length() > right.length() ? left : right);
        System.out.println(longestName);
    }

    public static void countOfWord() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");

        Map<String, Long> countOfWord = names.collect(groupingBy(Function.identity(), counting()));
        System.out.println(countOfWord);
    }

    // ==================定制收集器实现Collectors.groupingBy=============================

    public static void customCollectGroupBy() {
        Stream<Artist> names = Stream.of(new Artist("mawen", Lists.newArrayList("a", "b", "c"), "china"),
                new Artist("Jack", Lists.newArrayList("a", "b", "c"), "china"),
                new Artist("Jack", Lists.newArrayList("b", "c", "d"), "china"));

        Map<String, List<Artist>> collect = names.collect(new GroupingBy<>(Artist::getName));
        System.out.println(collect);
    }

    // ==================TODO by mawen 改进Map P85=============================

    /**
     * 自定义收集器
     */
    public static class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

        private Function<T, K> keyMapper;

        public GroupingBy(Function<T, K> keyMapper) {
            this.keyMapper = keyMapper;
        }

        @Override
        public Supplier<Map<K, List<T>>> supplier() {
            return HashMap::new;
        }

        @Override
        public BiConsumer<Map<K, List<T>>, T> accumulator() {
            return this::add;
        }

        @Override
        public BinaryOperator<Map<K, List<T>>> combiner() {
            return this::merge;
        }

        @Override
        public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return new HashSet<>();
        }

        private void add(Map<K, List<T>> map, T element) {
            K key = keyMapper.apply(element);
            if (map.containsKey(key)) {
                List<T> list = map.get(key);
                list.add(element);
                map.put(key, list);
            } else {
                List<T> list = new ArrayList<>();
                list.add(element);
                map.put(key, list);
            }
        }

        private Map<K, List<T>> merge(Map<K, List<T>> left, Map<K, List<T>> right) {
            return Stream.of(left, right)
                    .flatMap(map -> map.entrySet().stream())
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
    }

}
