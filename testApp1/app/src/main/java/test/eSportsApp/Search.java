package test.eSportsApp;

import android.app.usage.NetworkStats;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.*;
import android.view.*;
import android.app.*;
import android.widget.*;
import test.testapp1.R;

/**
 * Created by Thomas on 2016/3/6.
 */
public class Search extends AppCompatActivity{

    private Button searchButton;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ListView onSearchView = (ListView) findViewById(R.id.listSearchView);

        listView = new ListView(this);
        searchButton = (Button) findViewById(R.id.searchButton);

        onSearchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                String data = adapter.getItemAtPosition(position).toString();
                data = data.substring(8);
                Intent intent = new Intent(Search.this, matchDetails.class);
                startActivity(intent);
                intent.putExtra("teams", data);
            }
        });
    }


    public void onSearchClick(View v){

        String[] searchResults = {"League of Legends (Game)", "Patch 6.4 Update", "TSM", "CLG vs. QG Game 3 (Live)"};

        ListView onSearchView = (ListView) findViewById(R.id.listSearchView);

        ArrayAdapter<String> onSearchAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchResults);

        onSearchView.setAdapter(onSearchAdapter);

    }



    public void backHome(View view)
    {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

}
