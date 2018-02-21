package com.example.ankitbulchandani.registerandlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

        public void onStudyModeClick(View v)
    {
        if(v.getId()==R.id.studymodebutton)
        {
            Intent i = new Intent(this,StudyMode.class);
            startActivity(i);
        }
    }

    public void onTestModeClick(View v)
    {
        if(v.getId()==R.id.testmodebutton )
        {
            Intent i = new Intent(this,TestMode.class);
            startActivity(i);

        }

    }

    public void onChallengeModeClick(View v)
    {
        if(v.getId()==R.id.challengemodebutton)
        {
            Intent i = new Intent(this,ChallengeMode.class);
            startActivity(i);
        }

    }

    public void onHistoryClick(View v)
    {
        if(v.getId()==R.id.historybutton)
        {
            Intent i = new Intent(this,History.class);
                    startActivity(i);
        }

    }
    public void onLogoutClick(View v)
    {
        if(v.getId()==R.id.logout_button)
        {
            Intent i = new Intent(this,Login.class);
            startActivity(i);
        }
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}


