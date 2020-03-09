package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textuser,textpass;
    Button buttonlogin;
    TextView textViewreg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ProgressBar progressbar=(ProgressBar) findViewById(R.id.progress_circular);
        db=new DatabaseHelper(this);
        textuser=(EditText) findViewById(R.id.textu);

     //   Drawable img = textuser.getContext().getResources().getDrawable( R.drawable.logo );
       // img.setBounds( 0, 0, 60, 60 );

//        textuser.setCompoundDrawablesWithIntrinsicBounds( img, null, null, null);

        textpass=(EditText) findViewById(R.id.textp);
        buttonlogin=(Button) findViewById(R.id.buttonl);
        textViewreg=(TextView) findViewById(R.id.textreg);

        textViewreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);


            }
        });
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=textuser.getText().toString().trim();
                String pwd=textpass.getText().toString().trim();
                Boolean res=db.checkuser(user,pwd);



                if(textuser.getText().toString().trim().isEmpty() ||
                        textpass.getText().toString().trim().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Oops:Make Sure You entered both Username and Password", Toast.LENGTH_SHORT).show();
                }

                else


                if(res==true)
                {
                    Toast.makeText(MainActivity.this,"Successfully login",Toast.LENGTH_SHORT).show();
                    progressbar.setVisibility(View.VISIBLE);
                    Intent intent=new Intent(MainActivity.this,homeActivity.class);
                    startActivity(intent);

                }


                else {
                    Toast.makeText(MainActivity.this, "login error", Toast.LENGTH_SHORT).show();


                    }}

        });


    }
}
