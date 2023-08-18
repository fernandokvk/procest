package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;
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

    public static void A01_DistExponencial(double beta, int nums) {
        double[] expValues = new double[nums];
        double[] indexes = new double[nums];
        DefaultXYDataset dataset = new DefaultXYDataset();

        for (int i = 0; i < nums; i++) {
            double value = Math.random();
            double t = -Math.log(1 - value) / beta; // Cálculo correto de t
            double ft = beta * Math.exp(-beta * t); // Cálculo correto de f(t)
            expValues[i] = ft;
            indexes[i] = t;
        }


        double[][] data = {indexes, expValues}; // Invertendo os eixos
//        double[][] data = {expValues, indexes}; // Invertendo os eixos
        dataset.addSeries("Exponential Distribution", data);

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Exponential Distribution",
                "Índices",
                "Valores",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        JFrame frame = new JFrame("Gráfico de Distribuição Exponencial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }


}
