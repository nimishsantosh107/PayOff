package com.example.payoff;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateTransaction {

    @SerializedName("amount")
    private List<Integer> amount;

    @SerializedName("fromAddress")
    private String from;

    @SerializedName("toAddress")
    private String to;

    @SerializedName("value")
    private int value;

    @SerializedName("time")
    private String time;

    public CreateTransaction(List<Integer> amount,String from, String to,int value,String time){
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.value = value;
        this.time = time;
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getValue() {
        return value;
    }

    public String getTime() {
        return time;
    }
}
