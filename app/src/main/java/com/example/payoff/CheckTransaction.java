package com.example.payoff;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CheckTransaction {

    @SerializedName("amount")
    private List<Integer> amount;

    @SerializedName("fromAddress")
    private String from;

    @SerializedName("toAddress")
    private String to;

    @SerializedName("value")
    private int value;

    public CheckTransaction(List<Integer> amount, String from, String to, int value) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public void setAmount(List<Integer> amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
