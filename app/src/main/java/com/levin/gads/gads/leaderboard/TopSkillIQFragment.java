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

import com.levin.gads.gads.leaderboard.models.SkillIQModel;
import com.levin.gads.gads.leaderboard.utilities.JsonHelperSkillIQ;
import com.levin.gads.gads.leaderboard.utilities.SkillIQRecyclerAdapter;

import java.util.ArrayList;

public class TopSkillIQFragment extends Fragment{

    private static final String TAG = "SkillIQLeadersFragment";
    private static final int THREADS = 4;
    private RecyclerView rvTopLearners;
    private SkillIQRecyclerAdapter adapter;
    private ArrayList<SkillIQModel> topLearners;
    private View view;

    public TopSkillIQFragment() {
        // Required empty public constructor
        topLearners = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);
        topLearners = JsonHelperSkillIQ.getTopSKillIQLearners();
        adapter = new SkillIQRecyclerAdapter(topLearners);
        rvTopLearners = view.findViewById(R.id.rv_skill_iq_leaders);
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