package com.levin.gads.gads.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.levin.gads.gads.leaderboard.models.SubmissionModel;

public class SubmissionActivity extends AppCompatActivity {
    private static final String TAG = "SubmissionActivity";
    private static final String FRAGMENT_TAG = "fragment_confirm_submission";

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
        Button toolbarBackButton = findViewById(R.id.toolbar_back);
        toolbarBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LeaderboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        model = new SubmissionModel(null, null, null, null);

        editTextFirstName = findViewById(R.id.tvFirstName);
        editTextLastName = findViewById(R.id.tvLastName);
        editTextEmail = findViewById(R.id.tvEmailAddress);
        editTextProjectUrl = findViewById(R.id.tvProjectUrl);

        final Button button = findViewById(R.id.btnSubmitProject);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //model = new SubmissionModel(editTextFirstName.getText().toString(),
                //        editTextLastName.getText().toString(),
                //        editTextEmail.getText().toString(),
                //        editTextProjectUrl.getText().toString());

                model = new SubmissionModel("Levin", "Masis",
                        "masislevin@gmail.com",
                        "https://github.com/masislevin/gads-leaderboard");

                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
                ConfirmFragment confirmFragment = ConfirmFragment.newDialogInstance(model);
                confirmFragment.show(fragmentManager, FRAGMENT_TAG);
            }
        });


    }
}