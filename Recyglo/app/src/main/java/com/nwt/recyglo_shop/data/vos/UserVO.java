
package com.nwt.recyglo_shop.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.nwt.recyglo_shop.data.vos.converter.PickUpConverter;
import com.nwt.recyglo_shop.utils.DatabaseConstants;

@Entity(tableName = DatabaseConstants.USER_TABLE_NAME)
public class UserVO {

    @PrimaryKey(autoGenerate = true)
    public Long mId;

    @SerializedName("address")
    public String address;

    @SerializedName("city")
    public String city;

    @SerializedName("email")
    public String email;

    @SerializedName("id")
    public Long id;

    @SerializedName("isPicket")
    public Boolean isPicket;

    @SerializedName("lag")
    public String lag;

    @SerializedName("long")
    public String mlong;

    @SerializedName("name")
    public String name;

    @SerializedName("organization_name")
    public String organization_name;

    @SerializedName("organization_type")
    public String organization_type;

    @SerializedName("ph_no")
    public String ph_no;

    @SerializedName("PicketVO")
    @TypeConverters({PickUpConverter.class})
    public PicketVO PicketVO;

    @SerializedName("pickup_service_location")
    public String pickup_service_location;

    @SerializedName("township")
    public String township;

    @SerializedName("type_of_item")
    public String type_of_item;

    @SerializedName("user_type")
    public String user_type;

}
