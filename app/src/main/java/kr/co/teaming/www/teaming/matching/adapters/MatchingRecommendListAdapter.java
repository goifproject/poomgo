package kr.co.teaming.www.teaming.matching.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;

public class MatchingRecommendListAdapter extends RecyclerView.Adapter<MatchingRecommendListAdapter.ViewHolder>{
    @Override
    public MatchingRecommendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matching_member, parent, false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(MatchingRecommendListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView){ super(itemView); }
    }
}
