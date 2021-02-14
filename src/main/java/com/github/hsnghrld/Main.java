package com.github.hsnghrld;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.parse(
                new URL("https://maktabkhooneh.org/course/%D8%A2%D9%85%D9%88%D8%B2%D8%B4-Git-mk796/"),
                10_000
        );

        System.out.println(document.body().toString());

    }
}
