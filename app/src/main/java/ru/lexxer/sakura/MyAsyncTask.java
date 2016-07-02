package ru.lexxer.sakura;

import android.os.SystemClock;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import ru.lexxer.sakura.models.ProductResponse;
import ru.lexxer.sakura.network.ProductApi;
import ru.lexxer.sakura.network.RetrofitService;

/**
 * Date: 02.07.2016
 * Time: 15:26
 *
 * @author Alexey Buynichev
 */
public class MyAsyncTask extends android.os.AsyncTask<Void, Integer, Void> {
    int progress_status;

    @Override
    protected void onPreExecute() {
        // обновляем пользовательский интерфейс сразу после выполнения задачи
        super.onPreExecute();
        //Toast.makeText(this, "Вызов onPreExecute()", Toast.LENGTH_SHORT).show();
        progress_status = 0;
        //buynichev_async_activity_tvProgress.setText("Загрузка 0%");
    }

    @Override
    protected Void doInBackground(Void... params) {
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

//        while (progress_status < 100) {
//
//            progress_status += 10;
//            publishProgress(progress_status);
//            SystemClock.sleep(300);
//        }
//        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
//        buynichev_async_activity_pbProgress.setProgress(values[0]);
//        buynichev_async_activity_tvProgress.setText("загрузка " + values[0] + "%");
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
//        buynichev_async_activity_tvProgress.setText("Загрузка завершена!");
//        buynichev_async_activity_pbProgress.setVisibility(View.GONE);
//        buynichev_async_activity_tvProgress.setText("");

        // из интента достаем массив строк (это почему-то не работает :(
        //Intent intent = getIntent();
        //String[] months = intent.getStringArrayExtra("months");

        // создаем адаптер
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        //BuynichevAdapter adapter = new BuynichevAdapter(BuynichevAsyncActivity.this, months);

        // присваиваем адаптер списку
        //buynichev_async_activity_lvMonths.setAdapter(adapter);
    }
}
