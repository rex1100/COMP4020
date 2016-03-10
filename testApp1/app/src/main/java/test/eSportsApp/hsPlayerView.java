package test.eSportsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import test.testapp1.R;

/**
 * Created by The Dude on 3/7/2016.
 */
public class hsPlayerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_player);

        String team;

        Bundle extras = getIntent().getExtras();
        team = extras.getString("player");

        TextView teamTxt = (TextView)findViewById(R.id.playerName);
        teamTxt.setText(team);

        ImageView img = (ImageView)findViewById(R.id.archon);
        img.setImageResource(R.drawable.archon);

    }

    public void openHomeMenu(View view)
    {
        Switch amazSwitch = (Switch) findViewById(R.id.amazUpdateSwitch);
        //TODO: these need to be changed
        //String[] newLolNewsArray = {"Patch 6.4 Notes","TSM News Player Announcement", "Wow SKT Sucks","IEM Katowice Update #3","TSM vs. SKT","QG vs. QG Game 3","Feeder Noob Trolled My Game","TSM Daily Life Vlog #3"};
        //String[] oldLolNewsArray = {"Patch 6.4 Notes","Wow SKT Sucks","IEM Katowice Update #3","CLG vs. QG Game 3","Feeder Noob Trolled My Game"};
        /*
        if(tsmSwitch.isChecked())
        {
            StoredArrays.lolNewsArray = newLolNewsArray;
        } else
        {
            StoredArrays.lolNewsArray = oldLolNewsArray;
        }
        */

        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

}
