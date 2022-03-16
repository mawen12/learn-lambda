package com.mawen.lambda.chapter04;

/**
 * 多重继承
 */
public class MultiOverrideExample {

    public static void main(String[] args) {
        MusicalCarriage musicalCarriage = new MusicalCarriage();
        System.out.println(musicalCarriage.rock());
    }

    interface Jukebox {
        public default String rock() {
            return "... all over the world";
        }
    }

    interface Carriage {
        public default String rock() {
            return "... from side to side";
        }
    }

    public static class MusicalCarriage implements Jukebox, Carriage {
        @Override
        public String rock() {
            return Jukebox.super.rock();// 此处必须使用增强的super语句指明接口中定义的默认方法
        }
    }



}
