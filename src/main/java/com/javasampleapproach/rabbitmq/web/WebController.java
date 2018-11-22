package com.javasampleapproach.rabbitmq.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.javasampleapproach.rabbitmq.model.Currency;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.javasampleapproach.rabbitmq.producer.Producer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class WebController {

    /**
     * Rest API - web controller:
     * Managing and mapping the http requests
     */

    //Get request
    @RequestMapping("/")
    public String index() { return "Hello from Producer!"; }

    @Autowired
    Producer producer;


    //Post request
    @RequestMapping(
            value = "/sendCurrencies",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public String createCurrency(@RequestBody String jsonCurrenciesArray) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            //converating the request into a list of Currencies
            List<Currency> currenciesList = objectMapper.readValue(jsonCurrenciesArray, new TypeReference<List<Currency>>() {
            });

            //Send the msg to rabbitMq
            producer.produce(currenciesList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Msg was sent successfully";
    }
}
