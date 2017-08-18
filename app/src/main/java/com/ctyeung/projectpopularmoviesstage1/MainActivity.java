package com.ctyeung.projectpopularmoviesstage1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;



import java.io.IOException;
import java.net.URL;
import com.ctyeung.projectpopularmoviesstage1.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements GreenAdapter.ListItemClickListener
{
    private GreenAdapter mAdapter;
    private RecyclerView mNumbersList;
    private Toast mtoast;
    private GreenAdapter.ListItemClickListener listener;
    private JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumbersList = (RecyclerView) findViewById(R.id.rv_movie);
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mNumbersList.setLayoutManager(layoutManager);
        listener = this;

        requestMovie();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {

            case R.id.sort_popular:
               // mAdapter = new GreenAdapter(NUM_LIST_ITEMS, this);
                // mNumbersList.setAdapter(mAdapter);
                return true;

            case R.id.sort_top_rated:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void requestMovie()
    {
        URL url = NetworkUtils.buildMainPageUrl();
        new GithubQueryTask().execute(url);
    }

    public class GithubQueryTask extends AsyncTask<URL, Void, String>
    {
        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String githubSearchResults = null;
            try
            {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            return githubSearchResults;
        }

        protected JSONObject parseJson(String str)
        {
            JSONObject json = null;

            try
            {
                json = new JSONObject(str);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            return json;
        }

        protected  JSONArray parseJsonArray(JSONObject json, String key)
        {
            JSONArray jsonArray = null;
            try
            {
                jsonArray = json.getJSONArray("results");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            return jsonArray;
        }

        protected void onPostExecute(String str)
        {
            JSONObject json = parseJson(str);

            if(null != json)
            {
                jsonArray = parseJsonArray(json, "results");
                int size = jsonArray.length();

                if(null!=jsonArray && size>0)
                {
                    mAdapter = new GreenAdapter(size, listener, jsonArray);
                    mNumbersList.setAdapter(mAdapter);
                    mNumbersList.setHasFixedSize(true);
                }
            }
        }
    }

    @Override
    public void onListItemClick(int clickItemIndex)
    {
        if(mtoast!=null)
            mtoast.cancel();

        // launch detail activity
        JSONObject json = mAdapter.parseJsonFromArray(jsonArray, clickItemIndex);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, json.toString());
        startActivity(intent);

        // toast
        String toastmessage = "Item #" + clickItemIndex + "clicked";
        mtoast = Toast.makeText(this, toastmessage, Toast.LENGTH_LONG);
        mtoast.show();
    }
}