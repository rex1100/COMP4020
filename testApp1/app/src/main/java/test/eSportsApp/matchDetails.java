package test.eSportsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import test.testapp1.R;



/**
 * Created by The Dude on 3/7/2016.
 */
public class matchDetails  extends AppCompatActivity {
    String teams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        teams = intent.getStringExtra("teams");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_information);
    }

    public void goToNotificaions(View view){
        Intent intent = new Intent(this,gameNotification.class);
        startActivity(intent);
    }

    public void goToTeam(View view)
    {
        Intent teamIntent = new Intent(this, TeamView.class);
        teamIntent.putExtra("KEY", "TSM");
        startActivity(teamIntent);
    }
}
