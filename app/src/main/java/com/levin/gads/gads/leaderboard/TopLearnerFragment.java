package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.levin.gads.gads.leaderboard.models.TopLearnerModel;
import com.levin.gads.gads.leaderboard.utilities.JsonHelperTopLearner;
import com.levin.gads.gads.leaderboard.utilities.TopLearnerRecyclerAdapter;

import java.util.ArrayList;


public class TopLearnerFragment extends Fragment {

    private static final String TAG = "LearningLeadersFragment";
    private RecyclerView rvTopLearners;
    private TopLearnerRecyclerAdapter adapter;
    private ArrayList<TopLearnerModel> topLearners;
    private View view;

    public TopLearnerFragment() {
        // Required empty public constructor
        topLearners = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        topLearners = JsonHelperTopLearner.getTopLearners();
        adapter = new TopLearnerRecyclerAdapter(topLearners);
        rvTopLearners = view.findViewById(R.id.rv_learning_leaders);
        rvTopLearners.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvTopLearners.setAdapter(adapter);

        return view;
    }

    private void init(){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}