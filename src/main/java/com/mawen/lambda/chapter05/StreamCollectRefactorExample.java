package com.mawen.lambda.chapter05;

import com.mawen.lambda.model.Artist;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 流 - 收集器 - 重构收集器
 */
public class StreamCollectRefactorExample {

    public static void main(String[] args) {

    }

    /**
     * 使用for循环和StringBuilder格式化艺术家姓名
     * - 基础使用
     * - 形式不够优雅
     */
    public static String genStringByForeach(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            builder.append(artist.getName());
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * 使用forEach和StringBuilder格式化艺术家姓名
     * - forEach 方法笨重
     * - 可读性不高
     */
    public static String genStringByForEach(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        artists.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                });

        builder.append("]");
        return builder.toString();
    }

    /**
     * 使用reduce和StringBuilder格式化艺术家姓名
     * - 代码可读性差
     * - 无关代码杂乱无章
     */
    public static String genStringByReduce(List<Artist> artists) {
        StringBuilder reduced = artists.stream()
                .map(Artist::getName)
                .reduce(new StringBuilder(), // 初始状态
                        (builder, name) -> {  // 将姓名连接到builder上
                            if (builder.length() > 0) {
                                builder.append(", ");
                            }
                            builder.append(name);
                            return builder;
                        },
                        (left, right) -> left.append(right)); // 将两者连接起来

        reduced.insert(0, "[");
        reduced.append("]");
        return reduced.toString();
    }

    /**
     * 使用reduce和StringCombiner类格式化艺术家姓名
     * - StringCombiner.add 代理字符拼接操作
     * - StringCombiner.merge 代理两个连接器操作
     */
    public static String genStrByReduceAndStringCombiner(List<Artist> artist) {
        StringCombiner combined = artist.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(",", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge);

        return combined.toString();
    }

    /**
     * 上一个方法的优化版本
     * - 该方法具备了初步的可读性
     * - 没有重用性，只能对String类型可用
     */
    public static String genStrByReduceAndStringCombinerV2(List<Artist> artist) {
        return artist.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(",", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge)
                .toString();
    }

    /**
     * 使用定制的收集器 StringCollector 收集字符串
     * - 将对字符串的所有连接操作代理给了定制的收集器，应用程序无需关心 StringCollector 对象的任何内部细节
     * - 将 StringCollector 和框架中其他 Collector 对象用起来是一样的
     */
    public static String genStrByReduceAndStringCollect(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .collect(new StringCollector(",", "[", "]"));
    }

    public static class StringCombiner {

        private StringBuilder builder;

        private String split;

        private String prefix;

        private String suffix;


        public StringCombiner(String split, String prefix, String suffix) {
            this.builder = new StringBuilder();
            this.prefix = prefix;
            this.suffix = suffix;
            this.split = split;
        }

        public boolean areAtStart() {
            return this.builder.length() == 0;
        }

        /**
         * add 操作，在内部将操作代理给一个StringBuilder对象
         * - 如果刚开始连接，则在最前面添加前缀
         * - 否则添加分隔符
         * - 最后添加新的元素
         * @param element 待添加的元素
         * @return
         */
        public StringCombiner add(String element) {
            if (areAtStart()) {
                builder.append(prefix);
            } else {
                builder.append(split);
            }
            builder.append(element);
            return this;
        }

        /**
         * merge 操作，在内部将操作代理给一个StringBuilder对象
         * @param other 需要合并的StringCombiner
         * @return 合并后的StringCombiner
         */
        public StringCombiner merge(StringCombiner other) {
            this.builder.append(other.getBuilder());
            return this;
        }

        public String toString() {
            builder.insert(0, prefix);
            builder.append(suffix);
            return builder.toString();
        }

        public StringBuilder getBuilder() {
            return builder;
        }
    }

    /**
     * 自定义收集器
     *
     */
    public static class StringCollector implements Collector<String, StringCombiner, String> {
        public StringBuilder builder;

        private String delim;

        private String prefix;

        private String suffix;

        public StringCollector(String delim, String prefix, String suffix) {
            this.builder = new StringBuilder();
            this.delim = delim;
            this.prefix = prefix;
            this.suffix = suffix;
        }

        /**
         * Supplier 是创建容器的工厂
         */
        @Override
        public Supplier<StringCombiner> supplier() {
            return () -> new StringCombiner(delim, prefix, suffix);
        }

        /**
         * accumulator 是一个函数，他将当前元素叠加收集器
         */
        @Override
        public BiConsumer<StringCombiner, String> accumulator() {
            return StringCombiner::add;
        }

        /**
         * combiner 合并两个容器
         */
        @Override
        public BinaryOperator<StringCombiner> combiner() {
            return StringCombiner::merge;
        }

        /**
         * finisher 方法返回收集操作的最终结果
         */
        @Override
        public Function<StringCombiner, String> finisher() {
            return StringCombiner::toString;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return null;
        }
    }
}
