package com.example.ankitbulchandani.registerandlogin;


/*import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class Ages extends FragmentActivity {
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ages);
        viewpager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter padapter = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(padapter);
    }


}*/

//
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.provider.MediaStore;
//import android.support.design.widget.Snackbar;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.RadioButton;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class Ages extends AppCompatActivity {
//    SQLiteDatabase db;
//    Cursor c;
//    ViewPager viewpager;
//
//    RadioButton one,two,three,four;
//    TextView questions;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.ages);
//
//       }
//
//
//
//
//
//}

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import java.util.concurrent.TimeUnit;

public class Profit_and_lost extends AppCompatActivity {
    TextView final_result,ques,op1,op2,op3,op4,ans,timertextView;
    Button next;
    Cursor cur;
    int score;
    SQLiteDatabase db;
    int QUESTION_COUNT=0;
    String answer_entered[] = new String [20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profit_and_lost);
        final_result =(TextView)
                findViewById(R.id.result);
        final_result.setEnabled(false);
        db=openOrCreateDatabase("questions_info",MODE_PRIVATE,null);
        cur = db.query("Profit", null, null, null, null, null, null);
        next =(Button)findViewById(R.id.next_button);
        //cur = query();
        ques = (TextView)findViewById(R.id.quesText);
        op1 = (TextView)findViewById(R.id.ans1);
        op2 = (TextView)findViewById(R.id.ans2);
        op3 = (TextView)findViewById(R.id.ans3);
        op4 = (TextView)findViewById(R.id.ans4);
        ans = (TextView)findViewById(R.id.result);

        QUESTION_COUNT++;
        cur.moveToNext();
        ques.setText(cur.getString(cur.getColumnIndex("Questions")));
        op1.setText(cur.getString(cur.getColumnIndex("Option_1")));
        op2.setText(cur.getString(cur.getColumnIndex("Option_2")));
        op3.setText(cur.getString(cur.getColumnIndex("Option_3")));
        op4.setText(cur.getString(cur.getColumnIndex("Option_4")));
        timertextView=(TextView)findViewById(R.id.textViewTime);
        timertextView.setText("00:05:00");
        //final CounterClass timer = new CounterClass(300000, 1000);

        /*next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }



    public void Next(View v)
    {

        op1.setEnabled(true);
        op2.setEnabled(true);
        op3.setEnabled(true);
        op4.setEnabled(true);

    // Toast.makeText(this, "Answer: " + answer_entered[QUESTION_COUNT], Toast.LENGTH_LONG).show();
        final CounterClass timer = new CounterClass(300000, 1000);
        timer.start();
        if(QUESTION_COUNT==3){
            op1.setEnabled(false);
            op2.setEnabled(false);
            op3.setEnabled(false);
            op4.setEnabled(false);
            Toast.makeText(this, "Score: " +score, Toast.LENGTH_LONG).show();}
        else {
            //String qt,op1,op2,op3,op4;
            QUESTION_COUNT++;
            cur.moveToNext();
            ques.setText(cur.getString(cur.getColumnIndex("Questions")));
            op1.setText(cur.getString(cur.getColumnIndex("Option_1")));
            op2.setText(cur.getString(cur.getColumnIndex("Option_2")));
            op3.setText(cur.getString(cur.getColumnIndex("Option_3")));
            op4.setText(cur.getString(cur.getColumnIndex("Option_4")));
            //ans.setText(cur.getString(cur.getColumnIndex("CORRECT_ANS")));
            //Intent i = new Intent(this, Area_and_Volume.class);
        }
    }

    public class CounterClass extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            timertextView.setText(hms);


        }

        @Override
        public void onFinish() {

            timertextView.setText("Test Completed");
        }
    }

    public void SelectFruit(View v)
    {

        op1.setEnabled(false);
        op2.setEnabled(false);
        op3.setEnabled(false);
        op4.setEnabled(false);
        boolean checked = ((RadioButton) v).isChecked();
        //answer_entered[QUESTION_COUNT] = ((RadioButton) v).getText().toString();

        String check=((RadioButton) v).getText().toString();//to ask

        switch (v.getId())
        {

            case R.id.ans1:
                if(checked) {
                    // answer_entered[QUESTION_COUNT] = ((RadioButton) v).getText().toString();

                    // final_result.setText("You Select Apple");
                    check=((RadioButton) v).getText().toString();
                    if(check.equals(cur.getString(cur.getColumnIndex("Correct_ans")))){ final_result.setText("Correct Answer");
                        score++;
                    }//to Ask
                    else
                    {
                        final_result.setText("Wrong Answer");//to Ask

                    }
                    final_result.setEnabled(true);
                }
                else {

                    final_result.setEnabled(false);
                }
                break;


            case R.id.ans2:
                if(checked) {
                    answer_entered[QUESTION_COUNT] = ((RadioButton) v).getText().toString();
//                    final_result.setText("You Select Mango");
                    check=((RadioButton) v).getText().toString();
                    if(check.equals(cur.getString(cur.getColumnIndex("Correct_ans")))){ final_result.setText("Correct Answer");
                        score++;
                    }//to Ask
                    else
                    {
                        final_result.setText("Wrong Answer");//to Ask

                    }

                    final_result.setEnabled(true);
                }
                else {

                    final_result.setEnabled(false);
                }
                break;

            case R.id.ans3:
                if(checked) {
                    answer_entered[QUESTION_COUNT] = ((RadioButton) v).getText().toString();
                    // final_result.setText("You Select Orange");
                    check=((RadioButton) v).getText().toString();
                    if(check.equals(cur.getString(cur.getColumnIndex("Correct_ans")))){ final_result.setText("Correct Answer");
                        score++;
                    }//to Ask
                    else
                    {
                        final_result.setText("Wrong Answer");//to Ask

                    }

                    final_result.setEnabled(true);
                }
                else {

                    final_result.setEnabled(false);
                }
                break;

            case R.id.ans4:
                if(checked) {
                    answer_entered[QUESTION_COUNT] = ((RadioButton) v).getText().toString();
                    //  final_result.setText("You Select Banana");
                    check=((RadioButton) v).getText().toString();
                    if(check.equals(cur.getString(cur.getColumnIndex("Correct_ans")))) {
                        final_result.setText("Correct Answer");//to Ask
                        score++;
                    }
                    else
                    {
                        final_result.setText("Wrong Answer");//to Ask

                    }
                    final_result.setEnabled(true);
                }
                else {

                    final_result.setEnabled(false);
                }
                break;


        }


    }

    public void getScore(){
        cur = db.query("Profit",new String[]{"Correct_ans"}, null,null,null,null,null);  //ok
        int i=0;
        //while(cur.moveToNext()&& i<3){
        while(cur.moveToNext()){
            if(answer_entered[i].equals(cur.getString(cur.getColumnIndex("Correct_ans")))) {
                //ab kar try
                score++;
            }
            i++;
        }
        Toast.makeText(Profit_and_lost.this,"Your score is " +score+" points" , Toast.LENGTH_LONG).show();


    }



}


