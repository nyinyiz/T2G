package com.nwt.recyglo_shop.delegate;

import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.data.vos.UserVO;

public interface NotificationDelegate {
    void onTapAccept(NotificationVO notificationVO);
    void onTapReject(NotificationVO notificationVO);
}
