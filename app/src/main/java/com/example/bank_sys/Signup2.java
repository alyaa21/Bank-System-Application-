package com.example.bank_sys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_sys.databinding.SignScreen1Binding;

public class Signup2 extends Activity implements View.OnClickListener {
    private Button okv,canv;
    private EditText address,pas1,pas2;
    private String pass1,pass2;
    private DBhelper DBn;

    int error=0;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup2_layout);
        okv=findViewById(R.id.okv);
        okv.setOnClickListener(this);
        canv=findViewById(R.id.canv);
        canv.setOnClickListener(this);
        address=findViewById(R.id.add);
        pas1=findViewById(R.id.Vpass1);
        pas2=findViewById(R.id.Vpass2);
        pass1=pas1.getText().toString();
        pass2=pas2.getText().toString();
       DBn=new DBhelper(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.okv:
                if(address.length()==0){
                    address.setError("set address");
                    error=1;
                }
                if(pas1.length()==0){
                    pas1.setError("set password");
                    error=1;
                }
                if(pas2.length()==0){
                    pas2.setError("set password");
                    error=1;
                }
                error=0;
                if(pass1.equals(pass2) && pas1.length()>3 && error==0) {
                   Intent intent=getIntent();
                    String firstname=intent.getStringExtra(Signup.first);
                    String lastname=intent.getStringExtra(Signup.last);
                    String username=intent.getStringExtra(Signup.u_name);
                    int amount=0;
                    boolean var=DBn.registeruser(firstname,lastname,username,pas1.getText().toString(),amount);
                    if(var ){
                        Toast.makeText(Signup2.this,"Success!",Toast.LENGTH_SHORT).show();
                        Intent myInt=new Intent(this , signScreen.class);
                        startActivity(myInt);
                    }
                    else
                        Toast.makeText(Signup2.this,"faild",Toast.LENGTH_LONG).show();
                }

                break;
        }


    }
}
