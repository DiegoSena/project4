package com.udacity.gradle.builditbigger.backend;

import com.example.android.jokelibrary.JokeTeller;

/** The object model for the data we are sending through endpoints */
public class JokeTellerBean {

    private JokeTeller jokeTeller = new JokeTeller();

    public String getJoke(){
        return jokeTeller.getJoke();
    }


}