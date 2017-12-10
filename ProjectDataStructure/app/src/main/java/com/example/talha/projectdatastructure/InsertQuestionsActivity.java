package com.example.talha.projectdatastructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertQuestionsActivity extends AppCompatActivity {

    private EditText mDifficultyLevelEditText;
    private EditText mQuestion1EditText;
    private EditText mQuestion2EditText;
    private EditText mQuestion3EditText;
    private Button mAddQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_questions);

        mDifficultyLevelEditText = (EditText)findViewById(R.id.editText_difficulty_level);

        mQuestion1EditText = (EditText)findViewById(R.id.editText_question_1);
        mQuestion2EditText = (EditText)findViewById(R.id.editText_question_2);
        mQuestion3EditText = (EditText)findViewById(R.id.editText_question_3);

        mAddQuestionButton = (Button)findViewById(R.id.button_add);

        mAddQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDifficultyLevelEditText.equals("") || mQuestion1EditText.equals("") || mQuestion2EditText.equals("") || mQuestion3EditText.equals("")){
                    Toast.makeText(InsertQuestionsActivity.this, "Please insert all fields", Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });

    }
}
