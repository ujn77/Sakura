package ru.lexxer.sakura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @com.google.gson.annotations.SerializedName("error")
    private boolean mError;
    @com.google.gson.annotations.SerializedName("data")
    private List<Product> mData;
    @com.google.gson.annotations.SerializedName("serverTime")
    private String mServertime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
