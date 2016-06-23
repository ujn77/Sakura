package ru.lexxer.sakura.network;

import com.course.sample.model.sorokinweather.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Date: 21.06.2016
 * Time: 00:31
 *
 * @author Jeksor
 */
public interface WeatherApi {
    String NOVOSIBIRSK = "novosibirsk";

    @GET(WeatherUrls.Forecast.GET_FORECAST)
    Call<ForecastResponse> getForecast(@Query("city") String city);
}
