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

    private List<String> data = new ArrayList<String>();
    private Button searchButton;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        data.add("Dota");
        data.add("Dota2");
        data.add("HOTs");
        data.add("LOL");
        data.add("Hs");
        data.add("COD");
        listView = new ListView(this);
        searchButton = (Button) findViewById(R.id.searchButton);
        //searchButton.setOnClickListener(this);
        //searchButton.setOnTouchListener(this);
        //listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));
        //setContentView(listView);
    }

    public boolean onTouch(View v,MotionEvent event){
        if(event.getAction()== MotionEvent.ACTION_UP){
            listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));
            setContentView(listView);
        }
        return false;
    }

    public void onSearchClick(View v){

        String[] searchResults = {"League of Legends (Game)", "Patch 6.4 Update", "TSM", "CLG vs. QG Game 3 (Live)"};

        ListView onSearchView = (ListView) findViewById(R.id.listSearchView);

        ArrayAdapter<String> onSearchAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchResults);

        onSearchView.setAdapter(onSearchAdapter);
    }

    private List<String> getData(){
        return data;
    }


    public void backHome(View view)
    {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);

    }

}
