package test.eSportsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import test.testapp1.R;

/**
 * Created by Thomas on 2016/3/6.
 */
public class Search extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }



    public void backHome(View view)
    {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);

    }

}
