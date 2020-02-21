package com.example.payoff;

import com.google.gson.annotations.SerializedName;

public class MoneyPayload {

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("amount")
    private String amount;

    @SerializedName("time")
    private String time;

    public MoneyPayload(String from,String to,String amount,String time){
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }
}
