package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class ForceCostController {
    private ObservableList<PieChart.Data> procurementChartData = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> OAndSChartData = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> groundInfrastructureChartData = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> personnelChartData = FXCollections.observableArrayList();
    private DecimalFormat df = new DecimalFormat("###.##");
    @FXML private PieChart procurementChart, OAndSChart, groundInfrastructureChart, personnelChart;
    @FXML private Label procurementTotal, OAndSTotal, groundInfrastructureTotal, personnelTotal;
    public void populate() {
        procurementTotal.setText("Total: " + PurchasingBackend.priceFormat(PurchasingBackend.cart.getTotalSpend()));
        OAndSTotal.setText("Total: " + PurchasingBackend.priceFormat(PurchasingBackend.cart.getOAndSSpend()));
        groundInfrastructureTotal.setText("Total: " + PurchasingBackend.priceFormat(PurchasingBackend.cart.getGroundInfrastructureSpend()));
        personnelTotal.setText("Total: " + PurchasingBackend.cart.getPersonnelRequirement() + " people");
        populateProcurement();
        populateOAndS();
        populateGroundInfrastructure();
        populatePersonnel();
    }
    public void populateProcurement() {
        procurementChartData.clear();
        double total = 0;
        for(Asset asset : PurchasingBackend.cart.assetList) {
            total += asset.getProcurementCost();
        }
        for(Asset asset : PurchasingBackend.cart.assetList) {
            if(asset.getTotalCost() > 0) {
                procurementChartData.add(new PieChart.Data(asset.name + ": " + df.format(asset.getProcurementCost() * 100/total) + "%", asset.getProcurementCost()));
            }
        }
        procurementChart.setData(procurementChartData);
    }
    public void populateOAndS() {
        OAndSChartData.clear();
        double total = 0;
        for(Asset asset : PurchasingBackend.cart.assetList) {
            total += asset.getOAndSCost();
        }
        for(Asset asset : PurchasingBackend.cart.assetList) {
            if(asset.getTotalCost() > 0) {
                OAndSChartData.add(new PieChart.Data(asset.name + ": " + df.format(asset.getOAndSCost() * 100/total) + "%", asset.getOAndSCost()));
            }
        }
        OAndSChart.setData(OAndSChartData);
    }
    public void populateGroundInfrastructure() {
        groundInfrastructureChartData.clear();
        double total = 0;
        for(Asset asset : PurchasingBackend.cart.assetList) {
            total += asset.getGroundInfrastructureCost();
        }
        for(Asset asset : PurchasingBackend.cart.assetList) {
            if(asset.getTotalCost() > 0) {
                groundInfrastructureChartData.add(new PieChart.Data(asset.name + ": " + df.format(asset.getGroundInfrastructureCost() * 100/total) + "%", asset.getGroundInfrastructureCost()));
            }
        }
        groundInfrastructureChart.setData(groundInfrastructureChartData);
    }
    public void populatePersonnel() {
        personnelChartData.clear();
        double total = 0;
        for(Asset asset : PurchasingBackend.cart.assetList) {
            total += asset.getPersonnelRequirement();
        }
        for(Asset asset : PurchasingBackend.cart.assetList) {
            if(asset.getTotalCost() > 0) {
                personnelChartData.add(new PieChart.Data(asset.name + ": " + df.format(asset.getPersonnelRequirement() * 100/total) + "%", asset.getPersonnelRequirement()));
            }
        }
        personnelChart.setData(personnelChartData);
    }
}
