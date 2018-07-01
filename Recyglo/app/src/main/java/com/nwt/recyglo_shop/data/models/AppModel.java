package com.nwt.recyglo_shop.data.models;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.nwt.recyglo_shop.data.db.AppDatabase;
import com.nwt.recyglo_shop.data.db.NotificationDao;
import com.nwt.recyglo_shop.data.vos.NewsVO;
import com.nwt.recyglo_shop.data.vos.NotificationDataSend;
import com.nwt.recyglo_shop.data.vos.NotificationVO;
import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.data.vos.UserVO;
import com.nwt.recyglo_shop.data.vos.WastItemVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by user on 1/25/18.
 */

@SuppressLint("CheckResult")
public class AppModel extends ViewModel {
    private static final String USERS = "user";
    private static final String WAST = "wast";
    private static final String NEWS = "news";
    private static final String SHOPS = "shops";
    private static final String NOTIFICATION = "notification";

    private AppDatabase mAppDatabase;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    public AppModel(Context context) {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        initDatabase(context);
    }

    private void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }


    public void startLoadingUsers(final Context context,DataCheckDelegate delegate) {

        DatabaseReference usersDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersNodeDBR = usersDBR.child(USERS);
        usersNodeDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<UserVO> userList = new ArrayList<>();
                for (DataSnapshot usersDSS : dataSnapshot.getChildren()) {
                    UserVO user = usersDSS.getValue(UserVO.class);
                    userList.add(user);
                }
                if (userList.size() > 0 ) {
                    mAppDatabase.userDao().deleteUsers();
                    long[] insertedIds = mAppDatabase.userDao().insertUsers(userList.toArray(new UserVO[0]));
                    delegate.dataCheck(true);
                }else {
                    delegate.dataCheck(false);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void startLoadingWastItem(final Context context,DataCheckDelegate delegate) {
        DatabaseReference usersDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersNodeDBR = usersDBR.child(WAST);
        usersNodeDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<WastItemVO> wastList = new ArrayList<>();
                for (DataSnapshot wastsDSS : dataSnapshot.getChildren()) {
                    WastItemVO wast = wastsDSS.getValue(WastItemVO.class);
                    wastList.add(wast);
                }
                if (wastList.size() > 0 ) {
                    mAppDatabase.wastDao().deleteWasts();
                    long[] insertedIds = mAppDatabase.wastDao().insertWasts(wastList.toArray(new WastItemVO[0]));
                    delegate.dataCheck(true);
                }else {
                    delegate.dataCheck(false);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void startLoadingNews(final Context context,DataCheckDelegate delegate) {
        DatabaseReference usersDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersNodeDBR = usersDBR.child(NEWS);
        usersNodeDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<NewsVO> newsList = new ArrayList<>();
                for (DataSnapshot newssDSS : dataSnapshot.getChildren()) {
                    NewsVO news = newssDSS.getValue(NewsVO.class);
                    newsList.add(news);
                }
                if (newsList.size() > 0 ) {
                    mAppDatabase.newsDao().deleteNews();
                    long[] insertedIds = mAppDatabase.newsDao().insertNews(newsList.toArray(new NewsVO[0]));
                    delegate.dataCheck(true);
                }else {
                    delegate.dataCheck(false);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void startLoadingShops(final Context context,DataCheckDelegate delegate) {
        DatabaseReference usersDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersNodeDBR = usersDBR.child(SHOPS);
        usersNodeDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<ShopsVO> shopsList = new ArrayList<>();
                for (DataSnapshot shopssDSS : dataSnapshot.getChildren()) {
                    ShopsVO shops = shopssDSS.getValue(ShopsVO.class);
                    shopsList.add(shops);
                }
                if (shopsList.size() > 0 ) {
                    mAppDatabase.shopDao().deleteShops();
                    long[] insertedIds = mAppDatabase.shopDao().insertShops(shopsList.toArray(new ShopsVO[0]));
                    delegate.dataCheck(true);
                }else {
                    delegate.dataCheck(false);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void startLoadingNotification(final Context context,DataCheckDelegate delegate) {
        DatabaseReference usersDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersNodeDBR = usersDBR.child(NOTIFICATION);
        usersNodeDBR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<NotificationVO> notificationsList = new ArrayList<>();
                for (DataSnapshot notificationsDSS : dataSnapshot.getChildren()) {
                    NotificationVO notifications = notificationsDSS.getValue(NotificationVO.class);
                    notificationsList.add(notifications);
                }
                if (notificationsList.size() > 0 ) {
                    mAppDatabase.notificationDao().deleteNotifications();
                    long[] insertedIds = mAppDatabase.notificationDao().insertNotifications(notificationsList.toArray(new NotificationVO[0]));
                    delegate.dataCheck(true);
                }else {
                    delegate.dataCheck(false);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void publishNotification(String key,String shopName)
    {
        NotificationVO nav = new NotificationVO();
        nav.isAccept = "false";
        nav.isReject = "false";
        nav.notification_title = shopName+" မှရောင်းရန်ရှိသည်။";
        nav.visible = "v";

        DatabaseReference mmNewsDBR = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mmNewsNodeDBR = mmNewsDBR.child(NOTIFICATION);

        mmNewsNodeDBR.child(key).setValue(nav);


    }

    public LiveData<List<ShopsVO>> getShop() {
        return mAppDatabase.shopDao().getAllShops();
    }

    public LiveData<List<NotificationVO>> getNotification() {
        return mAppDatabase.notificationDao().getAllNotifications();
    }

    public void updateNotificationById(String id,String updateValue) {
         mAppDatabase.notificationDao().updateNotificationsById(id,updateValue);
    }


    public LiveData<List<ShopsVO>> getShopByTownshipTag(String tag) {
        return mAppDatabase.shopDao().getShopsByTownshiptag(tag);
    }


    public LiveData<List<WastItemVO>> getWastItem() {
        return mAppDatabase.wastDao().getAllWasts();
    }


    public LiveData<List<NewsVO>> getNews() {
        return mAppDatabase.newsDao().getAllNews();
    }


    public UserVO getUserByUserType(String usertype) {
        return mAppDatabase.userDao().getUserVOByUserType(usertype);
    }

    public UserVO getUserByUserId(String userId) {
        return mAppDatabase.userDao().getUserVOByUserNo(userId);
    }

    public ShopsVO getShopById(String id) {
        return mAppDatabase.shopDao().getShopsVOByShopNo(id);
    }

    public LiveData<List<UserVO>> getAllUser() {
        return mAppDatabase.userDao().getAllUsers();
    }

    public interface DataCheckDelegate {
        void dataCheck(Boolean check);
    }


    public interface UploadFileCallback {
        void onUploadSucceeded(String uploadedPaths);

        void onUploadFailed(String msg);
    }

}

