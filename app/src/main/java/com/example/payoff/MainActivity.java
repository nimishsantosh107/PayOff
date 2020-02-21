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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        final Api service = retrofit.create(Api.class);

        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<MoneyPayload> req = service.sendMoney(new MoneyPayload("hrjjj","grgrg","lololol","1234324"));
                req.enqueue(new Callback<MoneyPayload>() {
                    @Override
                    public void onResponse(Call<MoneyPayload> call, Response<MoneyPayload> response) {

                        if(response.body()==null)
                        {
                            Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
                        }else {
                            MoneyPayload res = response.body();
                            Log.e("REQ-SUCCESS", res.getAmount());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoneyPayload> call, Throwable t) {
                        Log.e("REQ-FAIL", t.getMessage());
                    }

                });
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