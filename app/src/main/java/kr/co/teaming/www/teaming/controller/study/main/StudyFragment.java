package kr.co.teaming.www.teaming.controller.study.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyByCategoryListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyByRegionListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyFavoriteListAdapter;
import kr.co.teaming.www.teaming.controller.study.main.adapter.StudyRecommendListAdapter;
import kr.co.teaming.www.teaming.custom.ScrollAwareFabBehavior;

public class StudyFragment extends Fragment {


//    @BindView(R.id.favoriteStudyRecyclerView)
//    private RecyclerView favoriteStudyRecyclerView;
//    @BindView(R.id.recommendStudyRecyclerView)
//    private RecyclerView recommendStudyRecyclerView;
//    @BindView(R.id.studyByRegionRecyclerView)
//    private RecyclerView studyByRegionRecyclerView;
//    @BindView(R.id.studyByCategoryRecyclerView)
//    private RecyclerView studyByCategoryRecyclerView;

    private StudyByRegionListAdapter byRegionAdapter;
    private StudyByCategoryListAdapter byCategoryAdapter;
    private StudyFavoriteListAdapter favoriteListAdapter;
    private StudyRecommendListAdapter recommendListAdapter;
    private RecyclerView favoriteStudyRecyclerView;
    private RecyclerView recommendStudyRecyclerView;
    private RecyclerView studyByRegionRecyclerView;
    private RecyclerView studyByCategoryRecyclerView;
    private View view;
    private EditText studySearchInput;

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
        setFavoriteRecycler();
        setRecommendRecycler();
        setByRegionRecycler();
        setByCategoryRecycler();
    }

    private void initView() {
        favoriteStudyRecyclerView = (RecyclerView) view.findViewById(R.id.favoriteStudyRecyclerView);
        recommendStudyRecyclerView = (RecyclerView) view.findViewById(R.id.recommendStudyRecyclerView);
        studyByRegionRecyclerView = (RecyclerView) view.findViewById(R.id.studyByRegionRecyclerView);
        studyByCategoryRecyclerView = (RecyclerView) view.findViewById(R.id.studyByCategoryRecyclerView);
        studySearchInput = (EditText) view.findViewById(R.id.study_search_input);
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
        byRegionAdapter = new StudyByRegionListAdapter(getContext());
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
        byCategoryAdapter = new StudyByCategoryListAdapter(getContext());
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
