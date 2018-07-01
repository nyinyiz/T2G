package com.nwt.recyglo_shop.fragments.user;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.adapters.SoldItemRecyclerAdapter;
import com.nwt.recyglo_shop.components.dialogs.SoldItemDialog;
import com.nwt.recyglo_shop.components.rvset.SmartRecyclerView;
import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.data.vos.Voucherlist;
import com.nwt.recyglo_shop.delegate.SoldItemDelegate;
import com.nwt.recyglo_shop.fragments.BaseFragment;
import com.nwt.recyglo_shop.utils.AlertDialogUtils;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("ValidFragment")
public class ItemUploadFragment extends BaseFragment implements SoldItemDelegate{

    @BindView(R.id.rv_view)
    SmartRecyclerView rvView;

    private Context context;
    private SoldItemRecyclerAdapter mAdapter;
    private ShopsVO mShopVO;
    String key;

    public ItemUploadFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_item_upload,container,false);
        ButterKnife.bind(this,view);

        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {
        mAdapter = new SoldItemRecyclerAdapter(context,this);
        rvView.setLayoutManager(new GridLayoutManager(context,2));
        rvView.setAdapter(mAdapter);
        mShopVO = getAppModel().getShopById("1");
        mAdapter.setNewData(mShopVO.voucherlist);
    }

    @Override
    public void onTapSoldItem(Voucherlist voucherlist) {
        SoldItemDialog fragment = SoldItemDialog.newInstance(voucherlist);
        fragment.show(getFragmentManager(),"profile");
    }

    @OnClick(R.id.btn_notify)
    void onTapBtnNotify() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("၄၈ နာရီအတြင္း အနီးဆံုုး၀ယ္သူမ်ားႏွင့္ ခ်ိတ္ဆက္ေပးပါမည္။");

        builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getAppModel().publishNotification(new Date().toString(),mShopVO.shop_name);

                dialogInterface.dismiss();
            }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();

    }


    @OnClick(R.id.btn_chat_operator)
    void onTapCallOperator() {
        send_page();
    }

    private void send_page() {

        if (isPackageExisted("com.facebook.orca")) {
            Uri uri = Uri.parse("fb-messenger://user/");
            uri = ContentUris.withAppendedId(uri, Long.parseLong("436508100130889"));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "Please install facebook messenger", Toast.LENGTH_LONG).show();
        }
    }


    public boolean isPackageExisted(String targetPackage) {
        PackageManager pm = getContext().getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }

}
