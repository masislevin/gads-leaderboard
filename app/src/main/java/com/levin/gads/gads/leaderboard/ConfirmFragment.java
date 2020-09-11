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

import com.levin.gads.gads.leaderboard.models.SubmissionModel;

public class ConfirmFragment extends DialogFragment {
    private static final String TAG = "ConfirmFragment";

    private SubmissionModel model;
    private Button submissionConfirmed;
    private Button submissionCancelled;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;

    public static ConfirmFragment newDialogInstance(){
        return new ConfirmFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_submission_confirm, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        submissionConfirmed = view.findViewById(R.id.btn_submission_confirmed);
        submissionCancelled = view.findViewById(R.id.btn_submission_cancelled);

        submissionConfirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submission Confirmed!");
            }
        });

        submissionCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submission Cancelled.");
            }
        });
        return builder.create();
    }
}
