package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Amount_momey extends Activity implements View.OnClickListener {
    TextView am,mail;
    DBhelper DBn;
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.amount_screen);
        am=findViewById(R.id.amo_t);
        mail=findViewById(R.id.mail_show);
        DBn=new DBhelper(this);
        am.setText("$99900");
        Intent intent=getIntent();
        String mname=intent.getStringExtra(signScreen.u_mail);

        mname+="@bank.com";
        mail.setText(mname);

        /*Cursor c=DBn.getamount(mname);

        StringBuilder sb=new StringBuilder();
        while(c.moveToNext()){
            sb.append("$"+c.getInt(4));
            */




    }
    @Override
    public void onClick(View v) {

    }


}
