package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.WastItemVO;
import com.nwt.recyglo_shop.viewholder.WastItemPriceListViewHolder;

public class WastItemPriceListRecyclerAdapter extends BaseRecyclerAdapter<WastItemPriceListViewHolder,WastItemVO> {

    public WastItemPriceListRecyclerAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public WastItemPriceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = mLayoutInflator.inflate(R.layout.item_view_wast,parent,false);
        return new WastItemPriceListViewHolder(view);
    }

}
