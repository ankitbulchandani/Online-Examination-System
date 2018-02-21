package com.example.ankitbulchandani.registerandlogin;





import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db=openOrCreateDatabase("info",MODE_PRIVATE,null);
        e1=(EditText)findViewById(R.id.usernameEditText1);
        e2=(EditText)findViewById(R.id.passwordEditText1);

    }

    public void onRegisterClick1(View v)
    {

        if(v.getId()== R.id.registerbutton1)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivityForResult(i,75);
        }
    }

    public void onAdminClick(View v)
    {
        if(v.getId()== R.id.admin)
        {
            Intent i = new Intent(this,AdminLogin.class);
            startActivityForResult(i,75);
        }

    }

    public void login(View v){

        String username,password;
        username=e1.getText().toString();
        password=e2.getText().toString();

        if(username.equals("")||password.equals(""))
        {
            Snackbar.make(v, "Please Enter all the Details", Snackbar.LENGTH_LONG).show();

            // Toast.makeText(this,"Please Enter all the Details",Toast.LENGTH_LONG).show();

        }
else {
            String args[] = {e1.getText().toString(), e2.getText().toString()};
            c = db.query(false, "Student", null, "USERNAME=? and PASSWORD=?", args, null, null, null, null);

            if (c.moveToNext()) {

                Snackbar.make(v, "LOGIN SUCCESSFULL", Snackbar.LENGTH_LONG).show();

                //  Toast.makeText(this, "LOGIN SUCCESSFULL", Toast.LENGTH_LONG).show();
                Intent in = new Intent(this, Home.class);
                startActivity(in);
            } else
                Snackbar.make(v, "Enter Valid Username & Password", Snackbar.LENGTH_LONG).show();

         //   Toast.makeText(this, "Enter Valid Username & Password", Toast.LENGTH_LONG).show();


        }

    }
}





































































/*import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DatabaseHelper myDb;
Button login;
    //SQLiteDatabase db;
    EditText username,password;
    String USER_NAME,PASSWORDD;
   // Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        myDb = new DatabaseHelper(this);
       // db=openOrCreateDatabase("Students_info2",MODE_PRIVATE,null);//trial
        login = (Button)findViewById(R.id.loginbutton1);
        username =(EditText)findViewById(R.id.usernameEditText1);
        password =(EditText)findViewById(R.id.passwordEditText1);
       // USERNAME = username.getText().toString();
        //PASSWORD = password.getText().toString();

        USER_NAME = username.getText().toString();
        PASSWORDD = password.getText().toString();


    }

    public void onRegisterClick1(View v)
    {

        if(v.getId()== R.id.registerbutton1)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }

   /* public void onClick(View v)
    {
        if(v.getId()==R.id.loginbutton1)
        {
            Intent i = new Intent(this,Home.class);
            startActivity(i);
        }
    }
*/
  //  public void onLoginClick1(View v)
    //{


      //  Toast.makeText(Login.this,USER_NAME, Toast.LENGTH_LONG).show();


        //String args[]={  USERNAME = username.getText().toString(),
        //PASSWORD = password.getText().toString()};

        //c=db.query(false,"Students_table2",null,"USERNAME =? and PASSWORD=?",args,null,null,null,null,null);

       /* if(c.moveToNext())
        {
            Toast.makeText(Login.this, " valid Username and Password", Toast.LENGTH_LONG).show();
            Intent in = new Intent(this,Home.class);
            startActivity(in);
        }
        else
        {
            Toast.makeText(Login.this, "Not  valid Username and Password", Toast.LENGTH_LONG).show();

        }*/

  /*  if(v.getId()==R.id.loginbutton1)
        {
            Intent i = new Intent(this,Home.class);
            startActivity(i);
        }
   /*   Cursor res = myDb.getAllData();
String user = res.getString(res.getColumnIndex("USERNAME"));
String pass = res.getString(res.getColumnIndex("PASSWORD"));


    res.moveToFirst();

        while (res.moveToNext()) {
            if(user.equals(USER_NAME)&& pass.equals(PASSWORDD))
            {
                Toast.makeText(Login.this, " valid Username and Password", Toast.LENGTH_LONG).show();

              onLoginClick1(findViewById(R.id.loginbutton1));
                if(v.getId()== R.id.loginbutton1)
                {
                    Intent i = new Intent(this,Home.class);
                    startActivity(i);
                }


            }
            else
                Toast.makeText(Login.this, "Enter valid Username and Password", Toast.LENGTH_LONG).show();



        }*/

/*
    }

    public void onAdminClick(View v){
        if(v.getId()==R.id.admin)
        {
            Intent i = new Intent(this,AdminLogin.class);
            startActivity(i);
        }
    }


  /*  public void onLoginClick1(View v)
    {
        check();
        if(v.getId()== R.id.loginbutton1)
        {
            Intent i = new Intent(this,Home.class);
            startActivity(i);
        }

    }*/
//}
