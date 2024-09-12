package edu.psu.swen888.agecalculator;


import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


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

                try{
                    LocalDate dob = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    LocalDate currentDate = LocalDate.now();
                    int calculatedAge = (int) ChronoUnit.YEARS.between(dob, currentDate);
                    String firstName = mInputFirstEditText.getText().toString();
                    Toast.makeText(AgeCalculator.this,(firstName + ", in case you forgot, you are " + calculatedAge + " years old!"),Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(AgeCalculator.this,("Invalid Input, please enter the date MM/DD/YY"),Toast.LENGTH_SHORT).show();
                }
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
