package ru.lexxer.sakura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import ru.lexxer.sakura.models.ProductResponse;
import ru.lexxer.sakura.network.ProductApi;
import ru.lexxer.sakura.network.RetrofitService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим вьюхи
        Button buttonGetGoods = (Button) findViewById(R.id.butttonGetGoods);
        ListView listGoods = (ListView) findViewById(R.id.listGoods);

        buttonGetGoods.setOnClickListener(this);

        //ProductAdapter mProductAdapter = new ProductAdapter(this);
    }

    @Override
    public void onClick(View v) {

        RetrofitService retrofitService = RetrofitService.getInstance(this);

        ProductApi productApi = retrofitService.createApiService(ProductApi.class);

        Call<ProductResponse> productCall = productApi.getProducts();

        try {
            Response<ProductResponse> response = productCall.execute();
            ProductResponse body = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show();
    }
}
