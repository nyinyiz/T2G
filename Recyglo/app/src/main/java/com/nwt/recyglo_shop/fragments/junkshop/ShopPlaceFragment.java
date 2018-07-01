package com.nwt.recyglo_shop.fragments.junkshop;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.adapters.ShopPlaceRecyclerAdapter;
import com.nwt.recyglo_shop.components.rvset.SmartRecyclerView;
import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.data.vos.UserVO;
import com.nwt.recyglo_shop.delegate.ShopDelegate;
import com.nwt.recyglo_shop.fragments.BaseFragment;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.nio.file.Path;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("ValidFragment")
public class ShopPlaceFragment extends BaseFragment implements ShopDelegate {

    @BindView(R.id.btn_north)
    TextView btnNorth;
    @BindView(R.id.btn_east)
    TextView btnEast;
    @BindView(R.id.btn_south)
    TextView btnSouth;
    @BindView(R.id.btn_west)
    TextView btnWest;
    @BindView(R.id.rv_view)
    SmartRecyclerView rvView;


    private Context context;
    private ShopPlaceRecyclerAdapter mAdapter;
    private UserVO mUserVO;


    public ShopPlaceFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_place,container,false);
        ButterKnife.bind(this,view);

//        getAppModel().getAllUser().observe(this, userVOS -> {
//            mUserVO = userVOS.get(0);
//            String[] locations = mUserVO.pickup_service_location.split(",");
//            if (locations.length ==2 ){
//                btnEast.setText(locations[0]);
//                btnNorth.setText(locations[1]);
//                btnSouth.setVisibility(View.GONE);
//                btnWest.setVisibility(View.GONE);
//            }
//        });




        setUpRecyclerView();

        return view;
    }

    private void setUpRecyclerView() {
        mAdapter = new ShopPlaceRecyclerAdapter(context,this);
        rvView.setLayoutManager(new GridLayoutManager(context,2));
        rvView.setAdapter(mAdapter);

        getAppModel().getShopByTownshipTag("sd").observe(this, shopsVOS -> mAdapter.setNewData(shopsVOS));
    }

    @OnClick(R.id.btn_north)
    void onTapNorth() {
        btnNorth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_primary));

        btnEast.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnSouth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnWest.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));

        getAppModel().getShopByTownshipTag("sd").observe(this, shopsVOS ->
                mAdapter.setNewData(shopsVOS));
    }

    @OnClick(R.id.btn_east)
    void onTapEast() {
        btnEast.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_primary));

        btnNorth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnSouth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnWest.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));

        getAppModel().getShopByTownshipTag("sd").observe(this, shopsVOS ->
                mAdapter.setNewData(shopsVOS));

    }

    @OnClick(R.id.btn_south)
    void onTapSouth() {
        btnSouth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_primary));

        btnNorth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnEast.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnWest.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));

        getAppModel().getShopByTownshipTag("sd").observe(this, shopsVOS -> mAdapter.setNewData(shopsVOS));
    }

    @OnClick(R.id.btn_west)
    void onTapWest() {
        btnWest.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_primary));

        btnNorth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnSouth.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));
        btnEast.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_round_button_grey));

        getAppModel().getShopByTownshipTag("sd").observe(this, shopsVOS -> mAdapter.setNewData(shopsVOS));
    }

    @Override
    public void onTapShopItem(ShopsVO shopsVO) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.alert_dialog_view_shop, null);
        MMTextView tvShopName = view.findViewById(R.id.tv_shop_name);
        MMTextView tvAddress = view.findViewById(R.id.tv_address);
        TextView btnClose = view.findViewById(R.id.btn_close);

        tvShopName.setText(shopsVO.shop_name);
        tvAddress.setText(shopsVO.address);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view);
        final AlertDialog alert = builder.create();

        btnClose.setOnClickListener(view1 -> {
           alert.dismiss();
        });

        alert.show();
    }
}

