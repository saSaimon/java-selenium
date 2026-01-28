package com.assignment.core;

import java.util.Random;

public class RandomText {
    public static String generate(int minChars) {
        String base = "This is an automated review text for assignment validation. ";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        while (sb.length() < minChars) {
            sb.append(base);
            sb.append("Ref=").append(r.nextInt(99999)).append(". ");
        }
        return sb.toString();
    }
}