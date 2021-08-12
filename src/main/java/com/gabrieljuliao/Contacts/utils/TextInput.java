package com.gabrieljuliao.Contacts.utils;

public class TextInput {
    public static String firstLetterUppercase(String word) {
        word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        return word;
    }

    public static String allLowerCase(String word) {
        return word.toLowerCase();
    }
}
