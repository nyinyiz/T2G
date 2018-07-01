package com.nwt.recyglo_shop.delegate;

import android.content.Context;

public interface CallBuyerView {

    Context getContext();

    void showUploadedNewsPhoto(String photoPath);

    void showErrorMessage(String msg);

}
