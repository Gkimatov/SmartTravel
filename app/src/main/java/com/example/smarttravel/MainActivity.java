package com.example.smarttravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;
import org.json.JSONArray;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import okhttp3.Headers;


public class MainActivity extends AppCompatActivity {
    public static final String TRAV_ADV_URL = "https://www.travel-advisory.info/api";

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AsyncHttpClient client = new AsyncHttpClient();
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
