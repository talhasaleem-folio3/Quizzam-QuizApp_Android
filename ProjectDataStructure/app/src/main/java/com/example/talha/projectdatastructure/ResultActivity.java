package com.example.talha.projectdatastructure;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private static final String EXTRA_CORRECT_ANSWERS = "com.example.talha.projectdatastructure.correct_answers";
    private static final String EXTRA_NO_OF_QUESTION = "com.example.talha.projectdatastructure.no_of_questions";

    private TextView mResultTextView;
    private TextView mPercentageTextView;
    private TextView mCorrectTextView;
    private TextView mIncorrectTextView;

    private Button mLogoutButton;

    private int mNumOfQuestions;
    private int mCorrectCount;
    private double mPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultTextView = (TextView) findViewById(R.id.textView_result_announce);
        mPercentageTextView = (TextView) findViewById(R.id.textView_percentage);
        mCorrectTextView = (TextView) findViewById(R.id.textView_correct);
        mIncorrectTextView = (TextView) findViewById(R.id.textView_incorrect);

        mLogoutButton = (Button) findViewById(R.id.result_logout);

        mNumOfQuestions = getIntent().getIntExtra(EXTRA_NO_OF_QUESTION, 0);
        mCorrectCount = getIntent().getIntExtra(EXTRA_CORRECT_ANSWERS, 0);

        mPercentage = ((mCorrectCount/(double) mNumOfQuestions) * 100);

        if(mPercentage >= 50){
            mResultTextView.setText(R.string.textView_success);
            mResultTextView.setTextColor(Color.parseColor("#00695C"));
        } else {
            mResultTextView.setText(R.string.textView_failed);
            mResultTextView.setTextColor(Color.parseColor("#F44336"));
        }
        mPercentageTextView.setText("Percentage: " + "" + mPercentage + "%");
        mCorrectTextView.setText("Correct Answers: " + "" + mCorrectCount);
        mIncorrectTextView.setText("IncorrectAnswers: " + "" + (mNumOfQuestions - mCorrectCount));

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
