package com.dmitriy;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Chart {
    public static void createCharts(Map<Integer, Integer> map) {
        var categoryDataset = new DefaultCategoryDataset();
        for (var value : map.entrySet())
            categoryDataset.setValue(value.getValue(), "", value.getKey());

        JFreeChart chart = ChartFactory.createBarChart("", "Количество этажей", "Количествово зданий", categoryDataset);

        try {
            ChartUtils.saveChartAsPNG(new File("graphic.png"), chart, 1500, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
