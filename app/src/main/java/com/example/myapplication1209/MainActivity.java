package com.example.myapplication1209;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Activity context=this;
    Button Button1,Button2;
    TextView TextView1,TextView2,TextView3,TextView4;
    EditText PlainText1,PlainText2,PlainText3,PlainText4;
    String email;
    FirebaseAuth mAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button1 = (Button)findViewById(R.id.Button1);
        Button2 = (Button)findViewById(R.id.Button2);
        TextView1 = (TextView)findViewById(R.id.TextView1);
        TextView2 = (TextView)findViewById(R.id.TextView2);
        TextView3 = (TextView)findViewById(R.id.TextView3);
        TextView4 = (TextView)findViewById(R.id.TextView4);
        PlainText1 = (EditText)findViewById(R.id.PlainText1);
        PlainText2 = (EditText)findViewById(R.id.PlainText2);
        PlainText3 = (EditText)findViewById(R.id.PlainText3);
        PlainText4 = (EditText)findViewById(R.id.PlainText4);

        mAuth = FirebaseAuth.getInstance();

        Button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           mAuth.createUserWithEmailAndPassword(PlainText1.getText().toString(),PlainText2.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>()
                                                   {
                                                       @Override
                                                       public void onComplete(@NonNull Task<AuthResult> task) {
                                                           if (task.isSuccessful()) {
                                                               FirebaseUser user = mAuth.getCurrentUser();
                                                               TextView2.setText(user.getEmail()+"registration success");
                                                           }
                                                           else {
                                                               TextView2.setText("registration failed");
                                                           }
                                                       }
                                                   }
                                           );
                                       }
                                   }
        );

        Button2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           mAuth.signInWithEmailAndPassword(PlainText3.getText().toString(),PlainText4.getText().toString()).addOnCompleteListener(context, new OnCompleteListener<AuthResult>()
                                                   {
                                                       @Override
                                                       public void onComplete(@NonNull Task<AuthResult> task) {
                                                           if (task.isSuccessful()) {
                                                               FirebaseUser user = mAuth.getCurrentUser();
                                                              // TextView4.setText(user.getEmail()+"登入成功");
                                                               Intent intent=new Intent();
                                                               intent.setClass(MainActivity.this,MainActivity2.class);
                                                               intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                                               intent.putExtra("email",user.getEmail());
                                                               startActivity(intent);
                                                           }
                                                           else {
                                                               TextView4.setText("登入失敗");
                                                           }
                                                       }
                                                   }
                                           );
                                       }
                                   }
        );

    }
}