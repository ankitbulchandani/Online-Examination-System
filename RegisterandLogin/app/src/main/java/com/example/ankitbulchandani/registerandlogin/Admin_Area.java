package com.example.ankitbulchandani.registerandlogin;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Area extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor c;
    ContentValues cv;
    //   AdminDatabase myDb;
    EditText editquestion, editopt1, editopt2, editopt3, editopt4, editcorrectans, editid;
    Button btnAddData, btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin__area);
        db = openOrCreateDatabase("questions_info", MODE_PRIVATE, null);
        db.execSQL("create table IF NOT EXISTS Area(Questions varchar(100) PRIMARY KEY,"
                + "Option_1 varchar(50),"
                + "Option_2 varchar(50),"
                + "Option_3 varchar(50),"
                + "Option_4  varchar(50),"
                + "Correct_ans varchar(50))");

        //    myDb = new AdminDatabase(this);
        editquestion = (EditText) findViewById(R.id.questions_editText);//questions
        editopt1 = (EditText) findViewById(R.id.Option1_editText);//opt 1
        editopt2 = (EditText) findViewById(R.id.Option2_editText);//opt 2
        editopt3 = (EditText) findViewById(R.id.Option3_editText);//opt 3
        editopt4 = (EditText) findViewById(R.id.Option4_editText);//opt 4
        editcorrectans = (EditText) findViewById(R.id.Correct_Ans_editText);//ans
        editid = (EditText) findViewById(R.id.id_editText);
        btnAddData = (Button) findViewById(R.id.add_data);
        btnDelete = (Button) findViewById(R.id.delete_data);
        btnUpdate = (Button) findViewById(R.id.update_data);
        btnViewAll = (Button) findViewById(R.id.view_data);


        AddDataArea();
    }
    public void AddDataArea() {


        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String Eques, Eopt1, Eopt2, Eopt3, Eopt4, Ecorrans;
                        boolean check = true;
                        Eques = editquestion.getText().toString();
                        Eopt1 = editopt1.getText().toString();
                        Eopt2 = editopt2.getText().toString();
                        Eopt3 = editopt3.getText().toString();
                        Eopt4 = editopt4.getText().toString();
                        Ecorrans = editcorrectans.getText().toString();

                        if (Eques.equals("") || Eopt1.equals("") || Eopt2.equals("") || Eopt3.equals("") || Eopt4.equals("") || Ecorrans.equals("")) {
                            check = false;
                            Snackbar.make(v, "Please!! Enter all the options", Snackbar.LENGTH_LONG).show();
                        }
                        if (check) {
                            ContentValues cv = new ContentValues();
                            cv.put("Questions", Eques);
                            cv.put("Option_1", Eopt1);
                            cv.put("Option_2", Eopt2);
                            cv.put("Option_3", Eopt3);
                            cv.put("Option_4", Eopt4);
                            cv.put("Correct_ans", Ecorrans);

                            db.insert("Area", null, cv);
                            Snackbar.make(v, "Question Added!!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();


                        }
                    }
                }
        );
    }
}
