package kr.co.teaming.www.teaming.controller.study.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;

public class StudyByRegionListAdapter extends RecyclerView.Adapter<StudyByRegionListAdapter.ViewHolder> {

    private Context mContext;
    private String[] regionArray;

    public StudyByRegionListAdapter(Context mContext) {
        this.mContext = mContext;
        prepareData();
    }

    private void prepareData() {
        regionArray = mContext.getResources().getStringArray(R.array.region_k);
    }


    @Override
    public StudyByRegionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_region, parent, false);
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
            regionText = itemView.findViewById(R.id.region_text);
        }

    }
}