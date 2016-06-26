package ru.lexxer.sakura.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.lexxer.sakura.models.Product;

/**
 * Date: 21.06.2016
 * Time: 00:31
 *
 * @author Jeksor
 */
public interface ProductApi {
    String mURL = "punicapp.php";
    String param = "itemsByChange";
    @GET(mURL)
    Call<Product> getProduct(@Query("action") String param);
}
