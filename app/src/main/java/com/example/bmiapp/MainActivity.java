package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        LinearLayout main;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        main = findViewById(R.id.main);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt =Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);
                String bmiResult = String.format("Your BMI is %.2f ", bmi);
                if(bmi > 25){
                    txtResult.setText(bmiResult +"\nYou Are Over Weight\nThe Healthy Range Is 18-25");
                    main.setBackgroundColor(getResources().getColor(R.color.over));
                }else if(bmi < 18){
                    txtResult.setText(bmiResult +"\nYou are Under Weight\nThe Healthy Range Is 18-25");
                    main.setBackgroundColor(getResources().getColor(R.color.under));
                }else{
                    txtResult.setText(bmiResult +"\nYou Are Healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });



    }
}