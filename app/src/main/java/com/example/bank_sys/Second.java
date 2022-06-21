package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.Statement;

public class Second extends Activity implements View.OnClickListener {
    EditText user,pas;
    Button ok,can;
    TextView fo_pass;
    public static final String usermail="com.example.application.example.usermail";
    DBhelper DBn;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        user=findViewById(R.id.F1);
        pas=findViewById(R.id.F2);
        ok=findViewById(R.id.B1);
        fo_pass=findViewById(R.id.forg_pass);
        fo_pass.setOnClickListener(this);
        ok.setOnClickListener(this);
        can=findViewById(R.id.B2);
        can.setOnClickListener(this);


        DBn=new DBhelper(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.B1:
                String inputUser=user.getText().toString();
                String inputPas=pas.getText().toString();
                Boolean checkuser=DBn.checkuse(inputUser,inputPas);
              Boolean founduser=DBn.checkuserfound(inputUser);
              if(founduser){
                  if(checkuser==true){
                        Toast.makeText(this,"Success!",Toast.LENGTH_LONG).show();
                        Intent myInt=new Intent(Second.this , signScreen.class);
                        myInt.putExtra(usermail,user.getText().toString());
                        startActivity(myInt);
                    }//end if
                    else{
                        pas.setError("uncorrect Password");
                        Toast.makeText(this,"Failed..",Toast.LENGTH_LONG).show();
                    }
              }
              else{
                  user.setError("User Not exists ");
                  Toast.makeText(this,"Failed..",Toast.LENGTH_LONG).show();
              }

                break;
            case R.id.forg_pass:
                Intent myInt=new Intent(this , ForScreen.class);
                startActivity(myInt);
               break;
            case R.id.B2:
                user.setText("");
                pas.setText("");
                break;
        }//end switch()
    }//end onClick()
}//end class


