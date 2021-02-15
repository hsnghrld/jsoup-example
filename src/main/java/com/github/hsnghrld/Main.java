package com.github.hsnghrld;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Main {
    private static final String movie_or_series_name = "Lucifer (TV Series)";
    private static final String movie_or_series_imdb_id = "tt4052886";

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.parse(
                new URL(String.format("https://www.imdb.com/title/%s/fullcredits", movie_or_series_imdb_id)),
                30_000
        );

        System.out.printf("Cast of %s%n%n", movie_or_series_name);

        document.getElementsByClass("cast_list").first().getElementsByTag("tr").forEach(element -> {
            if (!element.hasText())
                return;
            System.out.printf(
                    "%-30s%-30s%s%n",
                    element.select("td:not([class^='primary_photo']) > a[href*='/name/']").size() > 0 ? element.select("td:not([class^='primary_photo']) > a[href*='/name/']").first().ownText() : "",
                    element.getElementsByAttributeValueContaining("href", "/characters/").size() > 0 ? element.getElementsByAttributeValueContaining("href", "/characters/").first().ownText() : "",
                    element.getElementsByClass("toggle-episodes").size() > 0 ? element.getElementsByClass("toggle-episodes").first().ownText() : ""
            );
        });

    }
}
