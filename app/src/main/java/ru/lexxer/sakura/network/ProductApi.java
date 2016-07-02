package ru.lexxer.sakura.network;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.lexxer.sakura.models.ProductResponse;

/**
 * Date: 21.06.2016
 * Time: 00:31
 *
 * @author Jeksor
 */
public interface ProductApi {
    String mURL = "api/punicapp.php?action=itemsByChange";

    @GET(mURL)
    Call<ProductResponse> getProducts();
}
