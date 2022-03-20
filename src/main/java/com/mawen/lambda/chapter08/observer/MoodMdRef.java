package com.mawen.lambda.chapter08.observer;

/**
 * 支持方法引用
 */
public class MoodMdRef {

    public static void main(String[] args) {
        Moon moon = new Moon();
        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("They're distracted, lets invade earth!");
            }
        });
        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("We made it!");
            }
        });

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }

}
