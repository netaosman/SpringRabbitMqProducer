package com.javasampleapproach.rabbitmq.model;

import java.util.Date;

public class Currency {

    private String code;
    private Float amountToBuy;
    private String countryName;
    private Float exchangeRate;


    public Currency() {
    }

    public Currency(String code, Float amountToBuy, String countryName, Float exchangeRate) {
        this.code = code;
        this.amountToBuy = amountToBuy;
        this.countryName = countryName;
        this.exchangeRate = exchangeRate;


    }

    // Currency code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Currency rate
    public void setAmountToBuy(Float amountToBuy) {
        this.amountToBuy = amountToBuy;
    }

    public Float getAmountToBuy() {
        return this.amountToBuy;
    }


    //Country name
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    //ExchangeRate againset the NIS
    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Float getExchangeRate() {
        return this.exchangeRate;
    }

    @Override
    public String toString() {
        return getCode() + ", " + getAmountToBuy() + ", " + getCountryName() + ", " + getExchangeRate();
    }

}
