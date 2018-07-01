package com.nwt.recyglo_shop.data.models;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by sherly on 3/10/18.
 */

public class AppViewModelFactory implements ViewModelProvider.Factory {

    private final Context useCase;

    @Inject
    public AppViewModelFactory(Context useCase) {
        this.useCase = useCase;
    }

    @NonNull
    @Override
    public AppModel create(@NonNull Class modelClass) {
        return new AppModel(useCase);
    }
}