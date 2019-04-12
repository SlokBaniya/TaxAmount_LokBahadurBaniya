package com.taxamount_lokbahadurbaniya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etAmount;
    private Button btnCalculate;
    private TextView tvOutput,txtAnnual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmount);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvOutput = findViewById(R.id.tvOutput);
        txtAnnual = findViewById(R.id.txtAnnual);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amt = Double.parseDouble(etAmount.getText().toString());
                double amount = amt*12;
                txtAnnual.setText(Double.toString(amount));

                TaxAmount ta = new TaxAmount();
                ta.setAmount(amount);

                if(amount<200000){
                    double res = ta.lowTax();
                    tvOutput.setText(Double.toString(res));
                }else if(amount >=200000 && amt<350000){
                    double res = ta.mediumTax();
                    tvOutput.setText(Double.toString(res));
                }else if(amount>=350000){
                    double res = ta.highTax();
                    tvOutput.setText(Double.toString(res));
                }
            }
        });
    }
}
