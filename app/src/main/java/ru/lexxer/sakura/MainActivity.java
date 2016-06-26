package ru.lexxer.sakura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.lexxer.sakura.network.RetrofitService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Это добавил DTO , решил пока не удалять, вдруг это что нужное
//    @com.google.gson.annotations.SerializedName("error")
//    private boolean mError;
//    @com.google.gson.annotations.SerializedName("data")
//    private List<Product> mData;
//    @com.google.gson.annotations.SerializedName("serverTime")
//    private String mServertime;

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
        //String BASE_URL = "http://pizzalarenzo.ru/api/punicapp.php?action=itemsByChange" ;
        String BASE_URL = "http://pizzalarenzo.ru/api/" ;
        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = client.create(RetrofitService.class);

        Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show();
    }
}
