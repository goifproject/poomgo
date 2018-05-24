package kr.co.teaming.www.teaming.custom.filterDialog.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.custom.filterDialog.NormalFilterDialog;

public class PrimaryFilterAdapter extends RecyclerView.Adapter<PrimaryFilterAdapter.ViewHolder> {

    private String[] primaryFilterArray;
    private NormalFilterDialog dialogFragment;
    private int selectedPosition;

    public PrimaryFilterAdapter(NormalFilterDialog dialogFragment) {
        this.dialogFragment = dialogFragment;
        setPrimaryFilter(0);
    }

    public void setPrimaryFilter(int filterType) {
        switch (filterType) {
            case 0:
                primaryFilterArray = dialogFragment.getResources().getStringArray(R.array.region_k);
                break;
            case 1:
                primaryFilterArray = dialogFragment.getResources().getStringArray(R.array.category_k);
                break;
            case 2:
                primaryFilterArray = dialogFragment.getResources().getStringArray(R.array.time_k);
                break;
            case 3:
                primaryFilterArray = dialogFragment.getResources().getStringArray(R.array.age_k);
                break;
            case 4:
                primaryFilterArray = dialogFragment.getResources().getStringArray(R.array.count_k);
                break;
        }
        selectedPosition = 0;
        dialogFragment.setPrimaryFilter(0);
        notifyDataSetChanged();
    }

    @Override
    public PrimaryFilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_primary_filter, parent, false);
        return new PrimaryFilterAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrimaryFilterAdapter.ViewHolder holder, int position) {
        holder.primaryFilterText.setText(primaryFilterArray[position]);
        // TODO adapter position
        holder.position = position;
        if(selectedPosition == position) {
            holder.primaryFilterText.setTextColor(dialogFragment.getResources().getColor(R.color.color_text_dark));
        } else {
            holder.primaryFilterText.setTextColor(dialogFragment.getResources().getColor(android.R.color.secondary_text_dark));
        }
     }

    @Override
    public int getItemCount() {
        return primaryFilterArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView primaryFilterText;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            primaryFilterText = itemView.findViewById(R.id.item_dialog_primary_filter_text);
            primaryFilterText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFragment.setPrimaryFilter(position);
                    selectedPosition = position;
                    notifyDataSetChanged();
                }
            });
        }
    }
}