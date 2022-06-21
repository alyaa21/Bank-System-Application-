package com.example.bank_sys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    Button sign_i,sign_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign_i=findViewById(R.id.sign_in);
        sign_i.setOnClickListener(this);


        sign_u=findViewById(R.id.sign_up);
        sign_u.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sign_in:
                Intent myInt=new Intent(this , Second.class);
                startActivity(myInt);
                break;
            case R.id.sign_up:
                Intent myInt2=new Intent(this , Signup.class);
                startActivity(myInt2);
                break;
        }//end switch()
    }//end onClick()
}