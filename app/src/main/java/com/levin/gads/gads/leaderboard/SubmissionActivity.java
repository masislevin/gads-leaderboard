package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.levin.gads.gads.leaderboard.models.SubmissionModel;
import com.levin.gads.gads.leaderboard.services.LeaderBoardService;
import com.levin.gads.gads.leaderboard.services.SubmissionServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                /* TODO: validations & error handling */

                LeaderBoardService service = SubmissionServiceBuilder
                        .buildService(LeaderBoardService.class);
                Call<SubmissionModel> call = service.submitProject(model);
                call.enqueue(new Callback<SubmissionModel>() {
                    @Override
                    public void onResponse(Call<SubmissionModel> call,
                                           Response<SubmissionModel> response) {
                        // inflate popup menu with success
                    }

                    @Override
                    public void onFailure(Call<SubmissionModel> call, Throwable t) {
                        // inflate popup menu with failure
                    }
                });
            }
        });
    }
}