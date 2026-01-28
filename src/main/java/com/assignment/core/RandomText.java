package com.assignment.core;

import java.util.Random;

public class RandomText {

    private static final String[] SENTENCES = {
            "I had a smooth experience overall and the process was easy to follow.",
            "The website layout is clean and information is presented clearly.",
            "Customer support was responsive and helped resolve my questions quickly.",
            "The review submission flow worked as expected without any issues.",
            "Navigation across the site felt intuitive and user friendly.",
            "I appreciate how detailed the policy information is on the platform.",
            "Everything loaded properly and there were no performance problems.",
            "The overall experience met my expectations and felt reliable.",
            "The design is modern and makes it easy to find what you need.",
            "I did not face any errors while using the main features."
    };

    public static String generate(int minChars) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();

        while (text.length() < minChars) {
            text.append(SENTENCES[random.nextInt(SENTENCES.length)]);
            text.append(" ");
        }

        return text.toString().trim();
    }
}