package com.cris.conversor.main;

import javax.swing.*;

public class MonedasDispoException extends RuntimeException {
    public MonedasDispoException(String elOpcionNoEstaDisponible) {
        JOptionPane.showMessageDialog(null,elOpcionNoEstaDisponible,"error",JOptionPane.ERROR_MESSAGE);
    }
}
