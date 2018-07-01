package com.nwt.recyglo_shop.fragments.junkshop;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.activities.MainActivity;
import com.nwt.recyglo_shop.adapters.NotificationRecyclerAdapter;
import com.nwt.recyglo_shop.components.rvset.SmartRecyclerView;
import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.data.vos.UserVO;
import com.nwt.recyglo_shop.delegate.NotificationDelegate;
import com.nwt.recyglo_shop.fragments.BaseFragment;

import net.aungpyaephyo.mmtextview.components.MMRadioButton;
import net.aungpyaephyo.mmtextview.components.MMTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.NOTIFICATION_SERVICE;

@SuppressLint("ValidFragment")
public class NotificationFragment extends BaseFragment implements NotificationDelegate{
    @BindView(R.id.rv_view)
    SmartRecyclerView rvView;

    private static int NOTIFICATION_ID = 0;


    private Context context;
    private NotificationRecyclerAdapter mAdapter;

    public NotificationFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        ButterKnife.bind(this,view);

        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {

        mAdapter = new NotificationRecyclerAdapter(context,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        rvView.setLayoutManager(linearLayoutManager);
        rvView.setAdapter(mAdapter);
        DividerItemDecoration decoration = new DividerItemDecoration(context,linearLayoutManager.getOrientation());
        rvView.addItemDecoration(decoration);

        getAppModel().getNotification().observe(this, notificationVOS -> {
            mAdapter.setNewData(notificationVOS);
            if (notificationVOS.size() > 0) {
                addNotification("RecyGlo",notificationVOS.get(notificationVOS.size()-1).notification_title);
            }

        });
    }

    @Override
    public void onTapAccept(NotificationVO notificationVO) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.alert_dialog_view_notification_accept, null);
        TextView tvShopName = view.findViewById(R.id.tv_shop_name);
        MMTextView tvAddress = view.findViewById(R.id.tv_address);
        TextView btnClose = view.findViewById(R.id.btn_close);
        RadioGroup radioGroup = view.findViewById(R.id.radio_g);

        MMRadioButton radioButton;

        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = view.findViewById(selectedId);

        tvShopName.setText("ေကာင္းျကြယ္ Tea Shop");
        tvAddress.setText("123,mya street,South Dagon Yangon");

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view);
        final AlertDialog alert = builder.create();

        btnClose.setOnClickListener(view1 -> {
            alert.dismiss();
        });

        alert.show();

    }

    @Override
    public void onTapReject(NotificationVO notificationVO) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);

        builder1.setMessage("သတိေပးစာ");
        builder1.setPositiveButton("ဖ်က္မည္", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getAppModel().updateNotificationById(notificationVO.mId.toString(),"h");
                dialogInterface.dismiss();
            }
        });


        builder1.setNegativeButton("မဖ်က္ပာ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    private void addNotification(String title,String body)
    {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.drawable.ic_notifications_active_white_24dp)
                        .setContentTitle(title)   //this is the title of notification
                        .setColor(101)
                        .setContentText(body);   //this is the message showed in notification
        Uri sound = Uri.parse("android.resource://" + context.getPackageName() + "/raw/slow_spring");
        builder.setSound(sound);

        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);
        builder.setContentIntent(contentIntent);
        // Add as notification
        NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

}
