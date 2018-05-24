package kr.co.teaming.www.teaming.controller.study.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.controller.study.main.StudyFragment;
import kr.co.teaming.www.teaming.model.study.study.Study;

public class StudyByCategoryListAdapter extends RecyclerView.Adapter<StudyByCategoryListAdapter.ViewHolder> {

    private StudyFragment studyFragment;
    private String[] categoryArray;

    public StudyByCategoryListAdapter(StudyFragment studyFragment) {
        this.studyFragment = studyFragment;
        prepareData();
    }

    private void prepareData() {
        categoryArray = studyFragment.getResources().getStringArray(R.array.category_k);
    }

    @Override
    public StudyByCategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_category, parent, false);
        return new StudyByCategoryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudyByCategoryListAdapter.ViewHolder holder, int position) {
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
            categoryText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    studyFragment.switchView();
                }
            });
        }
    }
}