package com.example.bank_sys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoanScreen2 extends Activity implements View.OnClickListener {
    EditText e1;
    DBhelper DBn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan2);
        e1=findViewById(R.id.et1);
        DBn=new DBhelper(this);
        String account =e1.getText().toString();
        Boolean founduser=DBn.checkuserfound(account);
        if(founduser){
            Toast.makeText(this,"Success,your request send",Toast.LENGTH_LONG).show();
        }
        else{
            e1.setError("uncorrect id");
        }

    }
    @Override
    public void onClick(View v) {

    }
}
