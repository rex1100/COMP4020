package test.eSportsApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import test.testapp1.R;


public class Settings extends AppCompatActivity {

    int[] onSwitches = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        String isEnabled;
        Switch onSwitch;
        Intent intent=getIntent();
        ViewGroup switches = (ViewGroup) findViewById(R.id.settingsSwitchLayout);

        isEnabled = intent.getStringExtra("lolButton1");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[0] = 0;
        }
        else{
            onSwitches[0] = 1;
        }

        isEnabled = intent.getStringExtra("lolButton2");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[1] = 0;
        }
        else{
            onSwitches[1] = 1;
        }

        isEnabled = intent.getStringExtra("lolButton3");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[2] = 0;
        }
        else{
            onSwitches[2] = 1;
        }

        isEnabled = intent.getStringExtra("lolButton4");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[3] = 0;
        }
        else{
            onSwitches[3] = 1;
        }

        isEnabled = intent.getStringExtra("hsButton1");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[4] = 0;
        }
        else{
            onSwitches[4] = 1;
        }

        isEnabled = intent.getStringExtra("hsButton2");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[5] = 0;
        }
        else{
            onSwitches[5] = 1;
        }

        isEnabled = intent.getStringExtra("hsButton3");
        if(isEnabled==null||isEnabled.equals("disabled")){
            onSwitches[6] = 0;
        }
        else{
            onSwitches[6] = 1;
        }

        for(int i = 0; i < 7; i++) {
            View childView = switches.getChildAt(i);
            int resID = childView.getId();
            onSwitch = (Switch) findViewById(resID);

            if (onSwitches[i] == 0) {
                onSwitch.setChecked(false);
            } else {
                onSwitch.setChecked(true);
            }
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.games_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Switch lolSwitch1 = (Switch)findViewById(R.id.LoLswitch1);
        lolSwitch1.setVisibility(View.VISIBLE);

        Switch lolSwitch2 = (Switch)findViewById(R.id.LoLswitch2);
        lolSwitch2.setVisibility(View.VISIBLE);

        Switch lolSwitch3 = (Switch)findViewById(R.id.LoLswitch3);
        lolSwitch3.setVisibility(View.VISIBLE);

        Switch lolSwitch4 = (Switch)findViewById(R.id.LoLswitch4);
        lolSwitch4.setVisibility(View.VISIBLE);


        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String game = parent.getItemAtPosition(position).toString();
                LinearLayout subMenu = (LinearLayout) findViewById(R.id.settingsSwitchLayout);

                Switch switchRemove;
                ViewGroup parentView = (ViewGroup) findViewById(R.id.settingsSwitchLayout);
                for (int i = 0; i < parentView.getChildCount(); i++) {
                    View childView = parentView.getChildAt(i);
                    int resID = childView.getId();
                    switchRemove = (Switch) findViewById(resID);
                    switchRemove.setVisibility(View.GONE);
                }

                switch (game) {
                    case "League of Legends":
                        Switch lolSwitch1 = (Switch) findViewById(R.id.LoLswitch1);
                        lolSwitch1.setVisibility(View.VISIBLE);

                        Switch lolSwitch2 = (Switch) findViewById(R.id.LoLswitch2);
                        lolSwitch2.setVisibility(View.VISIBLE);

                        Switch lolSwitch3 = (Switch) findViewById(R.id.LoLswitch3);
                        lolSwitch3.setVisibility(View.VISIBLE);

                        Switch lolSwitch4 = (Switch) findViewById(R.id.LoLswitch4);
                        lolSwitch4.setVisibility(View.VISIBLE);
                        break;
                    case "Hearthstone":
                        Switch hsSwitch1 = (Switch) findViewById(R.id.HSswitch1);
                        hsSwitch1.setVisibility(View.VISIBLE);

                        Switch hsSwitch2 = (Switch) findViewById(R.id.HSswitch2);
                        hsSwitch2.setVisibility(View.VISIBLE);

                        Switch hsSwitch3 = (Switch) findViewById(R.id.HSswitch3);
                        hsSwitch3.setVisibility(View.VISIBLE);
                        break;
                    default:
                        Switch defaultSwitch = (Switch) findViewById(R.id.Defaultswitch1);
                        defaultSwitch.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void openHomeMenu(View view)
    {
        final Intent intent = new Intent(this, HomeScreenActivity.class);

        Switch lolSwitch1 = (Switch) findViewById(R.id.LoLswitch1);
        if(lolSwitch1.isChecked())
        {
            intent.putExtra("lolButton1", "enabled");
            onSwitches[0]=1;
        } else {
            intent.putExtra("lolButton1", "disabled");
            onSwitches[0]=0;
        }

        Switch lolSwitch2 = (Switch) findViewById(R.id.LoLswitch2);
        if(lolSwitch2.isChecked())
        {
            intent.putExtra("lolButton2", "enabled");
            onSwitches[1]=1;
        } else {
            intent.putExtra("lolButton2", "disabled");
            onSwitches[1]=0;
        }
        Switch lolSwitch3 = (Switch) findViewById(R.id.LoLswitch3);
        if(lolSwitch3.isChecked())
        {
            intent.putExtra("lolButton3", "enabled");
            onSwitches[2]=1;
        } else {
            intent.putExtra("lolButton3", "disabled");
            onSwitches[2]=0;
        }
        Switch lolSwitch4 = (Switch) findViewById(R.id.LoLswitch4);
        if(lolSwitch4.isChecked())
        {
            intent.putExtra("lolButton4", "enabled");
            onSwitches[3]=1;
        } else {
            intent.putExtra("lolButton4", "disabled");
            onSwitches[3]=0;
        }

        Switch hsSwitch1 = (Switch) findViewById(R.id.HSswitch1);
        if(hsSwitch1.isChecked())
        {
            intent.putExtra("hsButton1", "enabled");
            onSwitches[4]=1;
        } else {
            intent.putExtra("hsButton1", "disabled");
            onSwitches[4]=0;
        }

        Switch hsSwitch2 = (Switch) findViewById(R.id.HSswitch2);
        if(hsSwitch2.isChecked())
        {
            intent.putExtra("hsButton2", "enabled");
            onSwitches[5]=1;
        } else {
            intent.putExtra("hsButton2", "disabled");
            onSwitches[5]=0;
        }

        Switch hsSwitch3 = (Switch) findViewById(R.id.HSswitch3);
        if(hsSwitch3.isChecked())
        {
            intent.putExtra("hsButton3", "enabled");
            onSwitches[6]=1;
        } else {
            intent.putExtra("hsButton3", "disabled");
            onSwitches[6]=0;
        }

        startActivity(intent);
    }




}
