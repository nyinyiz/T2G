package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.ItemList;
import com.nwt.recyglo_shop.data.vos.JunkVO;
import com.nwt.recyglo_shop.viewholder.SoldItemDetailViewHolder;

public class SoldItemDetailRecyclerAdapter extends BaseRecyclerAdapter<SoldItemDetailViewHolder,ItemList> {

    public SoldItemDetailRecyclerAdapter(Context context) {
        super(context);

    }

    @NonNull
    @Override
    public SoldItemDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_view_sold_item_detail,parent,false);
        return new SoldItemDetailViewHolder(view);
    }
}
