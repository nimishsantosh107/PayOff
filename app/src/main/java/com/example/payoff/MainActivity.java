package com.example.payoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Gson gson;
    Retrofit retrofit;
    Api service;
    String id;

    List<Integer> amount;
    String from, to, time;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(Api.class);

//        Button b1 = findViewById(R.id.b1);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                List<String> amount = new ArrayList<String>();
//                amount.add("23456789qwertyui");
//                amount.add("qwertyui12345678");
//                Call<MoneyPayload> req = service.sendMoney(new MoneyPayload("hrjjj","grgrg",amount,"1234324"));
//                req.enqueue(new Callback<MoneyPayload>() {
//                    @Override
//                    public void onResponse(Call<MoneyPayload> call, Response<MoneyPayload> response) {
//
//                        if(response.body()==null)
//                        {
//                            Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
//                        }else {
//                            MoneyPayload res = response.body();
//                            Log.e("REQ-SUCCESS", res.getAmount().get(0));
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<MoneyPayload> call, Throwable t) {
//                        Log.e("REQ-FAIL", t.getMessage());
//                    }
//
//                });
//            }
//        });

        Button b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                balance(id);
            }
        });

        Button b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWallet(id);

            }
        });

        Button b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createTransaction(amount,from,to,value,time);
            }
        });

        Button b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            checkTransaction(id);


            }
        });
    }

    //Functions
    public void balance(String id) {
        Call<Balance> req = service.checkBalance(id);
        req.enqueue(new Callback<Balance>() {
            @Override
            public void onResponse(Call<Balance> call, Response<Balance> response) {
                if(response.body()==null)
                {
                    Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
                }else {
                    Balance res = response.body();
                    Log.e("REQ-SUCCESS", String.valueOf(res.getValue()));
                }
            }

            @Override
            public void onFailure(Call<Balance> call, Throwable t) {
                Log.e("REQ-FAIL", t.getMessage());
            }

        });
    }

    public void checkWallet(String id){
        Call<Wallet> req = service.checkWallet(id);
        req.enqueue(new Callback<Wallet>() {
            @Override
            public void onResponse(Call<Wallet> call, Response<Wallet> response) {
                if(response.body() == null){
                    Toast.makeText(MainActivity.this, "null", Toast.LENGTH_SHORT).show();
                }
                else{

                    Wallet res = response.body();
                    Log.e("REQ-SUCCESS",res.getTransactions().get(0));

                }
            }

            @Override
            public void onFailure(Call<Wallet> call, Throwable t) {
                Log.e("REQ-FAIL", t.getMessage());
            }
        });
    }

    public void createTransaction(List<Integer> amount,String from,String to,int value, String time){
//        List<Integer> amount = new ArrayList<Integer>();
//        amount.add(10);
        Call<TransactionResponse> req = service.createTransaction(new CreateTransaction(amount,from,to,value,time));
        req.enqueue(new Callback<TransactionResponse>() {
            @Override
            public void onResponse(Call<TransactionResponse> call, Response<TransactionResponse> response) {

                if(response.body()==null)
                {
                    Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
                }else {
                    TransactionResponse res = response.body();
                    Log.e("REQ-SUCCESS", res.getTransaction());
                }

            }

            @Override
            public void onFailure(Call<TransactionResponse> call, Throwable t) {

                Log.e("REQ-FAIL", t.getMessage());

            }
        });
    }

    public void checkTransaction(String id){
        Call<CheckTransaction> req = service.checkTransaction(id);
        req.enqueue(new Callback<CheckTransaction>() {
            @Override
            public void onResponse(Call<CheckTransaction> call, Response<CheckTransaction> response) {

                if(response.body()==null)
                {
                    Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
                }else {
                    CheckTransaction res = response.body();
                    Log.e("REQ-SUCCESS", String.valueOf(res.getAmount().get(0)));
                }

            }

            @Override
            public void onFailure(Call<CheckTransaction> call, Throwable t) {
                Log.e("REQ-FAIL", t.getMessage());
            }
        });
    }
}









//<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
//<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
//
//    //1 - md,  2 wifi ,0 null
//    public static int getConnectivityStatus(Context context) {
//        String status = null;
//        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        if (activeNetwork != null) {
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                return 2;
//            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                return 1;
//            }
//        } else {
//            return 0;
//        }
//        return 0;
//    }