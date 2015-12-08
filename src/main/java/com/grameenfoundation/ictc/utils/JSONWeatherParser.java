/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils;

/**
 *
 * @author skwakwa
 */
import com.grameenfoundation.ictc.wrapper.Location;
import com.grameenfoundation.ictc.wrapper.OpenWeather;
import com.grameenfoundation.ictc.wrapper.WeatherWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class JSONWeatherParser {

    public static List<WeatherWrapper> getWeather(String data) throws JSONException {

        List<WeatherWrapper> weathers = new ArrayList<>();
        JSONObject jObject = new JSONObject(data);

        JSONArray jArray = jObject.getJSONArray("list");

        JSONObject cityObj = getObject("city", jObject);
        String city = getString("name", cityObj);
        int cityId = getInt("id", cityObj);

//        WeatherWrapper wrapper = new WeatherWrapper();
        for (int i = 0; i < jArray.length(); i++) {

            JSONObject jObj = jArray.getJSONObject(i);
            WeatherWrapper wrapper = new WeatherWrapper();
            OpenWeather weather = new OpenWeather();
// We create out JSONObject from the data
//            JSONObject jObj = new JSONObject(data);
            wrapper.setTime(getLong("dt", jObj));
            String dt_txt = getString("dt_txt", jObj);
            System.out.println("Date Txt: "+dt_txt);
            dt_txt = dt_txt.replaceAll(" ", dt_txt);
             dt_txt = dt_txt.replaceAll(":", dt_txt);
             
             
// We start extracting the info
            Location loc = new Location();

            wrapper.setLocation(city);
            wrapper.setLocationId(String.valueOf(cityId));

// We get weather info (This is an array)
            JSONArray jArr = jObj.getJSONArray("weather");
// We use only the first value
            JSONObject JSONWeather = jArr.getJSONObject(0);

            JSONObject mainObj = getObject("main", jObj);

            wrapper.setTemprature(getFloat("temp", mainObj));
            wrapper.setMinTemprature(getFloat("temp_min", mainObj));
            wrapper.setMaxTemprature(getFloat("temp_max", mainObj));
            wrapper.setDetail(getString("description", JSONWeather));

            wrapper.setIcon(getString("icon", JSONWeather));

            weathers.add(wrapper);
        }
        return weathers;
    }

    private static JSONObject getObject(String tagName, JSONObject jObj) throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }

    private static int getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }

    private static Long getLong(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getLong(tagName);
    }
}
