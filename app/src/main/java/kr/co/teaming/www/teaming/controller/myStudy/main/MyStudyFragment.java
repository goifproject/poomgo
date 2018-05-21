package kr.co.teaming.www.teaming.controller.myStudy.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;

public class MyStudyFragment extends Fragment {

    private View view;
    private RecyclerView mystudyRecyclerView;
    private MyStudyAdapter myStudyAdapter;

    public static MyStudyFragment newInstance(String param1, String param2) {
        MyStudyFragment fragment = new MyStudyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_study, container, false);
        init();
        return view;
    }

    private void init() {
        initView();
        setMystudyRecyclerView();
    }

    private void initView() {
        mystudyRecyclerView = view.findViewById(R.id.mystudyRecyclerView);
    }

    private void setMystudyRecyclerView() {
        myStudyAdapter = new MyStudyAdapter();
        mystudyRecyclerView.setAdapter(myStudyAdapter);
        mystudyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
