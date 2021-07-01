package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static String web;
    public static void main(String args[]) throws IOException {
        System.out.println("Введите адрес web-страницы для получекния статистики по количеству уникальных слов в тексте.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        web = reader.readLine();
        Words words = new Words(web);
        print(words.parse(web));
    }

    public static void print (Map<String, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}