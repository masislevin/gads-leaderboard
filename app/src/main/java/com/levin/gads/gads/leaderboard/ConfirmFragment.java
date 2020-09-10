package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.levin.gads.gads.leaderboard.models.SubmissionModel;
import com.levin.gads.gads.leaderboard.services.LeaderBoardService;
import com.levin.gads.gads.leaderboard.services.SubmissionServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmFragment extends DialogFragment {
    private static final String TAG = "ConfirmFragment";

    private SubmissionModel model;
    private Button submissionConfirmed;
    private Button submissionCancelled;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;

    public ConfirmFragment(SubmissionModel model){
        this.model = model;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_submission_confirm, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "ConfirmFragment created. ");

        builder = new AlertDialog.Builder(getContext());
        inflater = getLayoutInflater();

        submissionConfirmed = view.findViewById(R.id.btn_submission_confirmed);
        submissionCancelled = view.findViewById(R.id.btn_submission_cancelled);

        submissionConfirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeaderBoardService service = SubmissionServiceBuilder
                        .buildService(LeaderBoardService.class);
                Call<SubmissionModel> call = service.submitProject(model);
                call.enqueue(new Callback<SubmissionModel>() {
                    @Override
                    public void onResponse(Call<SubmissionModel> call,
                                           Response<SubmissionModel> response) {
                        Log.d(TAG, "onResponse: submission successful.");
                        dismiss();

                        builder.setView(inflater.inflate(
                                R.layout.fragment_submission_success, null));
                        builder.create().show();
                    }

                    @Override
                    public void onFailure(Call<SubmissionModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: submission failed");
                        dismiss();

                        builder.setView(inflater.inflate(
                                R.layout.fragment_submission_failed, null));
                        builder.create().show();
                    }
                });
            }
        });

        submissionCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
