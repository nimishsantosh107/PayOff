package com.example.payoff;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "http://192.168.43.232:3000";

    @POST("/api")
    Call<MoneyPayload> sendMoney(@Body MoneyPayload moneyPayload);

    @GET("/api/customer/balance/{id}")
    Call<Balance> checkBalance(@Path("id") String id);

    @GET("/api/customer/getDetails/{id}")
    Call<Wallet> checkWallet(@Path("id") int id);

    @POST("/api/transaction/create")
    Call<TransactionResponse>  createTransaction(@Body CreateTransaction createTransaction);



}