package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendMoney extends Activity implements View.OnClickListener {
    Button Send_button,can_button;
   public static final String nm="com.example.application.example.nm";
    EditText Et,Sto;
    int money=1000000;
    TextView te;
    DBhelper DBn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money);
        Send_button=findViewById(R.id.SB);
        can_button=findViewById(R.id.canvS);
        te=findViewById(R.id.amo_t);
        Send_button.setOnClickListener(this);
        can_button.setOnClickListener(this);
        Et=findViewById(R.id.senT);
        Sto=findViewById(R.id.sentAco);
        DBn =new DBhelper(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SB:
                int inputmoney=Integer.parseInt(Et.getText().toString());
                String inputreciever=Sto.getText().toString();
                Boolean founduser=DBn.checkuserfound(inputreciever);

                if(inputmoney<money){
                    if(founduser){
                    money=money-inputmoney;
                    Toast.makeText(this,"Success!",Toast.LENGTH_LONG).show();
                    Boolean b=DBn.updateamount(inputreciever,money);
                    if(b){

                        Toast.makeText(this,"Success!",Toast.LENGTH_LONG).show();
                        Sto.setError("User  found");
                    }

                    }
                    else
                        Sto.setError("User Not found");
                }
                else{
                    Toast.makeText(this,"Failed..",Toast.LENGTH_LONG).show();
                    Et.setError("cannot send");
                }

                break;
            case R.id.canvS:
                Et.setText("");
                Sto.setText("");
                break;
        }

    }
}
