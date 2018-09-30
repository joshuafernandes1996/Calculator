package com.example.josh.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class developerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_developer_info);



        TextView info=findViewById(R.id.info);
        info.setText("Assignment: #\nApp: Calculator Material Design\nDev: Joshua Fernandes\nDate Modified: 8/21/2018\nAdditonal Info: " +
                "Used Adobe Illustrator for the Logo, \nDrawable XML for gradient background, \nToast For Alerts, \n Splash Screen" +
                "\nNavigation Drawer\n OverFlow Menu,\nAction Bar with Action Button,\n Intents\nRipple Effects with Elevation Shadow \n Card View");
    }

}
