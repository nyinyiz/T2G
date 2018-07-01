package com.nwt.recyglo_shop.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.nwt.recyglo_shop.data.vos.WastItemVO;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

import java.util.List;

@Dao
public interface WastDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertWasts(WastItemVO... wastVOS);

    @Query("SELECT * FROM " + DatabaseConstants.WAST_TABLE_NAME + " WHERE id = :id LIMIT 1")
    WastItemVO getWastItemVOByWastNo(String id);

    @Query("SELECT * FROM " + DatabaseConstants.WAST_TABLE_NAME)
    LiveData<List<WastItemVO>> getAllWasts();

    @Query("DELETE FROM " + DatabaseConstants.WAST_TABLE_NAME)
    void deleteWasts();

}
