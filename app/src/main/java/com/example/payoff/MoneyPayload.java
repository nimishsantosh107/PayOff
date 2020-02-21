package com.example.payoff;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoneyPayload {

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("amount")
    private List<String> amount;

    @SerializedName("time")
    private String time;

    public MoneyPayload(String from,String to,List<String> amount,String time){
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.time = time;
    }

    public List<String> getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }
}
