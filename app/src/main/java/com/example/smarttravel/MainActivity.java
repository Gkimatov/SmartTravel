package com.example.smarttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;


import org.json.JSONException;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        public static final String TRAV_ADV_URL = "https://www.travel-advisory.info/api";
            client.get(TRAV_ADV_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess"); // network request made successfully (tested with debugger & breakpoints)
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG, "Results: " + results.toString());
//                    movies.addAll(Movie.constructMovies(results));
//                    movieAdapter.notifyDataSetChanged();
//                    Log.i(TAG, "Movies: " + movies.size());
                } catch (JSONException e) {
                    Log.e(TAG, "Reached JSON Exception", e);
                }
            }
            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}
