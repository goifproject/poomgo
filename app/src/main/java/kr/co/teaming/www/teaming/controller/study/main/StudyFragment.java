package kr.co.teaming.www.teaming.controller.study.main;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.common.util.Const;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyByCategoryListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyByRegionListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyFavoriteListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyRecommendListAdapter;
import kr.co.teaming.www.teaming.custom.filterDialog.NormalFilterDialog;

public class StudyFragment extends Fragment
        implements View.OnClickListener {


//    @BindView(R.id.favoriteStudyRecyclerView)
//    private RecyclerView favoriteStudyRecyclerView;
//    @BindView(R.id.recommendStudyRecyclerView)
//    private RecyclerView recommendStudyRecyclerView;
//    @BindView(R.id.studyByRegionRecyclerView)
//    private RecyclerView studyByRegionRecyclerView;
//    @BindView(R.id.studyByCategoryRecyclerView)
//    private RecyclerView studyByCategoryRecyclerView;

    // TODO 코드 분리 전혀 안 됨
    // TODO 클린 코드

    private StudyByRegionListAdapter byRegionAdapter;
    private StudyByCategoryListAdapter byCategoryAdapter;
    private StudyFavoriteListAdapter favoriteListAdapter;
    private StudyRecommendListAdapter recommendListAdapter;
    private StudyListAdapter studyListAdapter;
    private RecyclerView favoriteStudyRecyclerView;
    private RecyclerView recommendStudyRecyclerView;
    private RecyclerView studyByRegionRecyclerView;
    private RecyclerView studyByCategoryRecyclerView;
    private View view;
    // TODO AutoCompleteTextView
    private EditText studySearchInput;
    private Button studySearchDetail;
    private RecyclerView studyListRecycler;
    private LinearLayout layoutStudyContentList1;
    private LinearLayout layoutStudyContentList2;
    private LinearLayout layoutStudyContentList3;
    private NestedScrollView studyScrollview;

//    private OnStudyFragmentInteraction ISFInteraction;

    public static StudyFragment newInstance(String userId) {
        StudyFragment fragment = new StudyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_study, container, false);
        initView();
//        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        initView();
        setListener();
        setFavoriteRecycler();
        setRecommendRecycler();
        setByRegionRecycler();
        setByCategoryRecycler();
        setStudyListAdapter();
    }

    // TOOD Kotlin으로 넘어가고야 할겠다
    private void initView() {
        favoriteStudyRecyclerView = view.findViewById(R.id.favoriteStudyRecyclerView);
        recommendStudyRecyclerView = view.findViewById(R.id.recommendStudyRecyclerView);
        studyByRegionRecyclerView = view.findViewById(R.id.studyByRegionRecyclerView);
        studyByCategoryRecyclerView = view.findViewById(R.id.studyByCategoryRecyclerView);
        studySearchInput = view.findViewById(R.id.study_search_input);
        studySearchDetail = view.findViewById(R.id.study_search_detail);
        studyListRecycler = view.findViewById(R.id.studyListRecycler);
        layoutStudyContentList1 = view.findViewById(R.id.include_study_list1);
        layoutStudyContentList2 = view.findViewById(R.id.include_study_list2);
        layoutStudyContentList3 = view.findViewById(R.id.include_study_list3);
        studyScrollview = view.findViewById(R.id.study_scrollview);
    }

    private void setListener() {
        studySearchDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.study_search_detail:
                // TODO 할 때마다 생성하는거냐 극도의 비효율
                FragmentManager fm = getActivity().getFragmentManager();
                NormalFilterDialog dialog = NormalFilterDialog.newInstance(Const.Custom.STUDY_TYPE_FILTER);
                dialog.show(fm, "");
                break;
        }
    }

    private void setFavoriteRecycler() {
        favoriteListAdapter = new StudyFavoriteListAdapter();
        favoriteStudyRecyclerView.setAdapter(favoriteListAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        favoriteStudyRecyclerView.setNestedScrollingEnabled(false);
        favoriteStudyRecyclerView.setLayoutManager(llm);
    }

    private void setRecommendRecycler() {
        recommendListAdapter = new StudyRecommendListAdapter();
        recommendStudyRecyclerView.setAdapter(recommendListAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommendStudyRecyclerView.setNestedScrollingEnabled(false);
        recommendStudyRecyclerView.setLayoutManager(llm);
    }

    private void setByRegionRecycler() {
        byRegionAdapter = new StudyByRegionListAdapter(this);
        studyByRegionRecyclerView.setAdapter(byRegionAdapter);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        studyByRegionRecyclerView.setHasFixedSize(true);
        studyByRegionRecyclerView.setNestedScrollingEnabled(false);
//        studyByRegionRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                switch (e.getAction()) {
////                    case MotionEvent.ACTION_DOWN:
//                    case MotionEvent.ACTION_MOVE:
////                        studyByRegionRecyclerView.setNestedScrollingEnabled(false);
//                        rv.getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//                }
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        /*studyByRegionRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        studyByRegionRecyclerView.setNestedScrollingEnabled(true);
                        break;
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/
        studyByRegionRecyclerView.setLayoutManager(glm);
    }

    private void setByCategoryRecycler() {
        byCategoryAdapter = new StudyByCategoryListAdapter(this);
        studyByCategoryRecyclerView.setAdapter(byCategoryAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        studyByCategoryRecyclerView.setNestedScrollingEnabled(false);
//        studyByCategoryRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                switch (e.getAction()) {
//                    case MotionEvent.ACTION_MOVE:
//                        studyByCategoryRecyclerView.setNestedScrollingEnabled(false);
//                        rv.getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//                }
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        studyByCategoryRecyclerView.setLayoutManager(llm);
    }

//    private void setFAB() {
//        FloatingActionButton fab =  view.findViewById(R.id.fab);
//        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
//        p.setBehavior(new ScrollAwareFabBehavior());
//        fab.setLayoutParams(p);
//    }

    private void setStudyListAdapter() {
        studyListAdapter = new StudyListAdapter();
        studyListRecycler.setAdapter(studyListAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        studyListRecycler.setNestedScrollingEnabled(false);
        studyListRecycler.setLayoutManager(llm);

    }

    public void switchView() {
        if (layoutStudyContentList1.getVisibility() == View.VISIBLE && layoutStudyContentList2.getVisibility() == View.VISIBLE) {
            layoutStudyContentList1.setVisibility(View.GONE);
            layoutStudyContentList2.setVisibility(View.GONE);
            layoutStudyContentList3.setVisibility(View.VISIBLE);
            // TODO 왜 RecyclerView 는 안 되는거니?
            studyListRecycler.scrollToPosition(1);
            studyScrollview.scrollTo(0, studyScrollview.getTop());
        }
//        else {
//            layoutStudyContentList1.setVisibility(View.VISIBLE);
//            layoutStudyContentList2.setVisibility(View.VISIBLE);
//            layoutStudyContentList3.setVisibility(View.GONE);
//        }
    }

    public void onBackPressed() {
        if (layoutStudyContentList1.getVisibility() != View.VISIBLE && layoutStudyContentList2.getVisibility() != View.VISIBLE) {
            layoutStudyContentList1.setVisibility(View.VISIBLE);
            layoutStudyContentList2.setVisibility(View.VISIBLE);
            layoutStudyContentList3.setVisibility(View.GONE);
        } else {
            Log.e("확인", "취소");
            getActivity().onBackPressed();
        }
    }

//    public interface OnStudyFragmentInteraction {
//        void back();
//    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if(context instanceof OnStudyFragmentInteraction) {
//            ISFInteraction = (OnStudyFragmentInteraction) context;
//        } else {
//            throw new RuntimeException(context.toString() + "must implement OnStudyFragmentInteraction");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
