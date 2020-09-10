package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.levin.gads.gads.leaderboard.models.SubmissionModel;
import com.levin.gads.gads.leaderboard.utilities.LeaderBoardDialog;

public class SubmissionActivity extends AppCompatActivity {
    private static final String TAG = "SubmissionActivity";

    private static SubmissionModel model;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextProjectUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        /// show back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        model = new SubmissionModel(null, null, null, null);

        editTextFirstName = findViewById(R.id.tvFirstName);
        editTextLastName = findViewById(R.id.tvLastName);
        editTextEmail = findViewById(R.id.tvEmailAddress);
        editTextProjectUrl = findViewById(R.id.tvProjectUrl);


        final Button button = findViewById(R.id.btnSubmitProject);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                model = new SubmissionModel(editTextFirstName.getText().toString(),
                        editTextLastName.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextProjectUrl.getText().toString());

                LeaderBoardDialog dialogFragment = new LeaderBoardDialog(v.getContext(), model);
                dialogFragment.showConfirmationDialog();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}