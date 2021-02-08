package com.rtu.smartkids;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText t4 = (EditText) findViewById(R.id.edittext_username);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "GoodUnicornRegular-Rxev.ttf");
        t4.setTypeface(custom_font);

        EditText t5 = (EditText) findViewById(R.id.edittext_password);
        t5.setTypeface(custom_font);

        EditText t6 = (EditText) findViewById(R.id.edittext_cnf_password);
        t6.setTypeface(custom_font);

        Button b4 = (Button) findViewById(R.id.button_register);
        b4.setTypeface(custom_font);

        TextView v6 = (TextView) findViewById(R.id.al_reg);
        v6.setTypeface(custom_font);

        TextView v7 = (TextView) findViewById(R.id.textview_login);
        v7.setTypeface(custom_font);



        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if (user.length() <= 4) {
                    Toast.makeText(RegisterActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }

//                else {pwd.length() >= 6 && user.length() != 0



                else if (pwd.equals(cnf_pwd)&& pwd.length() >= 6) {
                    long val = db.addUser(user, pwd);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }

                } else if (pwd.length() < 6){
                    Toast.makeText(RegisterActivity.this, "Password should contain atleast six characters", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }




//            }
            }
        });
    }
}