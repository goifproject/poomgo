package kr.co.teaming.www.teaming.controller.study.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.model.study.study.Study;

public class ClippingListAdaptor extends RecyclerView.Adapter<ClippingListAdaptor.ViewHolder> {

    ArrayList<Study> clippingStudies;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.clipping_item_thumbnail)
        ImageView thumbnail;
        @BindView(R.id.clipping_item_name)
        TextView studyName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public ClippingListAdaptor(Context context, ArrayList<Study> clippingStudies) {
        this.clippingStudies = clippingStudies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_clipping_study, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        Glide.with(context).load("http://cfs7.tistory.com/upload_control/download.blog?fhandle=YmxvZzgyMzM1QGZzNy50aXN0b3J5LmNvbTovYXR0YWNoLzAvMDYwMDAwMDAwMDAwLmpwZw%3D%3D")
//                .into(holder.thumbnail);
//        holder.studyName.setText("스터디명"+position);
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
