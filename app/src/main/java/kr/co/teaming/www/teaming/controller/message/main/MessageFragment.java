package kr.co.teaming.www.teaming.controller.message.main;

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

public class MessageFragment extends Fragment {

    private View view;
    private MessageAdapter messageAdapter;
    private RecyclerView messageRecyclerView;

    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        init();
        return view;
    }

    private void init() {
        initView();
        setMessageRecyclerView();
    }

    private void initView() {
        messageRecyclerView = view.findViewById(R.id.messageRecycler);
    }

    private void setMessageRecyclerView() {
        messageAdapter = new MessageAdapter();
        messageRecyclerView.setAdapter(messageAdapter);
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
