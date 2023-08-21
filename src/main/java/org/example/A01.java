package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Arrays;

public class A01 {


    public static void _2caras(int nums) {
        int[] frequencias = new int[3];
        double[] frequenciasRelativas = new double[3];
        double probCara = 0.5;

        for (int i = 0; i < nums; i++) {
            boolean firstCoin = Math.random() > probCara;
            boolean secondCoin = Math.random() > probCara;

            if (firstCoin && secondCoin) frequencias[2]++;
            else if (!firstCoin && !secondCoin) frequencias[0]++;
            else frequencias[1]++;
        }
        System.out.println("Frequências");
        System.out.println(Arrays.toString(frequencias));
        for (int i = 0; i < frequencias.length; i++) {
            frequenciasRelativas[i] = (double) frequencias[i] / nums;
        }
        System.out.println("Frequências relativas");
        System.out.println(Arrays.toString(frequenciasRelativas));
    }


    public static void _distExponencial(int nums) {
//        double[] betaValues = {0.5, 1, 1.5, Math.E};
        double[] betaValues = {Math.E};
        DefaultXYDataset dataset = new DefaultXYDataset();

        for (int j = 0; j < betaValues.length; j++) {
            double[][] data = new double[2][nums];
            for (int i = 0; i < nums; i++) {
                double value = Math.random();
                double t = - (betaValues[j] *  Math.log(1 - value));
                double ft = (1 /betaValues[j]) * Math.exp(-t / betaValues[j]);
                data[0][i] = t;
                data[1][i] = ft;
            }
            dataset.addSeries("Beta = " + betaValues[j], data);
        }
        plotData(betaValues, dataset, nums);
    }

    private static void plotData(double[] betaValues, DefaultXYDataset dataset, int nums) {
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Distribuição exponencial, n = " + nums,
                "t",
                "f(t)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        chart.setAntiAlias(true);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true);
        for (int j = 0; j < betaValues.length; j++) {
            renderer.setSeriesShapesVisible(j, true); // Enable shapes for each series
            renderer.setSeriesShape(j, new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0)); // Set shape and size
        }
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        JFrame frame = new JFrame("Exponential Distribution Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }


}
