package com.udacity.gradle.builditbigger.backend;

import theo.tziomakas.jokeslib.MyCoolJokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {

        myData = new MyCoolJokes().getJoke();
        return myData;

    }
}