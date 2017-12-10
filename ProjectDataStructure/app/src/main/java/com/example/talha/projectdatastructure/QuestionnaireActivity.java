package com.example.talha.projectdatastructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionnaireActivity extends AppCompatActivity {


    /**
     * The problem in this Activity is that when the updateQuestion() method is called in the onCreate() method
     * for the first time it counts the nodes as 10 but after that it changes to 19 which is not true.
     * I've changed it somehow but it's still not the correct way to do it. - Talha Saleem!
     */

    private static final String EXTRA_CORRECT_ANSWERS = "com.example.talha.projectdatastructure.correct_answers";
    private static final String EXTRA_NO_OF_QUESTION = "com.example.talha.projectdatastructure.no_of_questions";

    private TextView mTimer;
    private TextView mQuestionTextView;
    private TextView mQuestionNoTextView;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mQuitButton;
    private Button mViewScoresButton;
    private int num;

    private int mTrueCounts = 0;
    private TrueFalse tf;
    private int mQuestionNo = 0;

    private int seconds = 60;
    private int minutes = 4;

    static MyBST bst;

    private void resultActivity(){
        Intent i = new Intent(QuestionnaireActivity.this, ResultActivity.class);
        i.putExtra(EXTRA_CORRECT_ANSWERS, mTrueCounts);
        i.putExtra(EXTRA_NO_OF_QUESTION, num);
        startActivity(i);
        finish();
    }


    private void updateQuestion(){

        mQuestionNo++;

        if(mQuestionNo > num){
            mTrueButton.setEnabled(false);
            mFalseButton.setEnabled(false);
            mViewScoresButton.setEnabled(true);
            return;
        }

        tf = bst.bringQuestions()[1];//ThreadLocalRandom.current().nextInt(0, 3)];
        mQuestionTextView.setText(tf.getQuestion());
        mQuestionNoTextView.setText("" + (mQuestionNo) + "/" + "" + num);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        bst = LoginActivity.bst;
        Timer schedule = new Timer();

        schedule.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTimer = (TextView) findViewById(R.id.timer);
                        mTimer.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));
                        seconds -= 1;

                        if (seconds == 0) {

                            if (minutes == 0) {
                                finish();
                            }

                            mTimer.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));
                            seconds = 60;
                            minutes = minutes - 1;
                        }
                    }
                });
            }
        }, 0, 1000);

        mQuestionTextView = (TextView) findViewById(R.id.textview_question);

        mQuestionNoTextView = (TextView) findViewById(R.id.textView_question_No);


        //loadQuestions();
        num = bst.countNodes();
        updateQuestion();

        mTrueButton = (Button) findViewById(R.id.button_true);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tf.isTrueQuestion() == true) {
                    mTrueCounts++;
                }

                updateQuestion();
            }
        });

        mFalseButton = (Button) findViewById(R.id.button_false);

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tf.isTrueQuestion() == false) {
                    mTrueCounts++;
                }
                updateQuestion();
            }
        });

        mQuitButton = (Button) findViewById(R.id.button_quit_quiz);

        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultActivity();
            }
        });

        mViewScoresButton = (Button) findViewById(R.id.button_scores);
        mViewScoresButton.setEnabled(false);

        mViewScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultActivity();
            }
        });
    }
}
