package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ForceMetricsController {
    @FXML private BarChart<String, Integer> areaSearchAreaChart, areaSearchAssetsChart, focusSearchAssetsChart;
    @FXML private BarChart<String, Double> focusSearchAreaChart;
    public void populate() {
        populateAreaSearchAreaChart();
        populateAreaSearchAssetsChart();
        populateFocusSearchAreaChart();
        populateFocusSearchAssetsChart();
    }
    public void populateAreaSearchAreaChart() {
        areaSearchAreaChart.getData().clear();
        int[] radii = {100, 500, 1000, 1500};
        for(int r : radii) {
            XYChart.Series series = new XYChart.Series();
            series.setName("" + r + "nm");
            for(Asset asset : PurchasingBackend.cart.assetList) {
                if(asset.getAreaSearchArea(r) < 0) {
                    continue;
                }
                series.getData().add(new XYChart.Data(asset.name, asset.getAreaSearchArea(r)));
            }
            areaSearchAreaChart.getData().add(series);
        }
    }
    public void populateAreaSearchAssetsChart() {
        areaSearchAssetsChart.getData().clear();
        int[] radii = {100, 500, 1000, 1500};
        for(int r : radii) {
            XYChart.Series series = new XYChart.Series();
            series.setName("" + r + "nm");
            for(Asset asset : PurchasingBackend.cart.assetList) {
                if(asset.getAreaSearchAssets(r) < 0) {
                    continue;
                }
                series.getData().add(new XYChart.Data(asset.name, asset.getAreaSearchAssets(r)));
            }
            areaSearchAssetsChart.getData().add(series);
        }
    }
    public void populateFocusSearchAreaChart() {
        focusSearchAreaChart.getData().clear();
        int[] radii = {100, 500, 1000, 1500};
        for(int r : radii) {
            XYChart.Series series = new XYChart.Series();
            series.setName("" + r + "nm");
            for(Asset asset : PurchasingBackend.cart.assetList) {
                if(asset.getFocusSearchArea(r) < 0) {
                    continue;
                }
                series.getData().add(new XYChart.Data(asset.name, asset.getFocusSearchArea(r)));
            }
            focusSearchAreaChart.getData().add(series);
        }
    }
    public void populateFocusSearchAssetsChart() {
        focusSearchAssetsChart.getData().clear();
        int[] radii = {100, 500, 1000, 1500};
        for(int r : radii) {
            XYChart.Series series = new XYChart.Series();
            series.setName("" + r + "nm");
            for(Asset asset : PurchasingBackend.cart.assetList) {
                if(asset.getFocusSearchAssets(r) < 0) {
                    continue;
                }
                series.getData().add(new XYChart.Data(asset.name, asset.getFocusSearchAssets(r)));
            }
            focusSearchAssetsChart.getData().add(series);
        }
    }
}
