package com.example.suraj.spiderappdevtask1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secActivity extends AppCompatActivity {

    CharSequence c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            c = extras.getString("data");


            TextView t = (TextView) findViewById(R.id.textView);
            t.setText(c);
        }
    }

}
