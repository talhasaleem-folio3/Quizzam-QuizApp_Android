package com.example.talha.projectdatastructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;

    private Button mLoginButton;
    private Button mCancelButton;

    private TextView mAttemptsCounterTextView;

    private String adminUsername = "admin";
    private String adminPassword = "admin";

    private String studentUsername = "student";
    private String studentPassword = "student";

    private int counter = 3;

    static MyBST bst;

    private TrueFalse[] mDifficulty1 = new TrueFalse[]{
            new TrueFalse(R.string.diff1_q1, true),
            new TrueFalse(R.string.diff1_q2, true),
            new TrueFalse(R.string.diff1_q3, true)
    };

    private TrueFalse[] mDifficulty2 = new TrueFalse[]{
            new TrueFalse(R.string.diff2_q1, true),
            new TrueFalse(R.string.diff2_q2, true),
            new TrueFalse(R.string.diff2_q3, true)
    };

    private TrueFalse[] mDifficulty3 = new TrueFalse[]{
            new TrueFalse(R.string.diff3_q1, true),
            new TrueFalse(R.string.diff3_q2, false),
            new TrueFalse(R.string.diff3_q3, true)
    };

    private TrueFalse[] mDifficulty4 = new TrueFalse[]{
            new TrueFalse(R.string.diff4_q1, true),
            new TrueFalse(R.string.diff4_q2, false),
            new TrueFalse(R.string.diff4_q3, true)
    };

    private TrueFalse[] mDifficulty5 = new TrueFalse[]{
            new TrueFalse(R.string.diff5_q1, true),
            new TrueFalse(R.string.diff5_q2, true),
            new TrueFalse(R.string.diff5_q3, true)
    };

    private TrueFalse[] mDifficulty6 = new TrueFalse[]{
            new TrueFalse(R.string.diff6_q1, true),
            new TrueFalse(R.string.diff6_q2, true),
            new TrueFalse(R.string.diff6_q3, true)
    };

    private TrueFalse[] mDifficulty7 = new TrueFalse[]{
            new TrueFalse(R.string.diff7_q1, true),
            new TrueFalse(R.string.diff7_q2, true),
            new TrueFalse(R.string.diff7_q3, true)
    };

    private TrueFalse[] mDifficulty8 = new TrueFalse[]{
            new TrueFalse(R.string.diff8_q1, true),
            new TrueFalse(R.string.diff8_q2, true),
            new TrueFalse(R.string.diff8_q3, true)
    };

    private TrueFalse[] mDifficulty9 = new TrueFalse[]{
            new TrueFalse(R.string.diff9_q1, true),
            new TrueFalse(R.string.diff9_q2, true),
            new TrueFalse(R.string.diff9_q3, true)
    };

    private TrueFalse[] mDifficulty10 = new TrueFalse[]{
            new TrueFalse(R.string.diff10_q1, true),
            new TrueFalse(R.string.diff10_q2, true),
            new TrueFalse(R.string.diff10_q3, true)
    };

    TrueFalse[][] combine = {
            mDifficulty1, mDifficulty2, mDifficulty3, mDifficulty4, mDifficulty5,
            mDifficulty6, mDifficulty7, mDifficulty8, mDifficulty9,  mDifficulty10
    };

    private void loadQuestions(){
        for (int i = 0; i < 10; i++){
            bst.insert(i, combine[i]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Bundle instance = savedInstanceState;

        bst = new MyBST();

        loadQuestions();

        mUsernameEditText = (EditText) findViewById(R.id.editText_username);
        mPasswordEditText = (EditText) findViewById(R.id.editText_password);

        mAttemptsCounterTextView = (TextView) findViewById(R.id.textView_attemptsLeft);
        mAttemptsCounterTextView.setVisibility(View.GONE);

        mLoginButton = (Button) findViewById(R.id.button_login);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean authentication = verification(mUsernameEditText, mPasswordEditText);

                if (authentication){
                    Toast.makeText(getApplicationContext(), R.string.toast_redirecting, Toast.LENGTH_SHORT).show();
                    Intent loggedIn;

                    if (mUsernameEditText.getText().toString().equals("admin")){
                        loggedIn = new Intent(LoginActivity.this, AdminMenuActivity.class);
                        startActivity(loggedIn);
                    }

                    else {
                        loggedIn = new Intent(LoginActivity.this, QuizInstruction.class);
                        startActivity(loggedIn);
                    }
                }

                else {
                    counter--;
                    mAttemptsCounterTextView.setVisibility(View.VISIBLE);
                    mAttemptsCounterTextView.setText(" " + counter);

                    if (counter == 0){
                        mLoginButton.setEnabled(false);
                    }
                }
            }
        });

        mCancelButton = (Button) findViewById(R.id.button_cancel);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean verification(EditText getUsername, EditText getPassword){
        String username = getUsername.getText().toString();
        String password = getPassword.getText().toString();

        if (!(username.equals(adminUsername) || username.equals(studentUsername))){
            Toast.makeText(getApplicationContext(), R.string.toast_invalid_prompt, Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (!(password.equals(adminPassword) || password.equals(studentPassword))){
            Toast.makeText(getApplicationContext(), R.string.toast_invalid_prompt, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
