package com.nwt.recyglo_shop.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.vos.WastItemVO;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;

public class WastItemPriceListViewHolder extends BaseViewHolder<WastItemVO> {

    @BindView(R.id.iv_wast)
    ImageView ivWast;
    @BindView(R.id.tv_wast)
    MMTextView tvWast;
    @BindView(R.id.tv_price)
    MMTextView tvPrice;
    @BindView(R.id.tv_diff)
    MMTextView tvDiff;

    public WastItemPriceListViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Context context) {
        tvWast.setText(mData.item_name);
        tvPrice.setText(mData.item_price);
        tvDiff.setText(mData.pricing_differential);

        Glide.with(itemView.getContext())
                .load(Uri.parse(mData.getFile(mData.item_image_url)))
                .apply(new RequestOptions().placeholder(R.drawable.logo_place_holder))
                .into(ivWast);
    }

    @Override
    public void onClick(View view) {

    }
}
