package com.ctyeung.projectpopularmoviesstage1.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ctyeung on 8/19/17.
 */

public class JSONArraySort
{
    protected JSONArray jsonArray;
    protected String key;
    protected double min = 0;
    protected double max = 0;
    protected double mid = 0;

    public JSONArraySort(JSONArray jsonArray, String key)
    {
        this.jsonArray = jsonArray;
        this.key = key;
    }

    public JSONArray sort() {
        // 1st seed object
        JSONArray sorted = new JSONArray();
        JSONObject first = JSONhelper.parseJsonFromArray(jsonArray, 0);
        sorted.put(first);

        // mid point value
        String value = JSONhelper.parseValueByKey(first, key);
        mid = Double.parseDouble(value);

        // step through all objects
        for (int i = 1; i < jsonArray.length(); i++) {
            JSONObject json = JSONhelper.parseJsonFromArray(jsonArray, i);
            String str = JSONhelper.parseValueByKey(first, key);
            Double num = Double.parseDouble(value);
            bisection(num);
        }
        return sorted;
    }

    protected int bisection(Double num)
    {
        return 0;
    }
}
