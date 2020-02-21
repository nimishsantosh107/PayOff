package com.example.payoff;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Initialization {

    @SerializedName("Name")
    private String Name;

    @SerializedName("amount")
    private List<String> amount;

    @SerializedName("ethers")
    private int ethers;

    @SerializedName("transactionCount")
    private int transactionCount;

    @SerializedName("password")
    private String password;

    @SerializedName("k")
    private String k;

    @SerializedName("address")
    private String address;

    @SerializedName("custId")
    private int custId;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<String> getAmount() {
        return amount;
    }

    public void setAmount(List<String> amount) {
        this.amount = amount;
    }

    public int getEthers() {
        return ethers;
    }

    public void setEthers(int ethers) {
        this.ethers = ethers;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public Initialization(String name, List<String> amount, int ethers, int transactionCount, String password, String k, String address, int custId) {
        Name = name;
        this.amount = amount;
        this.ethers = ethers;
        this.transactionCount = transactionCount;
        this.password = password;
        this.k = k;
        this.address = address;
        this.custId = custId;
    }
}
