package kr.co.teaming.www.teaming.controller.matching.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;

public class MatchingByCategoryListAdapter extends RecyclerView.Adapter<MatchingByCategoryListAdapter.ViewHolder> {

    private Context mContext;
    private String[] categoryArray;

    public MatchingByCategoryListAdapter(Context mContext) {
        this.mContext = mContext;
        prepareData();
    }

    private void prepareData() {
        categoryArray = mContext.getResources().getStringArray(R.array.category_k);
    }

    @Override
    public MatchingByCategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_category, parent, false);
        return new MatchingByCategoryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchingByCategoryListAdapter.ViewHolder holder, int position) {
        holder.categoryText.setText(categoryArray[position]);
    }

    @Override
    public int getItemCount() {
        return categoryArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryText;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryText = itemView.findViewById(R.id.item_category_text);
        }
    }
}