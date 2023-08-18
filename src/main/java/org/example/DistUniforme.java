package org.example;

import java.util.Arrays;

public class DistUniforme {


    public static void A01_02caras(int nums) {
        int[] frequencias = new int[3];
        double[] frequenciasRelativas = new double[3];
        double probCara = 0.5;

        for (int i = 0; i < nums; i++) {
            boolean firstCoin = Math.random() > probCara;
            boolean secondCoin = Math.random() > probCara;

            if (firstCoin && secondCoin) frequencias[2]++;
            //nenhuma
            else if (!firstCoin && !secondCoin) frequencias[0]++;
            //apenas uma
            else frequencias[1]++;
            //as duas
        }
        System.out.println("Frequências");
        System.out.println(Arrays.toString(frequencias));
        for (int i = 0; i < frequencias.length; i++) {
            frequenciasRelativas[i] = (double) frequencias[i] / nums;
        }
        System.out.println("Frequências relativas");
        System.out.println(Arrays.toString(frequenciasRelativas));

    }

    public static void A01_DistExponencial(double beta, int nums){
        /*
           a) definir um beta p/ f(t)
           b) gere nums valores de uma uniforme [0, 1]
           c) para esses valores (u) calcule F^(-1)(u)=t
           d) com os valores de t calcule f(t)
           e) faça um gráfico de f(t)
         */
    }
}
