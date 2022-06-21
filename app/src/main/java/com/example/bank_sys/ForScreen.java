package com.example.bank_sys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForScreen extends AppCompatActivity implements View.OnClickListener {
    Button set;
    EditText user,pas,vpas;

    DBhelper DBn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_screen);
        user=findViewById(R.id.F_user);
        pas=findViewById(R.id.F_pass);
        vpas=findViewById(R.id.F_vpass);
        set=findViewById(R.id.B_for);
        set.setOnClickListener(this);
        DBn=new DBhelper(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.B_for:
                String inputUser=user.getText().toString();
                String inputPas=pas.getText().toString();
                String inputvPas=vpas.getText().toString();
                boolean check=DBn.checkuserfound(inputUser);
                boolean check2=DBn.updatepass(inputUser,inputPas);
                if(check) {
                    if (inputPas.equals(inputvPas) && inputPas.length() > 3 && check2) {
                        Intent myInt = new Intent(this, signScreen.class);
                        startActivity(myInt);
                        Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();
                    } else {
                        vpas.setError("");
                        Toast.makeText(this, "Faild!...", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    user.setError("Uncorrect User Mail");
                }
                    break;



        }

    }
}