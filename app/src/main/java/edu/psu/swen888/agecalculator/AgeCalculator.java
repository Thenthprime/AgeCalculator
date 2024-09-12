package edu.psu.swen888.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class AgeCalculator extends AppCompatActivity  {
    private TextView mResultTextView;
    private EditText mInputDOBEditText;
    private EditText mInputFirstEditText;
    private Button mCalculateAgeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_age_calculator);

        mResultTextView = findViewById(R.id.result_text);
        mInputDOBEditText = findViewById(R.id.dOB_field);
        mInputFirstEditText = findViewById(R.id.firstName_field);
        mCalculateAgeButton = findViewById(R.id.check_button);

        mCalculateAgeButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                String dateOfBirth = mInputDOBEditText.getText().toString();
                LocalDate ld  = LocalDate.parse(dateOfBirth,
                        DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                int yearOfBirth = ld.getYear();

                String firstName = mInputFirstEditText.getText().toString();


                int calculatedAge = calculateAge(yearOfBirth);

                mResultTextView.setText(firstName + ", in case you forgot, you are " + calculatedAge + " years old!");
                mResultTextView.setVisibility(View.VISIBLE);
            }
        });
    }


    public int calculateAge(int year){
        LocalDate currentDate = LocalDate.now();
        int todayYear = currentDate.getYear();

        int yearsOld = todayYear - year;


        return yearsOld;
    }


}
