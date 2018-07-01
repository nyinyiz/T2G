package com.nwt.recyglo_shop.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.nwt.recyglo_shop.data.vos.UserVO;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertUsers(UserVO... userVOS);

    @Query("SELECT * FROM " + DatabaseConstants.USER_TABLE_NAME + " WHERE id = :id LIMIT 1")
    UserVO getUserVOByUserNo(String id);


    @Query("SELECT * FROM " + DatabaseConstants.USER_TABLE_NAME + " WHERE user_type = :usertype LIMIT 1")
    UserVO getUserVOByUserType(String usertype);


    @Query("SELECT * FROM " + DatabaseConstants.USER_TABLE_NAME)
    LiveData<List<UserVO>> getAllUsers();

    @Query("DELETE FROM " + DatabaseConstants.USER_TABLE_NAME)
    void deleteUsers();

}
