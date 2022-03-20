package com.mawen.lambda.chapter08.observer;

/**
 * 外星人观察人类登陆月球
 */
public class Aliens implements LandingObserver {

    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("They're distracted, lets invade earth!");
        }
    }
}
