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
import com.levin.gads.gads.leaderboard.models.TopLearnerModel;

import java.util.ArrayList;
import java.util.Locale;

public class TopLearnerRecyclerAdapter extends RecyclerView.Adapter<TopLearnerRecyclerAdapter.ViewHolder> {
    private static final String TAG="TopLearnerRecyclerAdapter";
    private ArrayList<TopLearnerModel> topLearners;
    private static Context context;

    public TopLearnerRecyclerAdapter(ArrayList<TopLearnerModel> learners) {
        this.topLearners = learners;
    }

    @NonNull
    @Override
    public TopLearnerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new TopLearnerRecyclerAdapter.ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopLearnerRecyclerAdapter.ViewHolder holder, int position) {
        TopLearnerModel learner = topLearners.get(position);
        holder.Bind(learner);
    }

    @Override
    public int getItemCount() {
        return topLearners == null ? 0 : topLearners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final ImageView topLearnerBadge;
        public final TextView topLearnerName;
        public final TextView topLearnerDetail;

        private static final String SKILL_IQ_DESCRIPTION_FORMAT = "%d learning hours, %s";

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            topLearnerBadge = itemView.findViewById(R.id.leaderboard_image);
            topLearnerName = itemView.findViewById(R.id.text_leader_name);
            topLearnerDetail = itemView.findViewById(R.id.text_leader_details);
        }

        public  void Bind(TopLearnerModel learner){
            Glide.with(context)
                    .load(learner.badgeUrl)
                    .placeholder(R.drawable.image_skill_iq)
                    .into(topLearnerBadge);
            topLearnerName.setText(learner.name);
            topLearnerDetail.setText(String.format(Locale.getDefault(),
                    SKILL_IQ_DESCRIPTION_FORMAT, learner.hours, learner.country));
        }
    }
}
