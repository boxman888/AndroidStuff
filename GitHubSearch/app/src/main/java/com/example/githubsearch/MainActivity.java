package com.example.githubsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private String doGitHubSearch(String query){
         String url = GitHubUtils.buildGitHubSearchURL(query);
         Log.d(TAG, "querying search URL: " + url);

         String results = null;
         try{
             results = NetworkUtils.doHTTPGet(url);
         } catch (IOException e){
             e.printStackTrace();
        }
        return results;
    }
}
