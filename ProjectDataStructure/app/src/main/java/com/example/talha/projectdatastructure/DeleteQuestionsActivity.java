package com.example.talha.projectdatastructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteQuestionsActivity extends AppCompatActivity {

    private EditText mDiffLevelEditText;
    private Button mDeleteQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_questions);

        mDiffLevelEditText = (EditText) findViewById(R.id.editText_diff_level);
        mDeleteQuestionButton = (Button) findViewById(R.id.button_delete_question);

        mDeleteQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDiffLevelEditText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the required fields", Toast.LENGTH_SHORT).show();
                } else if (LoginActivity.bst.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Questions are empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (LoginActivity.bst.search((Integer.parseInt(mDiffLevelEditText.getText().toString()))) == false) {
                    Toast.makeText(getApplicationContext(), "Difficulty Level not Found!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    LoginActivity.bst.delete((Integer.parseInt(mDiffLevelEditText.getText().toString())));
                   // Toast.makeText(getApplicationContext(), "" + mDiffLevelEditText.getText().toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Questions Deleted", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}
