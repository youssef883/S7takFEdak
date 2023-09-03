package com.kmy.s7takfedak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    android.widget.Button button ;

    TextView currentHeight,currentAge,currentWeight ;

    ImageView inc_weight ,inc_age , dec_weight , dec_age ;

    RelativeLayout male , female ;

    SeekBar seekBar ;

    int weight = 55 ,age =22 ,currentProgress ;

    String minProgress = "170" , typeOfUser = "0" , weight2 = "55" , age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        inflate();
        selectGender();
        setHeight();
        setAge();
        setWeight();
        showResult();
    }

    public void inflate()
    {
        button = findViewById(R.id.calc_bmi);
        currentHeight = findViewById(R.id.current_height);
        currentAge = findViewById(R.id.current_age);
        currentWeight = findViewById(R.id.current_weight);
        inc_weight = findViewById(R.id.increment_weight);
        inc_age = findViewById(R.id.increment_age);
        dec_weight = findViewById(R.id.decrement_weight);
        dec_age = findViewById(R.id.decrement_age);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        seekBar = findViewById(R.id.seek_bar_for_height);
    }

    public void selectGender()
    {
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_gender_selected));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_gender_unselected));

                typeOfUser = "Male";

            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_gender_selected));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_gender_unselected));

                typeOfUser = "Female";

            }
        });

    }

    public void setHeight()
    {

        seekBar.setMax(300);
        seekBar.setProgress(170);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress ;

                minProgress = String.valueOf(currentProgress);
                currentHeight.setText(minProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void setAge()
    {
        inc_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age =age+1 ;
                age2 = String.valueOf(age);
                currentAge.setText(age2);
            }
        });

        dec_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age =age-1 ;
                age2 = String.valueOf(age);
                currentAge.setText(age2);
            }
        });

    }

    public void setWeight()
    {
        inc_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight =weight+1 ;
                weight2 = String.valueOf(weight);
                currentWeight.setText(weight2);
            }
        });

        dec_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight =weight-1 ;
                weight2 = String.valueOf(weight);
                currentWeight.setText(weight2);
            }
        });

    }

    public void showResult()
    {

        button.setOnClickListener(v -> {

            if(typeOfUser.equals("0"))
            {
                Toast.makeText(getApplicationContext(),"Select your Gender !",Toast.LENGTH_LONG).show();
            }
            else if (minProgress.equals("0"))
            {
                Toast.makeText(getApplicationContext(),"Select your Height !",Toast.LENGTH_LONG).show();
            }
            else if (age == 0 || age<0)
            {
                Toast.makeText(getApplicationContext(),"Age is incorrect !",Toast.LENGTH_LONG).show();
            }
            else if (weight == 0 || weight<0)
            {
                Toast.makeText(getApplicationContext(),"Weight is incorrect !",Toast.LENGTH_LONG).show();
            }
            else
            {

                    Intent intent =new Intent(BMIActivity.this, ResultActivity.class);
                    intent.putExtra("gender",typeOfUser);
                    intent.putExtra("height",minProgress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
            }

        });
    }
}