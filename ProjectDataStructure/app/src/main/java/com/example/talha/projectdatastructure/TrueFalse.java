package com.example.talha.projectdatastructure;

/**
 * Created by Talha on 22-Dec-15.
 */
public class TrueFalse {

    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean trueQuestion){
        this.mQuestion = question;
        this.mTrueQuestion = trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean isAnswerTrue) {
        this.mTrueQuestion = isAnswerTrue;
    }
}
