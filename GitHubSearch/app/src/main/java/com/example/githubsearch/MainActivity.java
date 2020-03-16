package com.example.githubsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.githubsearch.R;
import com.example.githubsearch.utils.GitHubUtils;
import com.example.githubsearch.utils.NetworkUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mSearchResultsRV;
    private EditText mSearchBoxET;
    private GitHubSearchAdapter mGitHubSearchAdapter;

    private String[] dummySearchResults = {
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
            "Dummy search results",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxET = findViewById(R.id.et_search_box);
        mSearchResultsRV = findViewById(R.id.rv_search_results);

        mSearchResultsRV.setLayoutManager(new LinearLayoutManager(this));
        mSearchResultsRV.setHasFixedSize(true);

        mGitHubSearchAdapter = new GitHubSearchAdapter();
        mSearchResultsRV.setAdapter(mGitHubSearchAdapter);

        Button searchButton = findViewById(R.id.btn_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = mSearchBoxET.getText().toString();
                if (!TextUtils.isEmpty(searchQuery)) {
                    doGitHubSearch(searchQuery);
                }
            }
        });
    }

    private void doGitHubSearch(String query){
         String url = GitHubUtils.buildGitHubSearchURL(query);
         Log.d(TAG, "querying search URL: " + url);
         new GitHubSearchTask().execute(url);
    }

    public class GitHubSearchTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            String results = null;
            try{
                results = NetworkUtils.doHTTPGet(url);
            } catch (IOException e){
                e.printStackTrace();
            }
            return results;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            if (s != null){
                ArrayList<String> searchResultsList = new ArrayList<>();
                searchResultsList.add(s);
                mGitHubSearchAdapter.updateSearchResults(new ArrayList<String>(Arrays.asList(dummySearchResults)));
                mSearchBoxET.setText("");
            }
        }
    }
}
