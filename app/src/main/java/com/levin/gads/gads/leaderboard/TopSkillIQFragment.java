package com.levin.gads.gads.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.levin.gads.gads.leaderboard.models.SkillIQModel;
import com.levin.gads.gads.leaderboard.services.LeaderBoardService;
import com.levin.gads.gads.leaderboard.services.LeaderBoardServiceBuilder;
import com.levin.gads.gads.leaderboard.utilities.SkillIQRecyclerAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSkillIQFragment extends Fragment{

    private static final String TAG = "SkillIQLeadersFragment";
    private static final int THREADS = 4;
    private RecyclerView rvTopLearners;
    private SkillIQRecyclerAdapter adapter;
    private View view;

    public TopSkillIQFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        init();

        return view;
    }

    private void init(){
        LeaderBoardService service = LeaderBoardServiceBuilder.buildService(LeaderBoardService.class);
        Call<ArrayList<SkillIQModel>> call = service.getTopSkillIQImprovementLearners();
        call.enqueue(new Callback<ArrayList<SkillIQModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SkillIQModel>> call,
                                   Response<ArrayList<SkillIQModel>> response) {
                Log.d(TAG, "getTopLearners : onResponse callback successful. " +
                        response.body().size() + " learners found. "+ response.body().toString());
                adapter = new SkillIQRecyclerAdapter(response.body());
                rvTopLearners = view.findViewById(R.id.rv_skill_iq_leaders);
                rvTopLearners.setLayoutManager(new LinearLayoutManager(view.getContext()));
                rvTopLearners.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<SkillIQModel>> call, Throwable t) {
                Log.d(TAG, "getTopSkillIQImprovementLearners : onResponse callback failed. " +
                        t.getMessage());
            }
        });
    }
}