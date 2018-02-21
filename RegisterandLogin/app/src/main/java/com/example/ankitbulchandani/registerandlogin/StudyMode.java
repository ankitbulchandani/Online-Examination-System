package com.example.ankitbulchandani.registerandlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudyMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studymode);
    }

    public void onAgesClick(View v)
    {
        if(v.getId()==R.id.agesbutton)
        {
            Intent i = new Intent(this,Ages.class);
            startActivity(i);
        }
    }
    public void onAverageClick(View v)
    {
        if(v.getId()==R.id.average_button)
        {
            Intent i = new Intent(this,Average.class);
            startActivity(i);
        }
    }
    public void onPercentageClick(View v)
    {
        if(v.getId()==R.id.percentage_button)
        {
            Intent i = new Intent(this,Percentage.class);
            startActivity(i);
        }
    }
    public void onAreaClick(View v)
    {
        if(v.getId()==R.id.area_button)
        {
            Intent i = new Intent(this,Area_and_Volume.class);
            startActivity(i);
        }
    }


    public void onLogClick(View v)
    {
        if(v.getId()==R.id.log_button)
        {
            Intent i = new Intent(this,Logarithm.class);
            startActivity(i);
        }
    }

    public void onClockClick(View v)
    {
        if(v.getId()==R.id.clock_button)
        {
            Intent i = new Intent(this,Clock.class);
            startActivity(i);
        }
    }


    public void onProfitClick(View v)
    {
        if(v.getId()==R.id.profit_button)
        {
            Intent i = new Intent(this,Profit_and_lost.class);
            startActivity(i);
        }
    }

    public void onRatioClick(View v)
    {
        if(v.getId()==R.id.ratio_button)
        {
            Intent i = new Intent(this,Ratio_and_Propotion.class);
            startActivity(i);
        }
    }

    public void onSqrootClick(View v)
    {
        if(v.getId()==R.id.sqrootbutton)
        {
            Intent i = new Intent(this,Square_root.class);
            startActivity(i);
        }
    }
}
