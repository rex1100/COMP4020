package test.eSportsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import test.testapp1.R;


public class gameNotification extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_notifications);
    }

    public void saveNotification(View view)
    {
        // do the saving here
        Intent intent = new Intent(this, matchDetails.class);
        startActivity(intent);
    }
}
