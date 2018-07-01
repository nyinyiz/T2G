package com.nwt.recyglo_shop.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.nwt.recyglo_shop.R;
import com.nwt.recyglo_shop.data.models.AppModel;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btn_junk_shop)
    TextView btnJunkShop;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_junk_shop)
    void onTapJunkShop() {
        dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        dialog.show();
        getAppModel().startLoadingUsers(getApplicationContext(), check -> getAppModel().startLoadingWastItem(getApplicationContext(), check1 -> getAppModel().startLoadingNews(getApplicationContext(), check2 -> getAppModel().startLoadingShops(getApplicationContext(), check3 -> {

            if (check3) {
                getAppModel().startLoadingNotification(getApplicationContext(), check4 -> {
                    if (check4) {
                        startActivity(MainActivity.getIntent(getApplicationContext()));
                        dialog.dismiss();
                    }
                });
            }
        }))));


    }

    @OnClick(R.id.btn_user)
    void onTapUser() {

        dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        dialog.show();

        getAppModel().startLoadingUsers(getApplicationContext(), check -> getAppModel().startLoadingWastItem(getApplicationContext(), check1 -> getAppModel().startLoadingNews(getApplicationContext(), check2 -> getAppModel().startLoadingShops(getApplicationContext(), check3 -> {

            if (check3) {
                getAppModel().startLoadingNotification(getApplicationContext(), check4 -> {
                    if (check4) {
                        startActivity(UserActivity.getIntent(this));
                        dialog.dismiss();
                    }
                });
            }

        }))));

    }

}
