package kr.co.teaming.www.teaming.controller.notice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.teaming.www.teaming.R;

public class NoticeFragmentAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{


    NoticeRecyclerView noticeRecyclerView = new NoticeRecyclerView();
    private ArrayList<NoticeRecyclerView> noticeData = new ArrayList<>();

    // 아이템 클릭시 실행 함수
    private ItemClick itemClick;
    public interface ItemClick{
        public void onClick(View view, int position);
    }

    // 아이템 클릭시 실행 함수 등록 함수
    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }


    //        TeamingRESTInterface requst = TeamingApplication.getTeamingRESTInterface();
//        Call<NoticeInfo> call = requst.noticeinfo();
//        call.enqueue(new Callback<NoticeInfo>() {
//            @Override
//            public void onResponse(Call<NoticeInfo> call, Response<NoticeInfo> response) {
//                if(response.code() >= 200 || response.code() <400){
//                    NoticeInfo noticeInfo = response.body();
//                    noticeData.add(noticeRecyclerView.getNoticeStudyName(),);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NoticeInfo> call, Throwable t) {
//
//            }
//        });


    public NoticeFragmentAdapter() {

        noticeRecyclerView.setNoticeStudyName("영어");
        noticeRecyclerView.setNoticeDate("2018/02/02");
        noticeRecyclerView.setNoticeContext("안녕하세요");

        noticeData.add(noticeRecyclerView);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice, parent, false);

        return new RowCell(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((RowCell)holder).noticeStudyName.setText(noticeData.get(position).getNoticeStudyName());
        ((RowCell)holder).noticeDate.setText(noticeData.get(position).getNoticeDate());
        ((RowCell)holder).noticeContext.setText(noticeData.get(position).getNoticeContext());

        ((RowCell)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClick != null){
                    itemClick.onClick(v, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return noticeData.size();
    }


    private class RowCell extends RecyclerView.ViewHolder {

        View view;
        TextView noticeStudyName;
        TextView noticeDate;
        TextView noticeContext;

        public RowCell(View view) {
            super(view);
            this.view = view;
            noticeStudyName = view.findViewById(R.id.notice_study_name);
            noticeDate = view.findViewById(R.id.notice_date);
            noticeContext = view.findViewById(R.id.notice_context);
        }
    }
}
