package com.example.ankitbulchandani.registerandlogin;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpadateDatabase extends AppCompatActivity {


    SQLiteDatabase db;
    Cursor c;
    ContentValues cv;
    //   AdminDatabase myDb;
    EditText editquestion, editopt1, editopt2, editopt3, editopt4, editcorrectans, editid;
    Button btnAddData, btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upadate_database);
        db = openOrCreateDatabase("questions_info", MODE_PRIVATE, null);
        db.execSQL("create table IF NOT EXISTS Dealer(Questions varchar(100) PRIMARY KEY,"
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


        AddData();
//        viewAll();
//        UpdateData();
//        deleteData();


    }

//    public void deleteData()
//    {
//        btnDelete.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String id;
//                        id = editid.getText().toString();
//                        Integer deletedRows=myDb.deleteData(editid.getText().toString());
//                        if(id.equals(""))
//                            Snackbar.make(v, "Please Enter id to Delete", Snackbar.LENGTH_LONG).show();
//                        else
//                        if(deletedRows > 0)
//                            Snackbar.make(v, "Data Not Deleted", Snackbar.LENGTH_LONG).show();
//
//                            //     Toast.makeText(UpadateDatabase.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
//                        else
//
//                            //Toast.makeText(UpadateDatabase.this, "Data  Deleted", Toast.LENGTH_LONG).show();
//                            Snackbar.make(v, "Data  Deleted", Snackbar.LENGTH_LONG).show();
//
//
//
//                    }
//                }
//        );
//    }
//

//    public void UpdateData()
//    {
//        btnUpdate.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdate = myDb.updateData(editid.getText().toString(), editquestion.getText().toString(),
//                                editopt1.getText().toString(), editopt2.getText().toString(), editopt3.getText().toString(), editopt4.getText().toString()
//                                , editcorrectans.getText().toString());
//                        String id;
//                        id = editid.getText().toString();
//                        if(id.equals(""))
//                            Snackbar.make(v, "Please Enter id to Update", Snackbar.LENGTH_LONG).show();
//                        else
//                        if(isUpdate == true)
//                            Snackbar.make(v, "Data Updated", Snackbar.LENGTH_LONG).show();
//
//                       // Toast.makeText(UpadateDatabase.this, "Data Updated", Toast.LENGTH_LONG).show();
//                        else
//                            Snackbar.make(v, "Error Occured While Updating!!!", Snackbar.LENGTH_LONG).show();
//
//                       // Toast.makeText(UpadateDatabase.this, "Error Occured", Toast.LENGTH_LONG).show();
//
//
//
//                    }
//                }
//        );
//    }

    public void AddData() {


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

                            db.insert("Dealer", null, cv);
                            Snackbar.make(v, "Question Added!!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();


                        }
                    }
                }
        );
    }
}
                        //   Toast.makeText(UpadateDatabase.this, "Please!! Enter all the options", Toast.LENGTH_LONG).show();

                    //}
//                        else {
//
//    boolean isInserted = myDb.insertData(editquestion.getText().toString(),
//            editopt1.getText().toString(), editopt2.getText().toString(), editopt3.getText().toString(), editopt4.getText().toString()
//            , editcorrectans.getText().toString());
//    if (isInserted == true)
//
//        Snackbar.make(v, "Data Added Successfully", Snackbar.LENGTH_LONG).show();
//
//
//        //   Toast.makeText(UpadateDatabase.this, "Data Added Successfully", Toast.LENGTH_LONG).show();
//
//    else
//        Snackbar.make(v, "Enter all the options", Snackbar.LENGTH_LONG).show();
//
//   // Toast.makeText(UpadateDatabase.this, "Enter all the options", Toast.LENGTH_LONG).show();
//}
//                    }
//                }
//        );


//    public void viewAll(){
//
//        btnViewAll.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = myDb.getAllData();
//                        if (res.getCount() == 0) {
//                            //show message
//                            showMessage("Error","No Data found");
//                            return;
//                        }
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext()) {
//                            buffer.append("ID :" + res.getString(0)+"\n");
//                            buffer.append("Question :" + res.getString(1)+"\n");
//                            buffer.append("Option1 :" + res.getString(2)+"\n");
//                            buffer.append("Option2 :" + res.getString(3)+"\n\n");
//                            buffer.append("Option3 :" + res.getString(4)+"\n\n");
//                            buffer.append("Option4 :" + res.getString(5)+"\n\n");
//                            buffer.append("Correct_answer :" + res.getString(6)+"\n\n");
//
//
//
//
//
//
//                        }
//                        //show all data
//                        showMessage("Data",buffer.toString());
//                    }
//                }
//        );
//    }

//
//
//    public void showMessage(String title , String message){
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.show();
//    }

