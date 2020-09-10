package com.levin.gads.gads.leaderboard.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.fragment.app.DialogFragment;

import com.levin.gads.gads.leaderboard.models.SubmissionModel;
import com.levin.gads.gads.leaderboard.services.LeaderBoardService;
import com.levin.gads.gads.leaderboard.services.SubmissionServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardDialog extends DialogFragment {

    private static final String TAG = "LeaderBoardDialog";
    private Context context;
    private SubmissionModel model;

    public LeaderBoardDialog(Context context, SubmissionModel submissionModel){
        this.context = context;
        model = submissionModel;
    }

    public void showConfirmationDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setMessage("Are you sure?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(TAG, "showConfirmationDialog : setPositiveButton, onClick. ");

                /* TODO: validations & error handling */

                LeaderBoardService service = SubmissionServiceBuilder
                        .buildService(LeaderBoardService.class);
                Call<SubmissionModel> call = service.submitProject(model);
                call.enqueue(new Callback<SubmissionModel>() {
                    @Override
                    public void onResponse(Call<SubmissionModel> call,
                                           Response<SubmissionModel> response) {
                        // show success fragment
                    }

                    @Override
                    public void onFailure(Call<SubmissionModel> call, Throwable t) {
                        // show failure fragment
                    }
                });
            }
        });

        alertDialogBuilder.create().show();
    }
}
