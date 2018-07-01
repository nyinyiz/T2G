package com.nwt.recyglo_shop.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.nwt.recyglo_shop.data.models.AppModel;
import com.nwt.recyglo_shop.data.models.AppViewModelFactory;

/**
 * Created by nyi on 12/2/17.
 */

public abstract class BaseFragment extends Fragment {
    AppModel mAppModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppModel = ViewModelProviders.of(this, new AppViewModelFactory(getContext())).get(AppModel.class);

    }

    public AppModel getAppModel() {
        return mAppModel;
    }

}
