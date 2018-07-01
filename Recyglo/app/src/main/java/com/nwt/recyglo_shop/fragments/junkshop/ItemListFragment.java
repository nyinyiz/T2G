package com.nwt.recyglo_shop.fragments.junkshop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.adapters.WastItemPriceListRecyclerAdapter;
import com.nwt.recyglo_shop.components.rvset.SmartRecyclerView;
import com.nwt.recyglo_shop.fragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class ItemListFragment extends BaseFragment {

    @BindView(R.id.rv_view)
    SmartRecyclerView rvView;

    private Context mContext;
    private WastItemPriceListRecyclerAdapter mAdapter;

    public ItemListFragment(Context context) {
        mContext = context;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list,container,false);
        ButterKnife.bind(this,view);

        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {
        mAdapter = new WastItemPriceListRecyclerAdapter(mContext);
        rvView.setLayoutManager(new LinearLayoutManager(mContext));
        rvView.setAdapter(mAdapter);
        getAppModel().getWastItem().observe(this, wastItemVOS -> {
            mAdapter.setNewData(wastItemVOS);

        });
    }
}
