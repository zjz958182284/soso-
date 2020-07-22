package com.example.sosocar;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sosocar.Entity.PoiAddressBean;

import java.util.List;

public class PoiKeywordSearchAdapter extends RecyclerView.Adapter<PoiKeywordSearchAdapter.MyViewHolder> {

    List<PoiAddressBean> poiAddressBean;
    Context mContext;
    public PoiKeywordSearchAdapter(Context context, List<PoiAddressBean> poiAddressBean) {
        this.poiAddressBean  = poiAddressBean;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_poi_search, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final PoiAddressBean poiAddressBean = this.poiAddressBean.get(position);
        holder.tv_detailAddress.setText(poiAddressBean.getDetailAddress());
        holder.tv_content.setText(poiAddressBean.getText());
        holder.ll_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((PoiSearchPage)mContext).setDetailAddress(poiAddressBean.getDetailAddress());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (poiAddressBean != null) {
            return poiAddressBean.size();
        } else {
            return 0;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView     tv_content;
        TextView     tv_detailAddress;
        LinearLayout ll_item_layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_detailAddress = (TextView) itemView.findViewById(R.id.tv_detailAddress);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            ll_item_layout = (LinearLayout) itemView.findViewById(R.id.ll_item_layout);
        }
    }
}