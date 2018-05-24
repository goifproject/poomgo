package kr.co.teaming.www.teaming.controller.study.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.controller.study.main.StudyFragment;

public class StudyByRegionListAdapter extends RecyclerView.Adapter<StudyByRegionListAdapter.ViewHolder> {

    private StudyFragment studyFragment;
    private String[] regionArray;

    public StudyByRegionListAdapter(StudyFragment studyFragment) {
        this.studyFragment = studyFragment;
        prepareData();
    }

    private void prepareData() {
        regionArray = studyFragment.getResources().getStringArray(R.array.region_k);
    }

    @Override
    public StudyByRegionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_region, parent, false);
        return new StudyByRegionListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudyByRegionListAdapter.ViewHolder holder, int position) {
        holder.regionText.setText(regionArray[position]);
    }

    @Override
    public int getItemCount() {
        return regionArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView regionText;

        public ViewHolder(View itemView) {
            super(itemView);
            regionText = itemView.findViewById(R.id.item_region_text);
            regionText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    studyFragment.switchView();
                }
            });
        }

    }
}