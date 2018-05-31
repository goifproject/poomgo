package kr.co.teaming.www.teaming.matching;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.matching.adapters.MatchingRecommendListAdapter;


public class MatchingFragment extends Fragment {

    private MatchingRecommendListAdapter recommendListAdapter;
    private RecyclerView recommendMatchingRecyclerView;
    private View view;

    public static MatchingFragment newInstance(String userId){
        MatchingFragment fragment = new MatchingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_matching, container, false);
        init();
        initView();
        return view;
    }

    private void init() {
        initView();
        setListener();
        setRecommendRecyclerView();
    }

    private void initView() {

    }

    private void setRecommendRecyclerView() {
    }

    private void setListener() {
    }

}

