package com.mawen.lambda.chapter08.observer;

/**
 * NASA也能观察到有人登陆月球
 */
public class Nasa implements LandingObserver {

    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We made it!");
        }
    }
}
