package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

class TimeComplexityGraph extends ApplicationFrame {

    public TimeComplexityGraph(String title, int[] sizes, long[] times) {
        super(title);
        final XYSeries series = new XYSeries("Time Complexity");
        for (int i = 0; i < sizes.length; i++) {
            series.add(sizes[i], times[i]);
        }
        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Time Complexity",
                "File Size (digits)",
                "Execution Time (ms)",
                data, PlotOrientation.VERTICAL, true, true, false
        );
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }
}