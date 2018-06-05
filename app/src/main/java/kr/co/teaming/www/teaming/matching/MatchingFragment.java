package kr.co.teaming.www.teaming.matching;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.matching.adapters.MatchingClipListAdapter;
import kr.co.teaming.www.teaming.matching.adapters.MatchingFieldListAdapter;
import kr.co.teaming.www.teaming.matching.adapters.MatchingRecommendListAdapter;
import kr.co.teaming.www.teaming.matching.adapters.MatchingRegionListAdapter;


public class MatchingFragment extends Fragment {

    private View view;
    private OnFragmentInteractionListener mListener;
    private MatchingRecommendListAdapter recommendListAdapter;
    private MatchingClipListAdapter clipListAdapter;
    private MatchingRegionListAdapter regionListAdapter;
    private MatchingFieldListAdapter fieldListAdapter;
    private RecyclerView recommendRecyclerView;
    private RecyclerView clipRecyclerView;
    private RecyclerView regionRecyclerView;
    private RecyclerView fieldRecyclerView;

    public MatchingFragment() {
        // Required empty public constructor
    }

    public static MatchingFragment newInstance(String param1, String param2){
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void init() {
        initView();
        setRecommendRecyclerView();
        setClipRecyclerView();
        setRegionRecyclerView();
        setFieldRecyclerView();
    }

    private void initView() {
        recommendRecyclerView = view.findViewById(R.id.matching_recommend_recyclerview);
        clipRecyclerView = view.findViewById(R.id.matching_clip_recyclerview);
        regionRecyclerView = view.findViewById(R.id.matching_region_recyclerview);
        fieldRecyclerView = view.findViewById(R.id.matching_field_recyclerview);
    }

    private void setRecommendRecyclerView() {
        recommendListAdapter = new MatchingRecommendListAdapter();
        recommendRecyclerView.setAdapter(recommendListAdapter);
        recommendRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void setClipRecyclerView(){
        clipListAdapter = new MatchingClipListAdapter();
        clipRecyclerView.setAdapter(clipListAdapter);
        clipRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void setRegionRecyclerView(){
        regionListAdapter = new MatchingRegionListAdapter();
        regionRecyclerView.setAdapter(regionListAdapter);
        regionRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    private void setFieldRecyclerView(){
        fieldListAdapter = new MatchingFieldListAdapter();
        fieldRecyclerView.setAdapter(fieldListAdapter);
        fieldRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }



}

