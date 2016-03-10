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

        ListView lolPlayerListView = (ListView) findViewById(R.id.lolPlayerListView);

        List<String> lolPlayerList = new ArrayList<String>();
        lolPlayerList.addAll(Arrays.asList(StoredArrays.lolPlayerArray));

        ArrayAdapter<String> lolPlayerListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lolPlayerList);
        lolPlayerListView.setAdapter(lolPlayerListAdapter);

        ListView hsPlayerListView = (ListView) findViewById(R.id.hsPlayerListView);

        List<String> hsPlayerList = new ArrayList<String>();
        hsPlayerList.addAll(Arrays.asList(StoredArrays.hsPlayerArray));

        ArrayAdapter<String> hsPlayerListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hsPlayerList);
        hsPlayerListView.setAdapter(hsPlayerListAdapter);

        ListView lolTeamListView = (ListView) findViewById(R.id.lolTeamListView);

        List<String> lolTeamList = new ArrayList<String>();
        lolTeamList.addAll(Arrays.asList(StoredArrays.lolTeamArray));

        ArrayAdapter<String> lolTeamListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lolTeamList);
        lolTeamListView.setAdapter(lolTeamListAdapter);

        hsPlayerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                String player = "Amaz";//adapter.getItemAtPosition(position).toString();

                Intent intent = new Intent(HomeScreenActivity.this, hsPlayerView.class);
                intent.putExtra("player", player);

                startActivity(intent);
            }
        });

        lolPlayerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                String player = "Doublelift";//adapter.getItemAtPosition(position).toString();

                Intent intent = new Intent(HomeScreenActivity.this, playerView.class);
                intent.putExtra("player", player);

                startActivity(intent);
            }
        });
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

    }

    public void openSettings(View view)
    {
        Intent intent = new Intent(this, Settings.class);
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

            if(i < 4 && StoredArrays.onSubMenus[i] == 1)
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

            if(i > 3 && StoredArrays.onSubMenus[i] == 1)
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

    public void openLoLPlayerMenu(View view)
    {
        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ListView lolPlayerListView = (ListView) findViewById(R.id.lolPlayerListView);
        lolPlayerListView.setVisibility(View.VISIBLE);
    }

    public void openHsPlayerMenu(View view)
    {
        ViewGroup textLists = (ViewGroup) findViewById(R.id.textContentLayout);
        ListView lsv;

        for(int i=0; i < textLists.getChildCount(); i++) {
            View childView = textLists.getChildAt(i);
            int resID = childView.getId();
            lsv = (ListView) findViewById(resID);

            lsv.setVisibility(View.GONE);
        }

        ListView hsPlayerListView = (ListView) findViewById(R.id.hsPlayerListView);
        hsPlayerListView.setVisibility(View.VISIBLE);
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
