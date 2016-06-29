package ru.lexxer.sakura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import ru.lexxer.sakura.models.ProductResponse;
import ru.lexxer.sakura.network.ProductApi;
import ru.lexxer.sakura.network.RetrofitService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Drawer drawer = null;
    private Toolbar toolbar;

    private String[] channelNames;
    private String[] channelId;
    private String[] videoTypes;

    private int selectedDrawerItem = 0;

    private FrameLayout layoutList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим вьюхи
        Button buttonGetGoods = (Button) findViewById(R.id.butttonGetGoods);
        ListView listGoods = (ListView) findViewById(R.id.listGoods);

        buttonGetGoods.setOnClickListener(this);

        layoutList = (FrameLayout) findViewById(R.id.fragment_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ProductAdapter mProductAdapter = new ProductAdapter(this);

        channelNames = getResources().getStringArray(R.array.channel_names);
        channelId = getResources().getStringArray(R.array.channel_id);
        videoTypes = getResources().getStringArray(R.array.video_types);

        PrimaryDrawerItem[] primaryDrawerItems = new PrimaryDrawerItem[channelId.length];

        for (int i = 0; i < channelId.length; i++) {
            primaryDrawerItems[i] = new PrimaryDrawerItem()
                    .withName(channelNames[i])
                    .withIdentifier(i)
                    .withSelectable(false);
        }
        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        drawer = new DrawerBuilder(this)
                .withActivity(MainActivity.this)
                .withAccountHeader(accountHeader)
                .withDisplayBelowStatusBar(true)
                //.withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(primaryDrawerItems)
                .addStickyDrawerItems(
                        new SecondaryDrawerItem()
                                .withName(getString(R.string.about))
                                .withIdentifier(channelId.length - 1)
                                .withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                        //
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();

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
