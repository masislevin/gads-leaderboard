package com.levin.gads.gads.leaderboard.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.levin.gads.gads.leaderboard.R;
import com.levin.gads.gads.leaderboard.models.SkillIQModel;

import java.util.ArrayList;
import java.util.Locale;

public class SkillIQRecyclerAdapter extends
        RecyclerView.Adapter<SkillIQRecyclerAdapter.ViewHolder> {

    private static final String TAG = "LeaderBoardRecyclerAdapter";

    private ArrayList<SkillIQModel> topSkillIQLearners;
    private static Context context;

    public SkillIQRecyclerAdapter(ArrayList<SkillIQModel> learners) {
        this.topSkillIQLearners = learners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillIQModel learner = topSkillIQLearners.get(position);
        holder.Bind(learner);
    }

    @Override
    public int getItemCount() {
        return topSkillIQLearners == null ? 0 : topSkillIQLearners.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public final ImageView topLearnerBadge;
        public final TextView topLearnerName;
        public final TextView topLearnerDetail;

        private static final String SKILL_IQ_DESCRIPTION_FORMAT = "%d skill IQ score, %s";

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            topLearnerBadge = itemView.findViewById(R.id.leaderboard_image);
            topLearnerName = itemView.findViewById(R.id.text_leader_name);
            topLearnerDetail = itemView.findViewById(R.id.text_leader_details);
        }

        public void Bind(SkillIQModel learner){
            Glide.with(context)
                    .load(learner.badgeUrl)
                    .placeholder(R.drawable.image_skill_iq)
                    .into(topLearnerBadge);
            topLearnerName.setText(learner.name);
            topLearnerDetail.setText(String.format(Locale.getDefault(),
                    SKILL_IQ_DESCRIPTION_FORMAT, learner.score, learner.country));
        }
    }
}
