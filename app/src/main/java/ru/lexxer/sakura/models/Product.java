package ru.lexxer.sakura.models;

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

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getSectionId() {
        return mSectionId;
    }

    public void setSectionId(int sectionId) {
        mSectionId = sectionId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public boolean isInStock() {
        return mInStock;
    }

    public void setInStock(boolean inStock) {
        mInStock = inStock;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public String getImgIcon() {
        return mImgIcon;
    }

    public void setImgIcon(String imgIcon) {
        mImgIcon = imgIcon;
    }

    public String getImgPhoto() {
        return mImgPhoto;
    }

    public void setImgPhoto(String imgPhoto) {
        mImgPhoto = imgPhoto;
    }

    public String getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        mUpdateTime = updateTime;
    }

    public String getSortDate() {
        return mSortDate;
    }

    public void setSortDate(String sortDate) {
        mSortDate = sortDate;
    }
}
