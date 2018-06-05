package kr.co.teaming.www.teaming.matching.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;

public class MatchingFieldListAdapter extends RecyclerView.Adapter<MatchingFieldListAdapter.ViewHolder>{
    @Override
    public MatchingFieldListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matching_kategorie, parent, false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(MatchingFieldListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){ super(itemView); }
    }
}
