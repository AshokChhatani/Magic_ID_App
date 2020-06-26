package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID=findViewById(R.id.etID);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResults=findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String idNumber = etID.getText().toString().trim();
               String dob1 =idNumber.substring(0,2);
               String dob2 =idNumber.substring(2,4);
               String dob3=idNumber.substring(4,6);
               int gender =Integer.parseInt(Character.toString(idNumber.charAt(6)));
               String sGender;

               if(gender<5)
                   sGender=getString(R.string.female);
               else
                   sGender=getString(R.string.male);

               int nationality=Integer.parseInt(Character.toString(idNumber.charAt(10)));
               String sNationality;
               if(nationality==0)
                   sNationality=getString(R.string.SAcit);
                else
                   sNationality = getString(R.string.PAcit);

               String text=getString(R.string.dob)+dob3+"/"+dob2+"/"+"20"+dob1+getString(R.string.newline)+
                       getString(R.string.gender)+sGender+getString(R.string.newline)+
                       getString(R.string.nationality)+sNationality;
               tvResults.setText(text);
               tvResults.setVisibility(View.VISIBLE);
            }
        });


    }
}
