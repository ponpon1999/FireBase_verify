package com.example.myapplication1209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity3 extends AppCompatActivity {
    Button Button4,Button5,Button6;
    TextView TextView6,TextView7;
    EditText PlainText5,PlainText6;

    Activity context=this;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button5 = (Button) findViewById(R.id.Button5);
        Button6 = (Button) findViewById(R.id.Button6);
        TextView6 = (TextView) findViewById(R.id.TextView6);
        PlainText5 = (EditText) findViewById(R.id.PlainText5);
        PlainText6 = (EditText) findViewById(R.id.PlainText6);
        TextView7 = (TextView) findViewById(R.id.TextView7);

        // Button4 = (Button) findViewById(R.id.Button4);


        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        /*驗證gmail改密碼
        Button4.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           showRecoverPasswordDialog();
                                       }
                                   }
        );*/

        //首頁
        Button5.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent();
                                           intent.setClass(MainActivity3.this, MainActivity.class);
                                           intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                           startActivity(intent);
                                       }
                                   }
        );

        //直接更改密碼
        Button6.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if( PlainText5.getText().toString().equals(PlainText6.getText().toString())){
                                               user.updatePassword(PlainText5.getText().toString().trim())
                                                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                  @Override
                                                                                  //顯示更改成功與失敗
                                                                                  public void onComplete(@NonNull Task<Void> task) {
                                                                                      if (task.isSuccessful()) {
                                                                                          Toast.makeText(MainActivity3.this, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                                                                                      } else {
                                                                                          Toast.makeText(MainActivity3.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
                                                                                      }
                                                                                      //自動跳至首頁
                                                                                      Intent intent = new Intent();
                                                                                      intent.setClass(MainActivity3.this, MainActivity.class);
                                                                                      intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                                                                      startActivity(intent);
                                                                                  }
                                                                              }
                                                        );
                                           }
                                           else{
                                               TextView7.setText("Failed to change password");
                                           }
                                       }


        }
        );


    }



/*
    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Change Password");
        LinearLayout linearLayout=new LinearLayout(this);
        final EditText emailet= new EditText(this);

        // write the email using which you registered
        emailet.setText("Email");
        emailet.setMinEms(16);
        emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        linearLayout.addView(emailet);
        linearLayout.setPadding(10,10,10,10);
        builder.setView(linearLayout);

        // Click on Recover and a email will be sent to your registered email id
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=emailet.getText().toString().trim();
                beginRecovery(email);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }


    private void beginRecovery(String email) {
        ProgressDialog loadingBar = new ProgressDialog(this);
        loadingBar.setMessage("Sending Email....");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        // calling sendPasswordResetEmail
        // open your email and write the new
        // password and then you can login
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                loadingBar.dismiss();
                if(task.isSuccessful())
                {
                    // if isSuccessful then done message will be shown
                    // and you can change the password
                    Toast.makeText(MainActivity3.this,"Done sent",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity3.this,"Error Occured",Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingBar.dismiss();
                Toast.makeText(MainActivity3.this,"Error Failed",Toast.LENGTH_LONG).show();
            }
        }
        );
    }*/
}

