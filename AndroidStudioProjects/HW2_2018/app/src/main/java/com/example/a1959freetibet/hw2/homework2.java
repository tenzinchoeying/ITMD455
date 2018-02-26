package com.example.a1959freetibet.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class homework2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework2);

        final EditText mealCostET = (EditText)
                findViewById(R.id.mealCostET);
        final EditText taxPercentET = (EditText)
                findViewById(R.id.taxPercentET);
        final EditText tipPercentET = (EditText)
                findViewById(R.id.tipPercentET);

        final TextView totalCostTV = (TextView)
                findViewById(R.id.totalCostTV);

        Button calculateB = (Button) findViewById(R.id.calculateB);
        calculateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double taxPercentage = Double.parseDouble(
                        taxPercentET.getText().toString()) / 100;
                double tipPercentage = Double.parseDouble(
                        tipPercentET.getText().toString()) / 100;
                double mealCost = Double.parseDouble(
                        mealCostET.getText().toString());
                double tip = tipPercentage * mealCost;
                String total = String.format("%.2f", (mealCost + mealCost * taxPercentage)
                        + tip);

                totalCostTV.setText(total);
            }
        });
    }
}
