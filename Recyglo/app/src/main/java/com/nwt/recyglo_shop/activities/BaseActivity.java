package com.nwt.recyglo_shop.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nwt.recyglo_shop.data.models.AppModel;
import com.nwt.recyglo_shop.data.models.AppViewModelFactory;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private AppModel mAppModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this, this);

        mAppModel = ViewModelProviders.of(this, new AppViewModelFactory(this)).get(AppModel.class);
    }


    public AppModel getAppModel() {
        return mAppModel;
    }

    public abstract int getLayout();

    @Override
    protected void onStop() {
        super.onStop();
    }

}
