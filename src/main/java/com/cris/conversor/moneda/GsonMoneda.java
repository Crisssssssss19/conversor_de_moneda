package com.cris.conversor.moneda;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonMoneda {

    public Moneda GsonAMoneda(String json){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Moneda moneda = gson.fromJson(json, Moneda.class);
        return moneda;
    }
}
