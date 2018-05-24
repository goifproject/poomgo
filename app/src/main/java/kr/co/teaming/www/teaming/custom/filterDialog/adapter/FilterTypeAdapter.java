package kr.co.teaming.www.teaming.custom.filterDialog.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.common.util.Const;
import kr.co.teaming.www.teaming.custom.filterDialog.NormalFilterDialog;

public class FilterTypeAdapter extends RecyclerView.Adapter<FilterTypeAdapter.ViewHolder> {

    private String[] filterTypeArray;
    private NormalFilterDialog dialogFragment;
    private int selectedPosition;

    public FilterTypeAdapter(NormalFilterDialog dialogFragment, int categoryType) {
        this.dialogFragment = dialogFragment;
        prepareData(categoryType);
    }

    private void prepareData(int type) {
        if(type == Const.Custom.STUDY_TYPE_FILTER) filterTypeArray = dialogFragment.getResources().getStringArray(R.array.study_category);
        if(type == Const.Custom.MATCHING_TYPE_FILTER) filterTypeArray = dialogFragment.getResources().getStringArray(R.array.matching_category);
    }

    @Override
    public FilterTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_filter_type, parent, false);
        return new FilterTypeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilterTypeAdapter.ViewHolder holder, int position) {
        holder.filterType.setText(filterTypeArray[position]);
        holder.position = position;
        if(selectedPosition == position) {
            holder.filterType.setTextColor(dialogFragment.getResources().getColor(R.color.color_text_dark));
        } else {
            holder.filterType.setTextColor(dialogFragment.getResources().getColor(android.R.color.secondary_text_dark));
        }
    }

    @Override
    public int getItemCount() {
        return filterTypeArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView filterType;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            filterType = itemView.findViewById(R.id.item_dialog_filter_type_text);
            filterType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFragment.setFilterType(position);
                    selectedPosition = position;
                    notifyDataSetChanged();
                }
            });
        }
    }
}