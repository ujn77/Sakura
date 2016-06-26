package ru.lexxer.sakura.network;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.lexxer.sakura.models.Product;

/**
 * Date: 21.06.2016
 * Time: 00:31
 *
 * @author Jeksor
 */
public interface ProductApi {
    @GET("http://pizzalarenzo.ru/api/punicapp.php?action=itemsByChange")
    Call<Product> getProduct();
}
