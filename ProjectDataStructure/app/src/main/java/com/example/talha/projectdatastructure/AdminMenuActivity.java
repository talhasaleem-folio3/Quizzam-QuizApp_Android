package com.example.talha.projectdatastructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMenuActivity extends AppCompatActivity {

    private Button mInsertButton;
    private Button mDeleteButton;
    private Button mSearchButton;
    private Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        mInsertButton = (Button) findViewById(R.id.button_insert);
        mDeleteButton = (Button) findViewById(R.id.button_delete);
        mSearchButton = (Button) findViewById(R.id.button_difficulty_level);
        mLogoutButton = (Button) findViewById(R.id.button_logout);



        mInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminMenuActivity.this, InsertQuestionsActivity.class);
                startActivity(i);
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminMenuActivity.this, DeleteQuestionsActivity.class);
                startActivity(i);
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                startActivity(i);
            }
        });

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
