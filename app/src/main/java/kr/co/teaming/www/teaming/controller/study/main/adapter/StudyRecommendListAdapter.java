package kr.co.teaming.www.teaming.controller.study.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;

public class StudyRecommendListAdapter extends RecyclerView.Adapter<StudyRecommendListAdapter.ViewHolder> {

    @Override
    public StudyRecommendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study_clip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudyRecommendListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
