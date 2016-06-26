package ru.lexxer.sakura.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Date: 26.06.2016
 * Time: 19:43
 *
 * @author Jeksor
 */
public class ProductResponse {

    @SerializedName("data")
    List<Product> mProducts;

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
    }
}
