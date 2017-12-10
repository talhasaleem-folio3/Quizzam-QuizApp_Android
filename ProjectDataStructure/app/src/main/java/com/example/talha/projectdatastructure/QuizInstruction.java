package com.example.talha.projectdatastructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizInstruction extends AppCompatActivity {

    private Button mStartQuiz;
    private Button mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_instruction);

        mStartQuiz = (Button) findViewById(R.id.button_start_quiz);

        mStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuizInstruction.this, QuestionnaireActivity.class);
                startActivity(i);
                finish();
            }
        });

        mLogout = (Button) findViewById(R.id.button_logout);

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.toast_logout_prompt, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
