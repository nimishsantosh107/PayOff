package com.example.payoff;

import com.google.gson.annotations.SerializedName;

public class TransactionResponse {

    @SerializedName("transaction")
    private String transaction;

    public TransactionResponse(String transaction){
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }
}
