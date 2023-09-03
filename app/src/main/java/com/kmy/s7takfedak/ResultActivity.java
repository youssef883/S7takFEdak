package com.kmy.s7takfedak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    android.widget.Button button ;

    TextView bmiDisplay , bmiCategory , gender ;

    Intent intent ;

    ImageView imageView;

    String bmi ,height ,weight;

    float intbmi ,intHieght ,intWeight;

    RelativeLayout background ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        intent = getIntent();

        bmiDisplay =findViewById(R.id.bmi_result);
        bmiCategory = findViewById(R.id.bmi_category);
        gender = findViewById(R.id.gender_display);
        background = findViewById(R.id.content_layout);
        imageView = findViewById(R.id.bmi_state);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHieght = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHieght =intHieght/100;

        intbmi = intWeight/(intHieght*intHieght);

        bmi = Float.toString(intbmi);

        if (intbmi<16)
        {
            bmiCategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.ic_crosss);
        }
        else if (intbmi<16.9 && intbmi > 16)
        {
            bmiCategory.setText("Moderate Thinness");
            background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ic_warning);
        }
        else if (intbmi<18.4 && intbmi > 17)
        {
            bmiCategory.setText("Mild Thinness");
            background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ic_warning);
        }
        else if (intbmi<25 && intbmi > 18.4)
        {
            bmiCategory.setText("Normal");
            background.setBackgroundColor(Color.GREEN);
            imageView.setImageResource(R.drawable.ic_ok);
        }
        else if (intbmi<29.4 && intbmi > 25)
        {
            bmiCategory.setText("OverWeight");
            background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ic_warning);
        }
        else
        {
            bmiCategory.setText("Obese Class I");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.ic_crosss);
        }

        gender.setText(intent.getStringExtra("gender"));
        bmiDisplay.setText(bmi);

        reCalcBMI();
    }

    public void reCalcBMI()
    {
        button = findViewById(R.id.recalc_bmi);
        button.setOnClickListener(v -> {
            Intent intent =new Intent(ResultActivity.this, BMIActivity.class);
            startActivity(intent);
            finish();
        });
    }
}