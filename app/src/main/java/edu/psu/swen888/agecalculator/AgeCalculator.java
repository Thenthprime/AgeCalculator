package edu.psu.swen888.agecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AgeCalculator extends AppCompatActivity  {
    private TextView mResultTextView;
    private EditText mInputNumberEditText;
    private Button mCalculateAgeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_age_calculator);

        mResultTextView = findViewById(R.id.result_text);
        mInputNumberEditText = findViewById(R.id.number_field);
        mCalculateAgeButton = findViewById(R.id.check_button);

        mCalculateAgeButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                //Get the number from the EditText
                String numberString = mInputNumberEditText.getText().toString();
                int number = Integer.parseInt(numberString);

                  int calculateAge = calculateAge(number);

                mResultTextView.setText(calculateAge(number));
                mResultTextView.setVisibility(View.VISIBLE);
            }
        });
    }


    public int calculateAge(int number){
        return 5;
    }


}
