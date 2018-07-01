package com.nwt.recyglo_shop.viewholder;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.view.View;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.db.AppDatabase;
import com.nwt.recyglo_shop.data.models.AppModel;
import com.nwt.recyglo_shop.data.models.AppViewModelFactory;
import com.nwt.recyglo_shop.data.vos.ItemList;
import com.nwt.recyglo_shop.data.vos.JunkVO;
import com.nwt.recyglo_shop.data.vos.WastItemVO;
import com.nwt.recyglo_shop.delegate.SoldItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;

public class SoldItemDetailViewHolder extends BaseViewHolder<ItemList> {

    @BindView(R.id.tv_waste_name)
    MMTextView tvWastName;
    @BindView(R.id.tv_waste_price)
    MMTextView tvWastPrice;

    public SoldItemDetailViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Context context) {
        AppDatabase mAppDatabase = AppDatabase.getInMemoryDatabase(context);
        WastItemVO wastItemVO = mAppDatabase.wastDao().getWastItemVOByWastNo(mData.waste_id+"");

        tvWastName.setText(wastItemVO.item_name);
        tvWastPrice.setText(wastItemVO.item_price+" ကျပ်");
    }

    @Override
    public void onClick(View view) {
    }
}
