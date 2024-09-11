package edu.psu.swen888.agecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                //Get the number from the EditText
                String numberString = mInputDOBEditText.getText().toString();
                int number = Integer.parseInt(numberString);
                String firstName = mInputFirstEditText.getText().toString();

                  int calculateAge = calculateAge(number);

                mResultTextView.setText(firstName + ", in case you forgot, you are " + calculateAge(number) + " years old!");
                mResultTextView.setVisibility(View.VISIBLE);
            }
        });
    }


    public int calculateAge(int number){
        return 5;
    }


}
