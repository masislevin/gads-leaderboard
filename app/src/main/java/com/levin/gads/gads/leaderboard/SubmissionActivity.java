package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        model = new SubmissionModel(null, null, null, null);

        final Button button = findViewById(R.id.btnSubmitProject);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LeaderBoardService service = SubmissionServiceBuilder
                        .buildService(LeaderBoardService.class);
                Call<SubmissionModel> call = service.submitProject(model);
                call.enqueue(new Callback<SubmissionModel>() {
                    @Override
                    public void onResponse(Call<SubmissionModel> call,
                                           Response<SubmissionModel> response) {

                    }

                    @Override
                    public void onFailure(Call<SubmissionModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}