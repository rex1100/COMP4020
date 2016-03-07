package test.eSportsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import test.testapp1.R;

/**
 * Created by Yang on 16-03-06.
 */
public class Dota2Scheduler extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dotaschedule);

    }



    public void backHome(View view)
    {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);


    }
}
