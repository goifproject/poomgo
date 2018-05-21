package kr.co.teaming.www.teaming.controller.study.main.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.controller.study.detail.StudyDetailActivity;

public class StudyFavoriteListAdapter extends RecyclerView.Adapter<StudyFavoriteListAdapter.ViewHolder> {



    @Override
    public StudyFavoriteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study_clip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudyFavoriteListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), StudyDetailActivity.class));
                }
            });
        }
    }
}
