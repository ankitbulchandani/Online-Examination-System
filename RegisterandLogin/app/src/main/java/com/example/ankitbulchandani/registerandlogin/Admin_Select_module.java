package com.example.ankitbulchandani.registerandlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Select_module extends AppCompatActivity {
Button ages,average,percentage,area,logarithm,clock,profit,ratio,squareroot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin__select_module);


        ages=(Button)findViewById(R.id.admin_ages);
        average=(Button)findViewById(R.id.admin_average);
        percentage=(Button)findViewById(R.id.admin_percentage);
        area=(Button)findViewById(R.id.admin_area);
        logarithm=(Button)findViewById(R.id.admin_logarithms);
        clock=(Button)findViewById(R.id.admin_clock);
        profit=(Button)findViewById(R.id.admin_profit);
        ratio=(Button)findViewById(R.id.admin_ratio);
        squareroot=(Button)findViewById(R.id.admin_squareroot);

    }

    public void ages_admin(View v)
    {
        Intent i = new Intent(this,UpadateDatabase.class);
        startActivity(i);
    }

    public void average_admin(View v)
    {
        Intent i = new Intent(this,Admin_Average.class);
        startActivity(i);
    }

    public void percentage_admin(View v)
    {
        Intent i = new Intent(this,Admin_Percentage.class);
        startActivity(i);
    }

    public void area_admin(View v)
    {
        Intent i = new Intent(this,Admin_Area.class);
        startActivity(i);
    }

    public void logarithm_admin(View v)
    {
        Intent i = new Intent(this,Admin_Logarithms.class);
        startActivity(i);
    }


    public void clock_admin(View v)
    {
        Intent i = new Intent(this,Admin_Clock.class);
        startActivity(i);
    }

    public void profit_admin(View v)
    {
        Intent i = new Intent(this,Admin_Profit.class);
        startActivity(i);
    }

    public void ratio_admin(View v)
    {
        Intent i = new Intent(this,Admin_Ratio.class);
        startActivity(i);
    }

    public void squareroot_admin(View v)
    {
        Intent i = new Intent(this,Admin_Squareroot.class);
        startActivity(i);
    }
}

