package kr.co.teaming.www.teaming.myStudy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.models.MyStudyRecyclerView;
import kr.co.teaming.www.teaming.notice.NoticeFragmentAdapter;

public class MyStudyFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    MyStudyRecyclerView myStudyRecyclerView = new MyStudyRecyclerView();
    private ArrayList<MyStudyRecyclerView> MyStudyData = new ArrayList<>();

    public MyStudyFragmentAdapter(){

        myStudyRecyclerView.setMystudy_recycler_item_image(R.drawable.testimage);
        myStudyRecyclerView.setMystudy_recycler_item_study_title("이것은 테스트 입니다. 이 자리는 스터디 이름입니다.");
        myStudyRecyclerView.setMystudy_recycler_item_study_date("이것은 테스트 입니다. 이 자리는 스터디 날짜/시간입니다.");

        MyStudyData.add(myStudyRecyclerView);
    }

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((RowCell)holder).mystudy_recycler_item_image.setImageResource(MyStudyData.get(position).getMystudy_recycler_item_image());
        ((RowCell)holder).mystudy_recycler_item_study_title.setText(MyStudyData.get(position).getMystudy_recycler_item_study_title());
        ((RowCell)holder).mystudy_recycler_item_study_date.setText(MyStudyData.get(position).getMystudy_recycler_item_study_date());

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
        return MyStudyData.size();
    }

    private class RowCell extends RecyclerView.ViewHolder {

        View view;
        ImageView mystudy_recycler_item_image;
        TextView mystudy_recycler_item_study_title;
        TextView mystudy_recycler_item_study_date;


        public RowCell(View view) {
            super(view);
            this.view = view;

            mystudy_recycler_item_image = view.findViewById(R.id.mystudy_recycler_item_image);
            mystudy_recycler_item_study_title = view.findViewById(R.id.mystudy_recycler_item_study_title);
            mystudy_recycler_item_study_date = view.findViewById(R.id.mystudy_recycler_item_study_date);

        }
    }
}
