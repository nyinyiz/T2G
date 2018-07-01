package com.nwt.recyglo_shop.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.nwt.recyglo_shop.data.vos.ShopsVO;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

import java.util.List;

@Dao
public interface ShopDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertShops(ShopsVO... shopVOS);

    @Query("SELECT * FROM " + DatabaseConstants.SHOP_TABLE_NAME + " WHERE id = :id LIMIT 1")
    ShopsVO getShopsVOByShopNo(String id);

    @Query("SELECT * FROM " + DatabaseConstants.SHOP_TABLE_NAME + " WHERE township_tag = :township_tag ")
    LiveData<List<ShopsVO>> getShopsByTownshiptag(String township_tag);

    @Query("SELECT * FROM " + DatabaseConstants.SHOP_TABLE_NAME)
    LiveData<List<ShopsVO>> getAllShops();

    @Query("DELETE FROM " + DatabaseConstants.SHOP_TABLE_NAME)
    void deleteShops();
}
