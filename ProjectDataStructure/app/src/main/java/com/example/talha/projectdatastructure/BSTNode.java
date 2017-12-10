package com.example.talha.projectdatastructure;

/**
 * Created by Talha on 22-Dec-15.
 */

public class BSTNode {
    BSTNode left, right;
    int difficultyLevel;
    TrueFalse[] questions;

    public BSTNode(){
        this.left = null;
        this.right = null;
        this.difficultyLevel = 0;
        this.questions = null;
    }

    public BSTNode(int d, TrueFalse[] questionArray){
        this.left = null;
        this.right = null;
        this.difficultyLevel = d;
        this.questions = questionArray;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public TrueFalse[] getQuestions() {
        return questions;
    }

    public void setQuestions(TrueFalse[] questions) {
        this.questions = questions;
    }
}

