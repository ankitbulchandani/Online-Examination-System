package com.example.ankitbulchandani.registerandlogin;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    ContentValues cv;
    EditText etName,etLast,etEmail,etUser,etPas,confpas;
    String name,last,email,username,pas,confpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("info", MODE_PRIVATE, null);
        db.execSQL("create table IF NOT EXISTS Student(ID integer PRIMARY KEY,"
                + "FIRSTNAME varchar(100),"
                + "LASTNAME varchar(10),"
                + "EMAIL varchar(50),"
                + "USERNAME varchar(100),"
                + "PASSWORD varchar(50))");
    }

    public void onLoginClick(View v)
    {

        if(v.getId()== R.id.loginbutton)
        {
            Intent i = new Intent(this,Login.class);
            startActivity(i);
        }
    }

    public void add(View v) {
        etName = (EditText) findViewById(R.id.firstnameEditText);
        etLast = (EditText) findViewById(R.id.lastnameEditText);
        etEmail = (EditText) findViewById(R.id.emailEditText);
        etUser = (EditText) findViewById(R.id.usernameEditText);
        etPas = (EditText) findViewById(R.id.passwordEditText);
        confpas = (EditText) findViewById(R.id.confirmpasswordEditText);

        name = etName.getText().toString();
        last = etLast.getText().toString();
        email = etEmail.getText().toString();
        username = etUser.getText().toString();
        pas = etPas.getText().toString();
        confpass = confpas.getText().toString();
        if (name.equals("") || last.equals("") || email.equals("") || pas.equals("") || username.equals("") || confpass.equals("")) {

            Snackbar.make(v, "Please Enter All the Details", Snackbar.LENGTH_LONG).show();

//            Toast.makeText(this, "Please Enter All the Details", Toast.LENGTH_LONG).show();

        } else {

            cv = new ContentValues();
            cv.put("FIRSTNAME", name);
            cv.put("LASTNAME", last);
            cv.put("EMAIL", email);
            cv.put("USERNAME", username);
            cv.put("PASSWORD", pas);
            db.insert("Student", null, cv);

          //  Snackbar.make(v, "Regestered Successfuly", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show();

            Snackbar.make(v, "Registered Successfuly", Snackbar.LENGTH_LONG).show();
            //Toast.makeText(this, "Regestered Successfuly", Toast.LENGTH_LONG).show();
            Intent in = new Intent();
            setResult(75, in);
            finish();
        }
    }


}





















/*import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    EditText editfn,editln,editemail,editusername,editpassword,editconfpassword;
    Button registerbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editfn =(EditText)findViewById(R.id.firstnameEditText);
        editln =(EditText)findViewById(R.id.lastnameEditText);
        editemail =(EditText)findViewById(R.id.emailEditText);
        editusername =(EditText)findViewById(R.id.usernameEditText);
        editpassword =(EditText)findViewById(R.id.passwordEditText);
        editconfpassword=(EditText)findViewById(R.id.confirmpasswordEditText);

        registerbutton =(Button)findViewById(R.id.registerbutton);
        AddData();
    }

    public void AddData(){

        registerbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strfName = editfn.getText().toString();
                        String strlName = editln.getText().toString();
                        String stremail = editemail.getText().toString();
                        String struserName = editusername.getText().toString();
                        String strpassword = editpassword.getText().toString();
                        String strconfpassword =editconfpassword.getText().toString();
                        if(TextUtils.isEmpty(strfName)) {
                            editfn.setError("Please Enter Your Firstname");
                            return;
                        }

                        if(TextUtils.isEmpty(strlName)) {
                            editln.setError(" Lastname");
                            return;
                        }


                        if(TextUtils.isEmpty(stremail)) {
                            editemail.setError("Please Enter Your email");
                            return;
                        }

                        if(TextUtils.isEmpty(struserName)) {
                            editusername.setError("Please Enter Your Username");
                            return;
                        }

                        if(TextUtils.isEmpty(strpassword)) {
                            editpassword.setError("Please Enter Your Password");
                            return;
                        }

                        if(TextUtils.isEmpty(strconfpassword)) {
                            editconfpassword.setError("Please Enter Your Password Again");
                            return;
                        }

/*                            if(editpassword != editconfpassword)
                            {
                                Toast.makeText(MainActivity.this, "Password Missmatch", Toast.LENGTH_LONG).show();
                                return;
                            }

*/

                /*        boolean isInserted = myDb.insertData(editfn.getText().toString(), editln.getText().toString(),
                                editemail.getText().toString(), editusername.getText().toString(),
                                editpassword.getText().toString());

                        if (isInserted == true)
                            Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_LONG).show();
                        else

                            Toast.makeText(MainActivity.this, "NOT Registered", Toast.LENGTH_LONG).show();




                    }
                }
        );
    }


    public void onLoginClick(View v)
    {

        if(v.getId()== R.id.loginbutton)
        {
            Intent i = new Intent(this,Login.class);
            startActivity(i);
        }
    }
}*/
