package com.cris.conversor.moneda;

import com.google.gson.annotations.SerializedName;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Moneda {
    @SerializedName("base_code")
    private String base_code;

    @SerializedName("conversion_rates")
    private Map<String, Double> conversiones;

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversiones() {
        return conversiones;
    }

    public void setConversiones(Map<String, Double> conversiones) {
        this.conversiones = conversiones;
    }

    public Double tasaDeConversion(String codigoMoneda){
        return getConversiones().get(codigoMoneda);
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "base_code='" + base_code + '\'' +
                ", conversiones=" + conversiones +
                '}';
    }
}
