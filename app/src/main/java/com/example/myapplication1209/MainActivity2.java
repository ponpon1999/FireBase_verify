package com.example.myapplication1209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    Button Button3;
    TextView TextView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button3 = (Button)findViewById(R.id.Button3);
        TextView5 = (TextView)findViewById(R.id.TextView5);

        Intent intent=getIntent();
        String name=intent.getStringExtra("email");
        TextView5.setText("Hello,"+name);

        Button3.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                                               Intent intent=new Intent();
                                                               intent.setClass(MainActivity2.this,MainActivity3.class);
                                                               intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                                               startActivity(intent);
                                       }
        }
        );
    }
}