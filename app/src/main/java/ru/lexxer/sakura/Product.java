package ru.lexxer.sakura;

public class Product {
    @com.google.gson.annotations.SerializedName("id")
    private int mId;
    @com.google.gson.annotations.SerializedName("section_id")
    private int mSectionId;
    @com.google.gson.annotations.SerializedName("name")
    private String mName;
    @com.google.gson.annotations.SerializedName("desc")
    private String mDesc;
    @com.google.gson.annotations.SerializedName("price")
    private String mPrice;
    @com.google.gson.annotations.SerializedName("in_stock")
    private boolean mInStock;
    @com.google.gson.annotations.SerializedName("weight")
    private String mWeight;
    @com.google.gson.annotations.SerializedName("img_icon")
    private String mImgIcon;
    @com.google.gson.annotations.SerializedName("img_photo")
    private String mImgPhoto;
    @com.google.gson.annotations.SerializedName("update_time")
    private String mUpdateTime;
    @com.google.gson.annotations.SerializedName("sort_date")
    private String mSortDate;
}
