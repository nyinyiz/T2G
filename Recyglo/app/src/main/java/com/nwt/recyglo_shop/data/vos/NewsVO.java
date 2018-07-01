
package com.nwt.recyglo_shop.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.nwt.recyglo_shop.data.vos.converter.NewsImageConverter;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@Entity(tableName = DatabaseConstants.NEWS_TABLE_NAME)
public class NewsVO {

    @PrimaryKey(autoGenerate = true)
    public Long mId;

    @SerializedName("category")
    public String category;

    @SerializedName("des")
    public String des;

    @SerializedName("id")
    public Long id;

    @SerializedName("image")
    public String image;

    @SerializedName("posted_date")
    public String posted_date;

    @SerializedName("title")
    public String title;

}
