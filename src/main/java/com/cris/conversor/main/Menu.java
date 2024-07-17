package com.cris.conversor.main;


import com.cris.conversor.moneda.GsonMoneda;
import com.cris.conversor.moneda.ValorMoneda;

import javax.swing.*;
import java.io.IOException;

public class Menu {

    public static void main(String[] args) {
        ValorMoneda valorMoneda = new ValorMoneda();
        GsonMoneda gsonMoneda = new GsonMoneda();
        String[] list = {"USD", "ARS","BRL","CLP","BOB","COP"};
        String monedasDispo = String.format("""
                -----------------------------
                |  Monedas disponibles             
                -----------------------------
                |  1. USD: Dólar estadounidense
                |  2. ARS: Peso argentino      
                |  3. BRL: Real brasileño      
                |  4. CLP: Peso chileno        
                |  5. BOB: Boliviano          
                |  6. COP: Peso colombiano     
                -----------------------------         
                """);
        String opciones = String.format("""
                | 1. Convertir moneda
                | 0. Salir
                """);

        boolean men = true;
        while(men){
            try{
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,opciones));
                switch (op){
                    case 1:
                        int idUno = Integer.parseInt(JOptionPane.showInputDialog(null,monedasDispo)) ;
                        int idDos = Integer.parseInt(JOptionPane.showInputDialog(null,monedasDispo)) ;
                        if (idUno < 0 || idUno > 6){
                            throw new MonedasDispoException("El opcion no esta disponible");
                        } else if (idDos < 0 || idDos > 6) {
                            throw new MonedasDispoException("El opcion no esta disponible");
                        }else{
                           var moneda = gsonMoneda.GsonAMoneda(valorMoneda.buscarMoneda(list[idUno-1]));
                           double valorM = moneda.tasaDeConversion(list[idDos-1]);
                           int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero a convertir "));
                           JOptionPane.showMessageDialog(null,String.format("""
                                   Su valor a convertid de:
                                   %s a %s es de: $ %.2f""",list[idUno - 1],list[idDos -1 ],valorMoneda.valorConversion(cantidad,valorM)));
                        }
                        break;
                    case 0:
                        men =false;
                        break;
                    default:

                }

            }catch (MonedasDispoException | NumberFormatException e){
               JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
