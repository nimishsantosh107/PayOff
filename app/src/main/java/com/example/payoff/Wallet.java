package com.example.payoff;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Wallet {

    @SerializedName("name")
    private String name;

    @SerializedName("amount")
    private List<String> amount;

    @SerializedName("ethers")
    private int ethers;

    @SerializedName("transaction_count")
    private int transactionCount;

    @SerializedName("transactions")
    private List<String> transactions;

    public Wallet(String name,List<String> amount,int ethers,int transactionCount,List<String> transactions){
        this.name = name;
        this.amount = amount;
        this.ethers = ethers;
        this.transactionCount = transactionCount;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public List<String> getAmount() {
        return amount;
    }

    public int getEthers() {
        return ethers;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(List<String> amount) {
        this.amount = amount;
    }

    public void setEthers(int ethers) {
        this.ethers = ethers;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
}
