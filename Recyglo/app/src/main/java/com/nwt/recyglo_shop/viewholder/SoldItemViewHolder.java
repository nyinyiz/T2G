package com.nwt.recyglo_shop.viewholder;

import android.content.Context;
import android.view.View;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.components.dialogs.ProfileDialog;
import com.nwt.recyglo_shop.data.vos.JunkVO;
import com.nwt.recyglo_shop.data.vos.Voucherlist;
import com.nwt.recyglo_shop.delegate.SoldItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;

public class SoldItemViewHolder extends BaseViewHolder<Voucherlist> {

    @BindView(R.id.tv_date)
    MMTextView tvDate;
    @BindView(R.id.tv_charges)
    MMTextView tvCharges;

    private SoldItemDelegate delegate;

    public SoldItemViewHolder(View itemView, SoldItemDelegate delegate) {
        super(itemView);
        this.delegate = delegate;
    }

    @Override
    public void bind(Context context) {
        tvDate.setText(mData.date);
        tvCharges.setText(mData.service_charges+" ကျပ်");
    }

    @Override
    public void onClick(View view) {
        delegate.onTapSoldItem(mData);
    }
}
