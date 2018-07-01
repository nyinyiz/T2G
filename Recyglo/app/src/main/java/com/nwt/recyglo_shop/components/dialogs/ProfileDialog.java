package com.nwt.recyglo_shop.components.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nwt.recyglo_shop.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nyi on 2/6/18.
 */

public class ProfileDialog extends DialogFragment {

    public static ProfileDialog newInstance() {

        return new ProfileDialog();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_profile, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btn_close) void onTapClose() {
        dismiss();
    }
}
