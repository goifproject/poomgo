package kr.co.teaming.www.teaming.custom.filterDialog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.teaming.www.teaming.R;
import kr.co.teaming.www.teaming.custom.filterDialog.NormalFilterDialog;

public class SubFilterAdapter extends RecyclerView.Adapter<SubFilterAdapter.ViewHolder> {

    // TODO GuFilter -> SubFilterFilter

    //    private Context mContext;
//    private Context resContext;
    private String[] subFilterArray;
//    private String[] primaryFilterArray;

    private NormalFilterDialog dialogFragment;
    private int selectedPosition;


    public SubFilterAdapter(NormalFilterDialog dialogFragment) {
        this.dialogFragment = dialogFragment;
        setSubFilter(0, 0);
    }

    // TODO idenfiter로 바꿀 것. 코드가 너무 복잡함.
    // TODO Const로 전부 바꾸고, 데이터베이스 짜야 할 듯, 너무 복잡함
    public void setSubFilter(int filterType, int primaryFilter) {
//        if (primaryFilterArray == null) {
//            primaryFilterArray = dialogFragment.getResources().getStringArray(R.array.region);
//        }
        // TODO 이거 어떻게 해야 할 듯 너무 복잡한데
        switch (filterType) {
            case 0:
                sortRegion(primaryFilter);
                break;
            case 1:
                sortCategory(primaryFilter);
                break;
            case 2:
                sortTime(primaryFilter);
                break;
            case 3:
                sortAge(primaryFilter);
                break;
            case 4:
                sortCount(primaryFilter);
                break;
        }
        selectedPosition = 0;

//        int id = filterDialog.getResources().getIdentifier("sub_" + regionArray[region], "arrays", filterDialog.getActivity().getPackageName());
//        Log.e("아이디", id+"");
//        subRegionArray = filterDialog.getResources().getStringArray(id);

//        if (resContext == null) {
//            try {
//                resContext = filterDialog.getActivity().createPackageContext(filterDialog.getActivity().getPackageName(), 0);
//            } catch (PackageManager.NameNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        Resources res = resContext.getResources();
//        int id = res.getIdentifier("sub_" + regionArray[region], "arrays", filterDialog.getActivity().getPackageName());
//        Log.e("아이디", "sub_" + regionArray[region]);
//        Log.e("아이디", id+"");
//        subRegionArray = filterDialog.getResources().getStringArray(id);
        notifyDataSetChanged();

//
//        if(region == "" || region.equals("")) {
//            subRegionArray = new String[0];
//        } else {
////        if(resContext == null) resContext = mContext.createPackageContext(mContext.getPackageName(), 0);
////        Resources res = resContext.getResources();
//            int id = filterDialog.getResources().getIdentifier("sub"+region, "arrays" ,filterDialog.getActivity().getPackageName());
//            subRegionArray = filterDialog.getResources().getStringArray(id);
//            notifyDataSetChanged();
//        }
    }

    private void sortRegion(int primaryFilter) {
        switch (primaryFilter) {
            case 0:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_seoul);
                break;
            case 1:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_busan);
                break;
            case 2:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_daegu);
                break;
            case 3:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_incheon);
                break;
            case 4:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_gwangju);
                break;
            case 5:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_daejeon);
                break;
            case 6:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_ulsan);
                break;
            case 7:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_sejong);
                break;
            case 8:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_gyeonggi);
                break;
            case 9:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_gangwon);
                break;
            case 10:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_choongbuk);
                break;
            case 11:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_choongnam);
                break;
            case 12:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_jeonbuk);
                break;
            case 13:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_jeonnam);
                break;
            case 14:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_gyeongbuk);
                break;
            case 15:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_gyeongnam);
                break;
            case 16:
                subFilterArray = dialogFragment.getResources().getStringArray(R.array.sub_jeju);
                break;
        }

    }

    private void sortCategory(int primaryFilter){
        subFilterArray = new String[0];
    }

    private void sortTime(int primaryFilter){
        subFilterArray = new String[0];
    }

    private void sortAge(int primaryFilter){
        subFilterArray = new String[0];
    }

    private void sortCount(int primaryFilter){
        subFilterArray = new String[0];
    }

    @Override
    public SubFilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_sub_filter, parent, false);
        return new SubFilterAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SubFilterAdapter.ViewHolder holder, int position) {
        holder.subFilterText.setText(subFilterArray[position]);
        holder.position = position;
        if(selectedPosition == position) {
            holder.subFilterText.setTextColor(dialogFragment.getResources().getColor(R.color.color_text_dark));
        } else {
            holder.subFilterText.setTextColor(dialogFragment.getResources().getColor(android.R.color.secondary_text_dark));
        }
    }

    @Override
    public int getItemCount() {
        return subFilterArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView subFilterText;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            subFilterText = itemView.findViewById(R.id.item_dialog_sub_filter_text);
            subFilterText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogFragment.setSubFilter(position);
                    selectedPosition = position;
                    notifyDataSetChanged();
                }
            });
        }
    }
}