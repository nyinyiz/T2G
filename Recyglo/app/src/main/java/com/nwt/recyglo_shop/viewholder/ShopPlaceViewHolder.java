package com.nwt.recyglo_shop.viewholder;

import android.content.Context;
import android.view.View;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.ShopPlaceVO;
import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.delegate.ShopDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;

public class ShopPlaceViewHolder extends BaseViewHolder<ShopsVO> {

    @BindView(R.id.tv_shop_name)
    MMTextView tvShopName;
    @BindView(R.id.tv_township)
    MMTextView tvTownship;

    private ShopDelegate mDelegate;

    public ShopPlaceViewHolder(View itemView, ShopDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
    }

    @Override
    public void bind(Context context) {
        tvShopName.setText(mData.shop_name);
        tvTownship.setText(mData.township);
    }

    @Override
    public void onClick(View view) {
        mDelegate.onTapShopItem(mData);
    }
}
