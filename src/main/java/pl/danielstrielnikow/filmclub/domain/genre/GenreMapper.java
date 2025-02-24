package pl.danielstrielnikow.filmclub.domain.genre;

import java.util.HashMap;
import java.util.Map;

public class GenreMapper {

    private static final Map<Integer, String> GENRE_MAP = new HashMap<>() {{
        put(0, "Drama");
        put(1, "Comedy");
        put(2, "Documentary");
        put(3, "Action");
        put(4, "Romance");
        put(5, "Thriller");
        put(6, "Crime");
        put(7, "Horror");
        put(8, "Adventure");
        put(9, "Family");
        put(10, "Animation");
        put(11, "Reality-TV");
        put(12, "Mystery");
        put(13, "Music");
        put(14, "Talk-Show");
        put(15, "Fantasy");
        put(16, "History");
        put(17, "Biography");
        put(18, "Sci-Fi");
        put(19, "Sport");
        put(20, "Musical");
        put(21, "Adult");
        put(22, "War");
        put(23, "News");
        put(24, "Game-Show");
        put(25, "Western");
        put(26, "Short");
        put(27, "Film-Noir");
    }};

    public static String getGenreByIndex(int index) {
        return GENRE_MAP.get(index);
    }

    public Integer getGenreIndexByName(String genreName) {
        return switch (genreName.toLowerCase()) {
            case "drama" -> 0;
            case "comedy" -> 1;
            case "documentary" -> 2;
            case "action" -> 3;
            case "romance" -> 4;
            case "thriller" -> 5;
            case "crime" -> 6;
            case "horror" -> 7;
            case "adventure" -> 8;
            case "family" -> 9;
            case "animation" -> 10;
            case "reality-tv" -> 11;
            case "mystery" -> 12;
            case "music" -> 13;
            case "talk-show" -> 14;
            case "fantasy" -> 15;
            case "history" -> 16;
            case "biography" -> 17;
            case "sci-fi" -> 18;
            case "sport" -> 19;
            case "musical" -> 20;
            case "adult" -> 21;
            case "war" -> 22;
            case "news" -> 23;
            case "game-show" -> 24;
            case "western" -> 25;
            case "short" -> 26;
            case "film-noir" -> 27;
            default -> null;  // Gatunek nieznany
        };
    }
}

