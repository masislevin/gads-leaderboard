package com.levin.gads.gads.leaderboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.levin.gads.gads.leaderboard.utilities.LeaderBoardPagerAdapter;

public class LeaderboardActivity extends AppCompatActivity {

    private static final String TAG = "LeaderboardActivity";
    private static final int LEARNING_LEADERS_FRAGMENT = 0;
    private static final int SKILL_IQ_LEADERS_FRAGMENT = 1;

    //fragments
    private TopLearnerFragment learningLeadersFragment;
    private TopSkillIQFragment skillIQLeadersFragment;

    //widgets
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        viewPager = findViewById(R.id.view_pager_container);
        setupViewPager();
    }

    private void setupViewPager(){
        LeaderBoardPagerAdapter leaderBoardPagerAdapter =
                new LeaderBoardPagerAdapter(getSupportFragmentManager());
        learningLeadersFragment = new TopLearnerFragment();
        skillIQLeadersFragment = new TopSkillIQFragment();
        leaderBoardPagerAdapter.addFragment(learningLeadersFragment);
        leaderBoardPagerAdapter.addFragment(skillIQLeadersFragment);

        viewPager.setAdapter(leaderBoardPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(LEARNING_LEADERS_FRAGMENT).setText(R.string.tag_learning_leaders);
        tabLayout.getTabAt(SKILL_IQ_LEADERS_FRAGMENT).setText(R.string.tag_skill_iq_leaders);

    }
}