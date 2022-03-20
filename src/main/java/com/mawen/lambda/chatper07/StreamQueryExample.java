package com.mawen.lambda.chatper07;

import com.mawen.lambda.model.Album;

/**
 * 孤独的覆盖
 */
public class StreamQueryExample {

    public static void main(String[] args) {

    }


    /**
     * 在数据库中查找艺术家，确保每个线程只做一次这种查询
     */
    ThreadLocal<Album> thisAlbum = new ThreadLocal<>(){
        @Override
        protected Album initialValue() {
            return StreamQueryExample.lookupCurrentAlbum();
        }
    };

    /**
     * 使用工厂方法
     * - 清晰可读
     * - 信噪比更低
     */
    ThreadLocal<Album> thatAlbum = ThreadLocal.withInitial(() -> StreamQueryExample.lookupCurrentAlbum());

    public static Album lookupCurrentAlbum() {
        return null;
    }

}
