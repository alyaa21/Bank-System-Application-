package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoanScreen1 extends Activity implements View.OnClickListener {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan1);
        b1=findViewById(R.id.Next_Loan);
        b1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Next_Loan:
                Intent myInt2=new Intent(this , LoanScreen2.class);
                startActivity(myInt2);

                break;
        }

    }
}
