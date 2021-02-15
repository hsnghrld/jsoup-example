package com.github.hsnghrld;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.parse(
                new URL("https://maktabkhooneh.org/course/%D8%A2%D9%85%D9%88%D8%B2%D8%B4-Git-mk796/"),
                10_000
        );

        document.getElementsByClass("chapter").forEach(element -> {
            System.out.println(element.getElementsByClass("chapter__title").first().ownText());
            element.getElementsByClass("chapter__unit").forEach(element1 -> {
                if (element1.getElementsByClass("chapter__unit-info-item--score").isEmpty())
                    System.out.printf(
                            "%c%-40s %s%n",
                            '\t',
                            element1.getElementsByClass("h-slider__wrapper").first().ownText(),
                            element1.getElementsByClass("chapter__unit-time").first().ownText()
                    );
            });
        });

    }
}
