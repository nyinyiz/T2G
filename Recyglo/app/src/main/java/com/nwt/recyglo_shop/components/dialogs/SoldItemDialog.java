package com.nwt.recyglo_shop.components.dialogs;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.adapters.SoldItemDetailRecyclerAdapter;
import com.nwt.recyglo_shop.adapters.SoldItemRecyclerAdapter;
import com.nwt.recyglo_shop.components.rvset.SmartRecyclerView;
import com.nwt.recyglo_shop.data.models.AppModel;
import com.nwt.recyglo_shop.data.models.AppViewModelFactory;
import com.nwt.recyglo_shop.data.vos.ItemList;
import com.nwt.recyglo_shop.data.vos.UserVO;
import com.nwt.recyglo_shop.data.vos.Voucherlist;
import com.nwt.recyglo_shop.delegate.SoldItemDelegate;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nyi on 2/6/18.
 */

public class SoldItemDialog extends DialogFragment {

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_shop_owner)
    MMTextView tvShopOwner;
    @BindView(R.id.tv_total)
    MMTextView tvTotal;

    @BindView(R.id.rv_view)
    SmartRecyclerView rvView;

    private SoldItemDetailRecyclerAdapter mAdapter;
    public static Voucherlist mVoucher;

    public static SoldItemDialog newInstance(Voucherlist voucherlist) {
        mVoucher = voucherlist;
        return new SoldItemDialog();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_sold_item, container, false);
        ButterKnife.bind(this, view);
        setUpRecyclerView();

        tvDate.setText(mVoucher.date);
        AppModel model = ViewModelProviders.of(this, new AppViewModelFactory(getContext())).get(AppModel.class);
        UserVO userVO = model.getUserByUserId(mVoucher.buyer_id+"");
        tvShopOwner.setText("( "+userVO.township+" )"+userVO.name);
        tvTotal.setText(mVoucher.service_charges+" ကျပ်");

        return view;
    }

    private void setUpRecyclerView() {
        mAdapter = new SoldItemDetailRecyclerAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvView.setLayoutManager(linearLayoutManager);
        rvView.setAdapter(mAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation());
        rvView.addItemDecoration(decoration);
        mAdapter.setNewData(mVoucher.item_list);
    }

}
