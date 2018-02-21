package com.example.ankitbulchandani.registerandlogin;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
Button adminloginbtn;
    EditText admin_username,admin_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        adminloginbtn=(Button)findViewById(R.id.adminloginbutton);
        admin_username=(EditText)findViewById(R.id.admin_nameEditText1);
        admin_password=(EditText)findViewById(R.id.admin_passwordEditText1);
    }
    public void onAdminLoginClick(View v)
    {
        boolean flag =false;
        if(admin_username.getText().toString().equals("ADMIN") && admin_password.getText().toString().equals("PASSWORD"))
        {
            flag =true;
        }
        else
            Snackbar.make(v, "Enter valid admin details", Snackbar.LENGTH_LONG).show();

        // Toast.makeText(AdminLogin.this, "Enter valid admin details", Toast.LENGTH_LONG).show();
if(flag) {
    if (v.getId() == R.id.adminloginbutton) {
        Intent i = new Intent(this, Admin_Select_module.class);
        startActivity(i);
    }
}
    }
}
