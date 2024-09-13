package edu.psu.swen888.agecalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class AgeCalculator extends AppCompatActivity  {

    //pull fields as defined in activity_age_calculator xml
    private EditText mInputDOBEditText;
    private EditText mInputFirstEditText;
    private EditText mInputLastEditText;
    private Button mCalculateAgeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //layout according to the activity_age_calculator.xml file
        setContentView(R.layout.activity_age_calculator);

        //define the user input fields
        mInputDOBEditText = findViewById(R.id.dOB_field);
        mInputFirstEditText = findViewById(R.id.firstName_field);
        mInputLastEditText = findViewById(R.id.lastName_field);
        mCalculateAgeButton = findViewById(R.id.check_button);

        //assign clickListener functionality to the mcalcualteAgeButton button
        mCalculateAgeButton.setOnClickListener(new View.OnClickListener(){
            @Override

            //method to react after user clicks "calculate age" button
            public void onClick(View v) {
                //grab user input
                String dateOfBirth = mInputDOBEditText.getText().toString();
                String firstName = mInputFirstEditText.getText().toString();
                String lastName = mInputLastEditText.getText().toString();

                //check if field values are all filled
                if (dateOfBirth.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                    Toast.makeText(AgeCalculator.this, ("Please be sure to include all fields."), Toast.LENGTH_SHORT).show();
                }

                else {
                    //try catch method to respond to invalid input
                    try {
                        //parse the date the user entered
                        LocalDate dob = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                        //grab today's date
                        LocalDate currentDate = LocalDate.now();
                        //calculate the number of years that have passed
                        int calculatedAge = (int) ChronoUnit.YEARS.between(dob, currentDate);
                        //grab the first name to put into the toast message
                        //display toast message with the result
                        Toast.makeText(AgeCalculator.this, (firstName + ", in case you forgot, you are " + calculatedAge + " years old!"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        //give a reminder to the user about invalid input
                        Toast.makeText(AgeCalculator.this, ("Invalid Input, please enter the date MM/DD/YY"), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
