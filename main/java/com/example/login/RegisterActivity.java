package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText textuser,textpass,textconfirm;
    Button buttonlogin;
    TextView textViewlog;
    TextView textnotconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DatabaseHelper(this);
        textuser = (EditText) findViewById(R.id.textu);
        textpass = (EditText) findViewById(R.id.textp);
        buttonlogin = (Button) findViewById(R.id.buttonreg);
        textViewlog = (TextView) findViewById(R.id.textlog);
        textconfirm=(EditText)findViewById(R.id.textpc);
        textnotconfirm=(TextView) findViewById(R.id.notComfirm);

        textViewlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = textuser.getText().toString().trim();
                String pwd = textpass.getText().toString().trim();
                String cnf_pwd = textconfirm.getText().toString().trim();

                if(textuser.getText().toString().trim().isEmpty() ||
                        textpass.getText().toString().trim().isEmpty() || textconfirm.getText().toString().trim().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Oops:Make Sure You entered both Username and Password", Toast.LENGTH_SHORT).show();
                }
                    else

                if (pwd.equals(cnf_pwd)) {

                    long val = db.addUser(user, pwd);
                    if (val > 0) {

                        Toast.makeText(RegisterActivity.this, "you have registered", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(loginIntent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Incorrect Password ", Toast.LENGTH_SHORT).show();
                    }

                }
                else {

                    textnotconfirm.setVisibility(View.VISIBLE);

                    Toast.makeText(RegisterActivity.this, "Password is not matched", Toast.LENGTH_SHORT).show();

                    }



            }



        });
    }}
