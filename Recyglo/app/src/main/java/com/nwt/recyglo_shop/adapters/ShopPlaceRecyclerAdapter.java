package com.nwt.recyglo_shop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.ShopPlaceVO;
import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.delegate.ShopDelegate;
import com.nwt.recyglo_shop.viewholder.ShopPlaceViewHolder;

public class ShopPlaceRecyclerAdapter extends BaseRecyclerAdapter<ShopPlaceViewHolder,ShopsVO>{

    private ShopDelegate mDelegate;

    public ShopPlaceRecyclerAdapter(Context context, ShopDelegate delegate) {
        super(context);
        mDelegate = delegate;
    }

    @NonNull
    @Override
    public ShopPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_view_shop_place,parent,false);
        return new ShopPlaceViewHolder(view,mDelegate);
    }

}
