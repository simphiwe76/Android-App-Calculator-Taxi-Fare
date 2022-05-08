package com.example.hello;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd =  (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                EditText edtPassangerAmt = (EditText) findViewById(R.id.edtPassangerAmt);
                TextView txtResult = (TextView) findViewById(R.id.txtResult);
                TextView txtChange = (TextView) findViewById(R.id.txtChange);
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

                int num1,num2,num3,taxiAmt,change,amountDue;

                try {
                    num1 = Integer.parseInt(edtNum2.getText().toString());
                    num2 = Integer.parseInt(edtNum1.getText().toString());
                    num3 = Integer.parseInt(edtPassangerAmt.getText().toString());

                    progressBar.setVisibility(View.VISIBLE);
                    taxiAmt = num2 * num3;

                    txtResult.setText("Driver Amount R"+String.valueOf(taxiAmt));
                    Toast.makeText(getApplicationContext(),"Thank You for using our app!",Toast.LENGTH_SHORT).show();
                    if (num1 > taxiAmt)
                    {
                        change = num1 - taxiAmt;
                        txtChange.setText("Passangers Change R"+String.valueOf(change));
                        Toast.makeText(getApplicationContext(),"Thank You for using our app!",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                    }
                    else if(num1 == taxiAmt){
                        change = 0;
                        txtChange.setText("Passangers Change R"+String.valueOf(change));
                        Toast.makeText(getApplicationContext(),"Thank You for using our app!",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    else {
                        amountDue = taxiAmt -  num1;
                        txtChange.setText("Amount Left to be paid R"+String.valueOf(amountDue));
                        Toast.makeText(getApplicationContext(),"Thank You for using our app!",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }


                }
                catch (Exception e){
                       System.out.println(e);
                }




            }
        });

    }
}