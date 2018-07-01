package com.nwt.recyglo_shop.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.nwt.recyglo_shop.data.vos.NewsVO;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertNews(NewsVO... newsVOS);

    @Query("SELECT * FROM " + DatabaseConstants.NEWS_TABLE_NAME + " WHERE mId = :id LIMIT 1")
    NewsVO getNewsVOByNewNo(String id);

    @Query("SELECT * FROM " + DatabaseConstants.NEWS_TABLE_NAME)
    LiveData<List<NewsVO>> getAllNews();

    @Query("DELETE FROM " + DatabaseConstants.NEWS_TABLE_NAME)
    void deleteNews();

}
