package com.ctyeung.projectpopularmoviesstage1.utilities;

/**
 * Created by ctyeung on 8/19/17.
 */

public class MovieHelper {
    final public static String BASE_URL = "http://api.themoviedb.org/3/movie/";
    final public static String API_KEY_VALUE = "838bb81a894bc77678913ab8b239cfb3";
    final public static String PARAM_API_KEY = "api_key";

    public static final String SORT_POPULAR = "popular";
    public static final String SORT_TOP_RATED = "top_rated";
    public static final String KEY_POSTER_PATH = "poster_path";
    public static final String KEY_TITLE = "title";
    public static final String KEY_ORIGINAL_TITLE = "original_title";
    public static final String KEY_PLOT = "overview";
    public static final String KEY_RELEASE_DATE = "release_date";
    public static final String KEY_VOTE_AVERAGE = "vote_average";
    public final static String BASE_POSTER_URL = "http://image.tmdb.org/t/p/";

    public final static int INDEX_THUMBNAIL = 3;
    public final static int INDEX_DETAIL = 5;

    public static String getSizeByIndex(int i)
    {
        switch (i) {
            case 0:
                return "w92/";

            case 1:
                return "w154/";

            default:
            case 2:
                return "w185/";

            case 3:
                return "w342/";

            case 4:
                return "w500/";

            case 5:
                return "w780/";

            case 6:
                return "original/";
        }
    }
}
