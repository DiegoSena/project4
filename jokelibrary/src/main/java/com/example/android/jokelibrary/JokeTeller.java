package com.example.android.jokelibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeTeller {

    private List<String> jokes;
    private Random random = new Random();

    public JokeTeller(){
        jokes = new ArrayList<>();
        jokes.add("What's the object oriented way to become wealthy? Inheritance.");
        jokes.add("What is a programmer's favorite hangout place? Foo bar.");
        jokes.add("Why do Java programmers have to wear glasses? Because they don't C#.");
    }

    public String getJoke(){
        return jokes.get(random.nextInt(jokes.size()));
    }
}
