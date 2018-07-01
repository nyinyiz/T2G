
package com.nwt.recyglo_shop.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

@Entity(tableName = DatabaseConstants.WAST_TABLE_NAME)
public class WastItemVO {

    @PrimaryKey(autoGenerate = true)
    public Long mId;

    @SerializedName("date")
    public String date;

    @SerializedName("id")
    public Long id;

    @SerializedName("item_image_url")
    public String item_image_url;

    @SerializedName("item_name")
    public String item_name;

    @SerializedName("item_price")
    public String item_price;

    @SerializedName("pricing_differential")
    public String pricing_differential;

    @SerializedName("pricing_type")
    public String pricing_type;

    @SerializedName("unit_name")
    public String unitName;

    public String getFile(String item_image_url) {
        return "file:///android_asset/image/"+ item_image_url + ".jpeg";
    }
}
