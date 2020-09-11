package com.levin.gads.gads.leaderboard;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import com.levin.gads.gads.leaderboard.models.SubmissionModel;
import com.levin.gads.gads.leaderboard.services.LeaderBoardService;
import com.levin.gads.gads.leaderboard.services.SubmissionServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmFragment extends DialogFragment {
    private static final String TAG = "ConfirmFragment";
    private static final String SUCCESS_FRAGMENT_TAG = "fragment_submission_successful";
    private static final String FAILURE_FRAGMENT_TAG = "fragment_submission_failed";

    private static SubmissionModel model;
    private Button submissionConfirmed;
    private Button submissionCancelled;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;

    public static ConfirmFragment newDialogInstance(SubmissionModel submissionModel){
        return new ConfirmFragment(submissionModel);
    }
    public ConfirmFragment(SubmissionModel submissionModel){
        model = submissionModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_submission_confirm, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        //Log.d(TAG, "onCreateDialog: passed model" + model.toString());

        submissionConfirmed = view.findViewById(R.id.btn_submission_confirmed);
        submissionCancelled = view.findViewById(R.id.btn_submission_cancelled);

        submissionConfirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submission Confirmed! ");

                submitProject();
            }
        });

        submissionCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Log.d(TAG, "onClick: Submission Cancelled. ");
            }
        });
        return builder.create();
    }

    private void showFailureDialog(){
        FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
        SubmissionFailureFragment submissionFailureFragment =
                SubmissionFailureFragment.newDialogInstance();
        submissionFailureFragment.show(fragmentManager, FAILURE_FRAGMENT_TAG);
    }

    private void showSuccessDialog(){
        FragmentTransaction fragmentManager = getActivity().getSupportFragmentManager().beginTransaction();
        SubmissionSuccessFragment submissionSuccessFragment =
                SubmissionSuccessFragment.newDialogInstance();
        submissionSuccessFragment.show(fragmentManager, FAILURE_FRAGMENT_TAG);
    }

    private void submitProject(){
        dismiss();
        LeaderBoardService service = SubmissionServiceBuilder
                .buildService(LeaderBoardService.class);
        Call<SubmissionModel> call = service.submitProject(model);
        call.enqueue(new Callback<SubmissionModel>() {
            @Override
            public void onResponse(Call<SubmissionModel> call, Response<SubmissionModel> response) {
                Log.d(TAG, "onResponse: Submission successful.");
                // show success dialog
            }

            @Override
            public void onFailure(Call<SubmissionModel> call, Throwable t) {
                Log.d(TAG, "onResponse: Submission NOT successful.");
                // show failure dialog
            }
        });
    }

}
