package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Words {

    Map<String, Integer> map = new HashMap<>();

    public Words(String web) {
     //   map.parse(web);
    }

    public  Map<String, Integer> parse (String web) throws IOException {
        Document document = Jsoup.connect(web).get();
        String answer = document.body().html();
        String str = Jsoup.parse(answer).text();

        String[] words = str.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[(/)]*|[)]*|[;]*|[©]*|[<]*|[-]*|[—]*|[>]*|[\\[]*|[\\]]*|[=]*|[«]*|[»]*|[!]*|[\"]*|[\']*|[?]*]");
        for(int i = 0; i < words.length; i++) {
            Integer count = 0;
            for(int j = 0; j < words.length; j++) {
                words[j] = words[j].toUpperCase();
                if (words[i].equals(words[j])){
                    count++;
                }
            }
            map.put(words[i], count);
            count = 0;
        }
        return map;
    }
}
