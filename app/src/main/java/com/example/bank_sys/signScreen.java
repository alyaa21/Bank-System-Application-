package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class signScreen extends Activity implements View.OnClickListener {
    public static final String u_mail="com.example.application.example.u_mail";

    ImageButton monB,senB,reqB;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sign_screen1);
    monB=findViewById(R.id.check_money);
    monB.setOnClickListener(this);
    senB=findViewById(R.id.send_money);
    senB.setOnClickListener(this);
    reqB=findViewById(R.id.RequestLoanSc);
    reqB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_money:
                String account;
                Intent intent=getIntent();
                account=intent.getStringExtra(Second.usermail);
                Intent myInt=new Intent(this , Amount_momey.class);
                myInt.putExtra(u_mail,account);
                startActivity(myInt);
                break;
            case R.id.send_money:
                Intent myInt2=new Intent(this , SendMoney.class);
                startActivity(myInt2);
                break;
            case R.id.RequestLoanSc:
                Intent myInt3=new Intent(this , LoanScreen1.class);
                startActivity(myInt3);
                break;



        }

    }
}
