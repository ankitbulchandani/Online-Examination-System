package com.example.ankitbulchandani.registerandlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmode);
    }


    public void OntestAge(View v)
    {
        Intent i = new Intent(this,Test_Ages.class);
        startActivity(i);

    }

}
