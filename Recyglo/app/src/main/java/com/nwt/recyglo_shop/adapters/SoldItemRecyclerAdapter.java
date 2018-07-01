package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.JunkVO;
import com.nwt.recyglo_shop.data.vos.Voucherlist;
import com.nwt.recyglo_shop.delegate.SoldItemDelegate;
import com.nwt.recyglo_shop.viewholder.SoldItemViewHolder;

public class SoldItemRecyclerAdapter extends BaseRecyclerAdapter<SoldItemViewHolder,Voucherlist> {

    private SoldItemDelegate delegate;
    public SoldItemRecyclerAdapter(Context context, SoldItemDelegate delegate) {
        super(context);
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public SoldItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_view_sold_item,parent,false);
        return new SoldItemViewHolder(view,delegate);
    }

}
