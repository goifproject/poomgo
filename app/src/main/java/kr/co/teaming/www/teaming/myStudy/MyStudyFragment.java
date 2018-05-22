package kr.co.teaming.www.teaming.myStudy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.notice.NoticeFragmentAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyStudyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyStudyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyStudyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView ListrecyclerView;
    RecyclerView.LayoutManager ListlayoutManager;

    MyStudyFragmentAdapter adapter;

    RecyclerView ListingRecyclerView;
    RecyclerView.LayoutManager ListingLayoutManager;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MyStudyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyStudyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyStudyFragment newInstance(String param1, String param2) {
        MyStudyFragment fragment = new MyStudyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_study, container, false);

        adapter = new MyStudyFragmentAdapter();

        ListrecyclerView = view.findViewById(R.id.mystudy_list_recyclerview);
        ListlayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        ListrecyclerView.setLayoutManager(ListlayoutManager);
        ListrecyclerView.setAdapter(adapter);


        ListingRecyclerView = view.findViewById(R.id.mystudy_listing_recycler);
        ListingLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        ListingRecyclerView.setLayoutManager(ListingLayoutManager);
        ListingRecyclerView.setAdapter(adapter);

        adapter.setItemClick(new NoticeFragmentAdapter.ItemClick() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(getActivity(), MyStudyDetailsActivity.class);
                startActivity(intent);
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
