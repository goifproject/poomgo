package kr.co.teaming.www.teaming.myStudy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.notice.NoticeFragmentAdapter;

public class MyStudyFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{



    // 아이템 클릭시 실행 함수
    private NoticeFragmentAdapter.ItemClick itemClick;
    public interface ItemClick{
        public void onClick(View view, int position);
    }

    // 아이템 클릭시 실행 함수 등록 함수
    public void setItemClick(NoticeFragmentAdapter.ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mystudy_recyclerview_item, parent, false);

        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class RowCell extends RecyclerView.ViewHolder {

        View view;
        public RowCell(View view) {
            super(view);
            this.view = view;
        }
    }
}
