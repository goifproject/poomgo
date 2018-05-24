package kr.co.teaming.www.teaming.custom.filterDialog;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.custom.filterDialog.adapter.FilterTypeAdapter;
import kr.co.teaming.www.teaming.custom.filterDialog.adapter.PrimaryFilterAdapter;
import kr.co.teaming.www.teaming.custom.filterDialog.adapter.SubFilterAdapter;

public class NormalFilterDialog extends DialogFragment {

    // TODO 이름 통일하세요

    private View view;
    private EditText dialogFilterInputQuery;
    private RecyclerView dialogFilterTypeRecycler;
    private RecyclerView dialogPrimaryFilterRecycler;
    private RecyclerView dialogSubFilterRecycler;
    private FilterTypeAdapter filterTypeAdapter;
    private SubFilterAdapter subFilterAdapter;
    private PrimaryFilterAdapter primaryFilterAdapter;
    private TextView dialogFilterSearch;

    private OnNormalFilterDialogInteraction iNFDialog;

    private int filterType = 0;
    private int primaryFilter = 0;
    private int subFilter = 0;

    private static final String DIALOG_TYPE = "dialog_type";
    private int dialogType;

    public NormalFilterDialog() {

    }

    // newInstance로 하는 것과 그냥 생성하는 것의 차이는 무엇인가
    // 다이얼로그를 그대로 두 개 만들어야 하는지 파라미터를 받아서 코드를 줄여야 하는지
    // 어떻게 제거 해 주는가
    public static NormalFilterDialog newInstance(int param1) {
        NormalFilterDialog fragment = new NormalFilterDialog();
        Bundle args = new Bundle();
        args.putInt(DIALOG_TYPE, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogType = getArguments().getInt(DIALOG_TYPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_filter_normal, container, false);
        initView();
        setView();
        return view;
    }

    // di로 바꿀 것
    private void initView() {
        dialogFilterInputQuery = view.findViewById(R.id.dialog_filter_input_query);
        dialogFilterTypeRecycler = view.findViewById(R.id.dialog_filter_type_recycler);
        dialogPrimaryFilterRecycler = view.findViewById(R.id.dialog_primary_filter_recycler);
        dialogSubFilterRecycler = view.findViewById(R.id.dialog_sub_filter_recycler);
        dialogFilterSearch = view.findViewById(R.id.dialog_filter_search);
    }

    private void setView() {
        setListener();
        setFilterTypeRecycler();
        setSubFilterRecycler();
        setPrimaryFilterRecycler();
    }

    private void setListener() {
        dialogFilterSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNFDialog.setResult(filterType, primaryFilter, subFilter);
                NormalFilterDialog.this.dismiss();
            }
        });
    }

    // Interface로 바꿀 것
    private void setFilterTypeRecycler() {
        filterTypeAdapter = new FilterTypeAdapter(this, dialogType);
        dialogFilterTypeRecycler.setAdapter(filterTypeAdapter);
        dialogFilterTypeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setPrimaryFilterRecycler() {
        primaryFilterAdapter = new PrimaryFilterAdapter(this);
        dialogPrimaryFilterRecycler.setAdapter(primaryFilterAdapter);
        dialogPrimaryFilterRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setSubFilterRecycler() {
        subFilterAdapter = new SubFilterAdapter(this);
        dialogSubFilterRecycler.setAdapter(subFilterAdapter);
        dialogSubFilterRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void setFilterType(int filterType) {
        this.filterType = filterType;
        // 바꿀 때마다 0에 위치하도록 해준다
//        primaryFilter = 0;
        primaryFilterAdapter.setPrimaryFilter(filterType);
    }

    public void setPrimaryFilter(int primaryFilter) {
        this.primaryFilter = primaryFilter;
        // TODO 추가로 SubRegion 을 바꿔줘야
        subFilterAdapter.setSubFilter(filterType, primaryFilter);
    }

    public void setSubFilter(int subFilter) {
        this.subFilter = subFilter;
    }

    // TODO 어디에선가는 숫자로 바껴야 함
    public interface OnNormalFilterDialogInteraction {
        void setResult(int category, int region, int subRegion);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnNormalFilterDialogInteraction) {
            iNFDialog = (OnNormalFilterDialogInteraction) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnNormalFilterDialogInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        iNFDialog = null;
    }

}
