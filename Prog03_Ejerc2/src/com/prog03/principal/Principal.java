package com.prog03.principal;

import com.prog03.figuras.Rectangulo;

public class Principal {
    public static void main(String[] args) {
        Rectangulo rec1 = new Rectangulo();
        rec1.setBase(4);
        rec1.setAltura(5);
        
        System.out.println("Rectángulo 1:");
        System.out.println(rec1.toString());
        System.out.println("¿Es cuadrado? " + rec1.isCuadrado());

        Rectangulo rec2 = new Rectangulo(3, 3);
        
        System.out.println("\nRectángulo 2:");
        System.out.println(rec2.toString());
        System.out.println("¿Es cuadrado? " + rec2.isCuadrado());
    }
}
