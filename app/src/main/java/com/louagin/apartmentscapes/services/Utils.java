package com.louagin.apartmentscapes.services;

import java.util.Random;

public class Utils {
    public static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
