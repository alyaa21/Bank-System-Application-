package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity implements View.OnClickListener {
 Button nb;
 int error=0;
 public static final String first="com.example.application.example.first";
 public static final String last="com.example.application.example.last";
 public static final String u_name="com.example.application.example.u_name";
 public static final String ph="com.example.application.example.ph";
 public static final String n_id="com.example.application.example.n_id";


 EditText f_name,l_name,e_mail,p_hone,na_id;
 DBhelper DBn;

  @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        nb=findViewById(R.id.Nex_Bu);
        nb.setOnClickListener(this);
        f_name=findViewById(R.id.first_name);
        l_name=findViewById(R.id.last_name);
        e_mail=findViewById(R.id.email);
        p_hone=findViewById(R.id.phone);
        na_id=findViewById(R.id.n_id);
       DBn=new DBhelper(this);

    }
    @Override
    public void onClick(View v) {
             switch(v.getId()) {
                 case R.id.Nex_Bu:
                     String fname=f_name.getText().toString();
                     String lname=l_name.getText().toString();
                     String phone=p_hone.getText().toString();
                     String nid=na_id.getText().toString();
                     String user_mail = e_mail.getText().toString();
                     Boolean checkusername = DBn.checkuserfound(user_mail);
                     if (f_name.length() == 0) {
                         f_name.setError("");
                         error = 1;
                     }
                     else
                         error=0;
                     if (l_name.length() == 0) {
                         l_name.setError("");
                         error = 1;
                     }
                     else
                         error=0;
                     if (p_hone.length() == 0) {
                         p_hone.setError("");
                         error = 1;
                     }
                     else
                         error=0;
                     if (e_mail.length() == 0 && checkusername) {
                         e_mail.setError("set anthor email");
                         error = 1;
                     }
                     else
                         error=0;
                     if (na_id.length() == 0) {
                         na_id.setError("");
                         error = 1;
                     }
                     else
                         error=0;

                     if (error == 0) {
                             Intent myInt = new Intent(this, Signup2.class);
                             myInt.putExtra(first,fname);
                             myInt.putExtra(last,lname);
                             myInt.putExtra(u_name,user_mail);
                             myInt.putExtra(ph,phone);
                             myInt.putExtra(n_id,nid);
                             startActivity(myInt);
                         break;
                     }

             }
   }
}
