package com.example.payoff;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL = "http://192.168.43.177:5000";

    @POST("/api")
    Call<MoneyPayload> sendMoney(@Body MoneyPayload moneyPayload) ;


}