package test.eSportsApp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.testapp1.R;
import test.eSportsApp.StoredArrays;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class HomeScreenActivity extends AppCompatActivity {

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */


    int[] onSubMenus = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        ListView lolNewsListView = (ListView) findViewById(R.id.lolNewsListView);

        List<String> lolNewsList = new ArrayList<String>();
        lolNewsList.addAll(Arrays.asList(StoredArrays.lolNewsArray));

        ArrayAdapter<String> lolNewsListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lolNewsList);
        lolNewsListView.setAdapter(lolNewsListAdapter);


        ListView lolScheduleListView = (ListView) findViewById(R.id.lolScheduleListView);

        List<String> lolScheduleList = new ArrayList<String>();
        lolScheduleList.addAll(Arrays.asList(StoredArrays.lolScheduleArray));

        ArrayAdapter<String> lolScheduleListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lolScheduleList);
        lolScheduleListView.setAdapter(lolScheduleListAdapter);


        ListView lolTeamListView = (ListView) findViewById(R.id.lolTeamListView);

        List<String> lolTeamList = new ArrayList<String>();
        lolTeamList.addAll(Arrays.asList(StoredArrays.lolTeamArray));

        ArrayAdapter<String> lolTeamListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lolTeamList);
        lolTeamListView.setAdapter(lolTeamListAdapter);

        lolTeamListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                String team = adapter.getItemAtPosition(position).toString();

                Intent teamIntent = new Intent(HomeScreenActivity.this, TeamView.class);
                teamIntent.putExtra("KEY", team);

                startActivity(teamIntent);

            }
        });
        lolScheduleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                String data = adapter.getItemAtPosition(position).toString();
                data = data.substring(8);
                Intent intent = new Intent(HomeScreenActivity.this, matchDetails.class);
                startActivity(intent);
                intent.putExtra("teams", data);
            }
        });

        String isEnabled;
        Intent intent=getIntent();

        isEnabled = intent.getStringExtra("lolButton1");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[0] = 0;
        }
        else{
            onSubMenus[0] = 1;
        }

        isEnabled = intent.getStringExtra("lolButton2");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[1] = 0;
        }
        else{
            onSubMenus[1] = 1;
        }

        isEnabled = intent.getStringExtra("lolButton3");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[2] = 0;
        }
        else{
            onSubMenus[2] = 1;
        }

        isEnabled = intent.getStringExtra("lolButton4");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[3] = 0;
        }
        else{
            onSubMenus[3] = 1;
        }

        isEnabled = intent.getStringExtra("hsButton1");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[4] = 0;
        }
        else{
            onSubMenus[4] = 1;
        }

        isEnabled = intent.getStringExtra("hsButton2");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[5] = 0;
        }
        else{
            onSubMenus[5] = 1;
        }

        isEnabled = intent.getStringExtra("hsButton3");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSubMenus[6] = 0;
        }
        else{
            onSubMenus[6] = 1;
        }
    }

    public void openSettings(View view)
    {
        Intent intent = new Intent(this, Settings.class);
        if(onSubMenus[0] == 0)
        {
            intent.putExtra("lolButton1", "disabled");
        } else {
            intent.putExtra("lolButton1", "enabled");
        }
        if(onSubMenus[1] == 0)
        {
            intent.putExtra("lolButton2", "disabled");
        } else {
            intent.putExtra("lolButton2", "enabled");
        }
        if(onSubMenus[2] == 0)
        {
            intent.putExtra("lolButton3", "disabled");
        } else {
            intent.putExtra("lolButton3", "enabled");
        }
        if(onSubMenus[3] == 0)
        {
            intent.putExtra("lolButton4", "disabled");
        } else {
            intent.putExtra("lolButton4", "enabled");
        }
        if(onSubMenus[4] == 0)
        {
            intent.putExtra("hsButton1", "disabled");
        } else {
            intent.putExtra("hsButton1", "enabled");
        }
        if(onSubMenus[5] == 0)
        {
            intent.putExtra("hsButton2", "disabled");
        } else {
            intent.putExtra("hsButton2", "enabled");
        }
        if(onSubMenus[6] == 0)
        {
            intent.putExtra("hsButton3", "disabled");
        } else {
            intent.putExtra("hsButton3", "enabled");
        }

        startActivity(intent);
    }

    public void openLolSubMenu(View view)
    {
        Button buttonSwitch;

        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ViewGroup subMenu = (ViewGroup) findViewById(R.id.gameSubMenuLayout);

        for(int i=0; i < subMenu.getChildCount(); i++) {
            View childView = subMenu.getChildAt(i);
            int resID = childView.getId();
            buttonSwitch = (Button) findViewById(resID);

            if(i < 4 && onSubMenus[i] == 1)
            {
                buttonSwitch.setVisibility(View.VISIBLE);
            } else {
                buttonSwitch.setVisibility(View.GONE);
            }
        }
    }

    public void openHsSubMenu(View view)
    {
        Button buttonSwitch;

        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ViewGroup subMenu = (ViewGroup) findViewById(R.id.gameSubMenuLayout);

        for(int i=0; i < subMenu.getChildCount(); i++) {
            View childView = subMenu.getChildAt(i);
            int resID = childView.getId();
            buttonSwitch = (Button) findViewById(resID);

            if(i > 3 && onSubMenus[i] == 1)
            {
                buttonSwitch.setVisibility(View.VISIBLE);
            } else {
                buttonSwitch.setVisibility(View.GONE);
            }
        }
    }

    public void openLoLNewsMenu(View view)
    {
        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ListView lolNewsListView = (ListView) findViewById(R.id.lolNewsListView);
        lolNewsListView.setVisibility(View.VISIBLE);
    }

    public void openLoLScheduleMenu(View view)
    {
        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ListView LoLScheduleListView = (ListView) findViewById(R.id.lolScheduleListView);
        LoLScheduleListView.setVisibility(View.VISIBLE);
    }

    public void openLoLTeamMenu(View view)
    {
        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ListView lolNewsTeamView = (ListView) findViewById(R.id.lolTeamListView);
        lolNewsTeamView.setVisibility(View.VISIBLE);
    }

    public void openSearch(View view)
    {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    public void openLoLScheduler(View view){
        Intent intent = new Intent(this,lolScheduler.class);
        startActivity(intent);
    }

    public void openDotaScheduler(View view){
        Intent intent = new Intent(this,Dota2Scheduler.class);
        startActivity(intent);

    }

    public void openHsScheduler(View view){
        Intent intent = new Intent(this,HsScheduler.class);
        startActivity(intent);
    }

    public void openHotsScheduler(View view){
        Intent intent = new Intent(this,HotsScheduler.class);
        startActivity(intent);
    }

}
