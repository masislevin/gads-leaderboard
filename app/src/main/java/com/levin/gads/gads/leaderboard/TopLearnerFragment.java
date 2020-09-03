package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.levin.gads.gads.leaderboard.models.TopLearnerModel;
import com.levin.gads.gads.leaderboard.services.LeaderBoardService;
import com.levin.gads.gads.leaderboard.services.LeaderBoardServiceBuilder;
import com.levin.gads.gads.leaderboard.utilities.TopLearnerRecyclerAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopLearnerFragment extends Fragment {

    private static final String TAG = "LearningLeadersFragment";
    private RecyclerView rvTopLearners;
    private TopLearnerRecyclerAdapter adapter;
    private View view;

    public TopLearnerFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        init();

        return view;
    }

    private void init(){
        LeaderBoardService service = LeaderBoardServiceBuilder.buildService(LeaderBoardService.class);
        Call<ArrayList<TopLearnerModel>> call = service.getTopLearners();
        call.enqueue(new Callback<ArrayList<TopLearnerModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TopLearnerModel>> call,
                                   Response<ArrayList<TopLearnerModel>> response) {
                Log.d(TAG, "getTopLearners : onResponse callback successful. " +
                        response.body().size() + " learners found. " + response.body().toString() );
                adapter = new TopLearnerRecyclerAdapter(response.body());
                rvTopLearners = view.findViewById(R.id.rv_learning_leaders);
                rvTopLearners.setLayoutManager(new LinearLayoutManager(view.getContext()));
                rvTopLearners.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<TopLearnerModel>> call, Throwable t) {
                Log.d(TAG, "getTopLearners : onResponse callback failed. " +
                        t.getMessage());
            }
        });
    }
}