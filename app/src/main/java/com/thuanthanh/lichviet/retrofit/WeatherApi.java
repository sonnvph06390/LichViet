package com.thuanthanh.lichviet.retrofit;

import com.thuanthanh.lichviet.model.PerHour.PerHour;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {
    @GET("/forecasts/v1/hourly/12hour/353412?apikey=pOSruJBxzbxVkFigGWS4JpG9ayGE3Nzp&language=vi")
    Call<List<PerHour>> getPerHourWeatherData();

//    @GET("/forecasts/v1/daily/5day/353412?apikey=pOSruJBxzbxVkFigGWS4JpG9ayGE3Nzp&language=vi")
//    Call<List<NextDay>> getNextDayWeatherData();
}
