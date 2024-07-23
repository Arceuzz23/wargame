package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.math.BigDecimal;

public class ForceParametersController {
    @FXML private Label MQ4CMaxRange, MQ4CCruiseSpeed, MQ4CAverageNetSpeed, MQ4CTotalEndurance, MQ4CRangeToHorizon, MQ4CAreaSweepPerHour;
    @FXML private Label MQ9BMaxRange, MQ9BCruiseSpeed, MQ9BAverageNetSpeed, MQ9BTotalEndurance, MQ9BRangeToHorizon, MQ9BAreaSweepPerHour;
    @FXML private Label integratorMaxRange, integratorCruiseSpeed, integratorAverageNetSpeed, integratorTotalEndurance, integratorRangeToHorizon, integratorAreaSweepPerHour;
    @FXML private Label P1MaxRange, P1CruiseSpeed, P1AverageNetSpeed, P1TotalEndurance, P1RangeToHorizon, P1AreaSweepPerHour;
    @FXML private Label RQ58MaxRange, RQ58CruiseSpeed, RQ58AverageNetSpeed, RQ58TotalEndurance, RQ58RangeToHorizon, RQ58AreaSweepPerHour;
    @FXML private Label thunderheadMaxRange, thunderheadCruiseSpeed, thunderheadAverageNetSpeed, thunderheadTotalEndurance, thunderheadRangeToHorizon, thunderheadAreaSweepPerHour;
    @FXML private ComboBox<Integer> MQ4CAverageOpposingWind, MQ9BAverageOpposingWind, integratorAverageOpposingWind, P1AverageOpposingWind, RQ58AverageOpposingWind;
    @FXML private ComboBox<Integer> MQ4CCruiseAltitudeFt, MQ9BCruiseAltitudeFt, integratorCruiseAltitudeFt, P1CruiseAltitudeFt, RQ58CruiseAltitudeFt, thunderheadCruiseAltitudeFt;
    @FXML private Label MQ4CCruiseAltitudeM, MQ9BCruiseAltitudeM, integratorCruiseAltitudeM, P1CruiseAltitudeM, RQ58CruiseAltitudeM, thunderheadCruiseAltitudeM;
    @FXML private ComboBox<Integer> MQ4CAvailabilityRate, MQ9BAvailabilityRate, integratorAvailabilityRate, P1AvailabilityRate, RQ58AvailabilityRate, thunderheadAvailabilityRate;
    @FXML private ComboBox<Integer> MQ4CRangeToSweepWidthConversion, MQ9BRangeToSweepWidthConversion, integratorRangeToSweepWidthConversion, P1RangeToSweepWidthConversion, RQ58RangeToSweepWidthConversion, thunderheadRangeToSweepWidthConversion;
    @FXML private ComboBox<Integer> MQ4CRevisitRate, MQ9BRevisitRate, integratorRevisitRate, P1RevisitRate, RQ58RevisitRate, thunderheadRevisitRate;
    @FXML private ComboBox<Integer> MQ4CAreaOfRegard, MQ9BAreaOfRegard, integratorAreaOfRegard, P1AreaOfRegard, RQ58AreaOfRegard, thunderheadAreaOfRegard;
    @FXML private BarChart<String, Integer> timeOnStationChart;
    @FXML public void onUpdate() {
        update();
        populate();
    }
    public void update() {
        updateMQ4C();
        updateMQ9B();
        updateIntegrator();
        updateP1();
        updateRQ58();
        updateThunderhead();
    }
    public void populate() {
        populateMQ4C();
        populateMQ9B();
        populateIntegrator();
        populateP1();
        populateRQ58();
        populateThunderhead();
        populateTimeOnStationChart();
    }
    public void populateMQ4C() {
        MQ4CMaxRange.setText("" + PurchasingBackend.cart.MQ4C.maxRange);
        MQ4CCruiseSpeed.setText("" + PurchasingBackend.cart.MQ4C.cruiseSpeed);
        MQ4CAverageNetSpeed.setText("" + PurchasingBackend.cart.MQ4C.getAverageNetSpeed());
        MQ4CTotalEndurance.setText("" + (int) PurchasingBackend.cart.MQ4C.getTotalEndurance());
        MQ4CCruiseAltitudeM.setText("" + PurchasingBackend.cart.MQ4C.getCruiseAltitudeM());
        MQ4CRangeToHorizon.setText("" + (int) PurchasingBackend.cart.MQ4C.getRangeToHorizon());
        MQ4CAreaSweepPerHour.setText("" + (int) PurchasingBackend.cart.MQ4C.getAreaSweepPerHour());
    }
    public void populateMQ9B() {
        MQ9BMaxRange.setText("" + PurchasingBackend.cart.MQ9B.maxRange);
        MQ9BCruiseSpeed.setText("" + PurchasingBackend.cart.MQ9B.cruiseSpeed);
        MQ9BAverageNetSpeed.setText("" + PurchasingBackend.cart.MQ9B.getAverageNetSpeed());
        MQ9BTotalEndurance.setText("" + (int) PurchasingBackend.cart.MQ9B.getTotalEndurance());
        MQ9BCruiseAltitudeM.setText("" + PurchasingBackend.cart.MQ9B.getCruiseAltitudeM());
        MQ9BRangeToHorizon.setText("" + (int) PurchasingBackend.cart.MQ9B.getRangeToHorizon());
        MQ9BAreaSweepPerHour.setText("" + (int) PurchasingBackend.cart.MQ9B.getAreaSweepPerHour());
    }
    public void populateIntegrator() {
        integratorMaxRange.setText("" + PurchasingBackend.cart.integrator.maxRange);
        integratorCruiseSpeed.setText("" + PurchasingBackend.cart.integrator.cruiseSpeed);
        integratorAverageNetSpeed.setText("" + PurchasingBackend.cart.integrator.getAverageNetSpeed());
        integratorTotalEndurance.setText("" + (int) PurchasingBackend.cart.integrator.getTotalEndurance());
        integratorCruiseAltitudeM.setText("" + PurchasingBackend.cart.integrator.getCruiseAltitudeM());
        integratorRangeToHorizon.setText("" + (int) PurchasingBackend.cart.integrator.getRangeToHorizon());
        integratorAreaSweepPerHour.setText("" + (int) PurchasingBackend.cart.integrator.getAreaSweepPerHour());
    }
    public void populateP1() {
        P1MaxRange.setText("" + PurchasingBackend.cart.P1.maxRange);
        P1CruiseSpeed.setText("" + PurchasingBackend.cart.P1.cruiseSpeed);
        P1AverageNetSpeed.setText("" + PurchasingBackend.cart.P1.getAverageNetSpeed());
        P1TotalEndurance.setText("" + (int) PurchasingBackend.cart.P1.getTotalEndurance());
        P1CruiseAltitudeM.setText("" + PurchasingBackend.cart.P1.getCruiseAltitudeM());
        P1RangeToHorizon.setText("" + (int) PurchasingBackend.cart.P1.getRangeToHorizon());
        P1AreaSweepPerHour.setText("" + (int) PurchasingBackend.cart.P1.getAreaSweepPerHour());
    }
    public void populateRQ58() {
        RQ58MaxRange.setText("" + PurchasingBackend.cart.RQ58.maxRange);
        RQ58CruiseSpeed.setText("" + PurchasingBackend.cart.RQ58.cruiseSpeed);
        RQ58AverageNetSpeed.setText("" + PurchasingBackend.cart.RQ58.getAverageNetSpeed());
        RQ58TotalEndurance.setText("" + (int) PurchasingBackend.cart.RQ58.getTotalEndurance());
        RQ58CruiseAltitudeM.setText("" + PurchasingBackend.cart.RQ58.getCruiseAltitudeM());
        RQ58RangeToHorizon.setText("" + (int) PurchasingBackend.cart.RQ58.getRangeToHorizon());
        RQ58AreaSweepPerHour.setText("" + (int) PurchasingBackend.cart.RQ58.getAreaSweepPerHour());
    }
    public void populateThunderhead() {
        thunderheadMaxRange.setText("" + PurchasingBackend.cart.thunderhead.maxRange);
        thunderheadCruiseSpeed.setText("" + PurchasingBackend.cart.thunderhead.cruiseSpeed);
        thunderheadAverageNetSpeed.setText("" + PurchasingBackend.cart.thunderhead.getAverageNetSpeed());
        thunderheadTotalEndurance.setText("" + (int) PurchasingBackend.cart.thunderhead.getTotalEndurance());
        thunderheadCruiseAltitudeM.setText("" + PurchasingBackend.cart.thunderhead.getCruiseAltitudeM());
        thunderheadRangeToHorizon.setText("" + (int) PurchasingBackend.cart.thunderhead.getRangeToHorizon());
        thunderheadAreaSweepPerHour.setText("" + (int) PurchasingBackend.cart.thunderhead.getAreaSweepPerHour());
    }
    public void populateTimeOnStationChart() {
        timeOnStationChart.getData().clear();
        int[] radii = {100, 500, 1000, 1500};
        for(int r : radii) {
            XYChart.Series series = new XYChart.Series();
            series.setName("" + r + "nm");
            for(Asset asset : PurchasingBackend.cart.assetList) {
                if(asset.getAverageTimeOnStation(r) < 0) {
                    continue;
                }
                if(asset.name.equals("Thunderhead")) {
                    series.getData().add(new XYChart.Data(asset.name, asset.getAverageTimeOnStation(r)/72));
                }
                else {
                    series.getData().add(new XYChart.Data(asset.name, asset.getAverageTimeOnStation(r)));
                }
            }
            timeOnStationChart.getData().add(series);
        }
    }
    public void updateMQ4C() {
        PurchasingBackend.cart.MQ4C.averageOpposingWind = MQ4CAverageOpposingWind.getValue();
        PurchasingBackend.cart.MQ4C.cruiseAltitudeFt = MQ4CCruiseAltitudeFt.getValue();
        PurchasingBackend.cart.MQ4C.availabilityRate = MQ4CAvailabilityRate.getValue();
        PurchasingBackend.cart.MQ4C.rangeToSweepWidthConversion = MQ4CRangeToSweepWidthConversion.getValue();
        PurchasingBackend.cart.MQ4C.revisitRate = MQ4CRevisitRate.getValue();
        PurchasingBackend.cart.MQ4C.areaOfRegard = MQ4CAreaOfRegard.getValue();
    }
    public void updateMQ9B() {
        PurchasingBackend.cart.MQ9B.averageOpposingWind = MQ9BAverageOpposingWind.getValue();
        PurchasingBackend.cart.MQ9B.cruiseAltitudeFt = MQ9BCruiseAltitudeFt.getValue();
        PurchasingBackend.cart.MQ9B.availabilityRate = MQ9BAvailabilityRate.getValue();
        PurchasingBackend.cart.MQ9B.rangeToSweepWidthConversion = MQ9BRangeToSweepWidthConversion.getValue();
        PurchasingBackend.cart.MQ9B.revisitRate = MQ9BRevisitRate.getValue();
        PurchasingBackend.cart.MQ9B.areaOfRegard = MQ9BAreaOfRegard.getValue();
    }
    public void updateIntegrator() {
        PurchasingBackend.cart.integrator.averageOpposingWind = integratorAverageOpposingWind.getValue();
        PurchasingBackend.cart.integrator.cruiseAltitudeFt = integratorCruiseAltitudeFt.getValue();
        PurchasingBackend.cart.integrator.availabilityRate = integratorAvailabilityRate.getValue();
        PurchasingBackend.cart.integrator.rangeToSweepWidthConversion = integratorRangeToSweepWidthConversion.getValue();
        PurchasingBackend.cart.integrator.revisitRate = integratorRevisitRate.getValue();
        PurchasingBackend.cart.integrator.areaOfRegard = integratorAreaOfRegard.getValue();
    }
    public void updateP1() {
        PurchasingBackend.cart.P1.averageOpposingWind = P1AverageOpposingWind.getValue();
        PurchasingBackend.cart.P1.cruiseAltitudeFt = P1CruiseAltitudeFt.getValue();
        PurchasingBackend.cart.P1.availabilityRate = P1AvailabilityRate.getValue();
        PurchasingBackend.cart.P1.rangeToSweepWidthConversion = P1RangeToSweepWidthConversion.getValue();
        PurchasingBackend.cart.P1.revisitRate = P1RevisitRate.getValue();
        PurchasingBackend.cart.P1.areaOfRegard = P1AreaOfRegard.getValue();
    }
    public void updateRQ58() {
        PurchasingBackend.cart.RQ58.averageOpposingWind = RQ58AverageOpposingWind.getValue();
        PurchasingBackend.cart.RQ58.cruiseAltitudeFt = RQ58CruiseAltitudeFt.getValue();
        PurchasingBackend.cart.RQ58.availabilityRate = RQ58AvailabilityRate.getValue();
        PurchasingBackend.cart.RQ58.rangeToSweepWidthConversion = RQ58RangeToSweepWidthConversion.getValue();
        PurchasingBackend.cart.RQ58.revisitRate = RQ58RevisitRate.getValue();
        PurchasingBackend.cart.RQ58.areaOfRegard = RQ58AreaOfRegard.getValue();
    }
    public void updateThunderhead() {
        PurchasingBackend.cart.thunderhead.cruiseAltitudeFt = thunderheadCruiseAltitudeFt.getValue();
        PurchasingBackend.cart.thunderhead.availabilityRate = thunderheadAvailabilityRate.getValue();
        PurchasingBackend.cart.thunderhead.rangeToSweepWidthConversion = thunderheadRangeToSweepWidthConversion.getValue();
        PurchasingBackend.cart.thunderhead.revisitRate = thunderheadRevisitRate.getValue();
        PurchasingBackend.cart.thunderhead.areaOfRegard = thunderheadAreaOfRegard.getValue();
    }
    public void initialize() {
        for(int i = 0; i <= 100; i += 5) {
            MQ4CAverageOpposingWind.getItems().add(i);
            MQ9BAverageOpposingWind.getItems().add(i);
            integratorAverageOpposingWind.getItems().add(i);
            P1AverageOpposingWind.getItems().add(i);
            RQ58AverageOpposingWind.getItems().add(i);
        }
        MQ4CAverageOpposingWind.setValue(0);
        MQ9BAverageOpposingWind.setValue(0);
        integratorAverageOpposingWind.setValue(0);
        P1AverageOpposingWind.setValue(0);
        RQ58AverageOpposingWind.setValue(0);
        for(int i = 0; i <= 75000; i += 5000) {
            MQ4CCruiseAltitudeFt.getItems().add(i);
            MQ9BCruiseAltitudeFt.getItems().add(i);
            integratorCruiseAltitudeFt.getItems().add(i);
            P1CruiseAltitudeFt.getItems().add(i);
            RQ58CruiseAltitudeFt.getItems().add(i);
            thunderheadCruiseAltitudeFt.getItems().add(i);
        }
        MQ4CCruiseAltitudeFt.setValue(50000);
        MQ9BCruiseAltitudeFt.setValue(30000);
        integratorCruiseAltitudeFt.setValue(15000);
        P1CruiseAltitudeFt.setValue(35000);
        RQ58CruiseAltitudeFt.setValue(30000);
        thunderheadCruiseAltitudeFt.setValue(65000);
        for(int i = 1; i <= 9; i ++) {
            MQ4CAvailabilityRate.getItems().add(i);
            MQ9BAvailabilityRate.getItems().add(i);
            integratorAvailabilityRate.getItems().add(i);
            P1AvailabilityRate.getItems().add(i);
            RQ58AvailabilityRate.getItems().add(i);
            thunderheadAvailabilityRate.getItems().add(i);
        }
        MQ4CAvailabilityRate.setValue(7);
        MQ9BAvailabilityRate.setValue(9);
        integratorAvailabilityRate.setValue(9);
        P1AvailabilityRate.setValue(7);
        RQ58AvailabilityRate.setValue(9);
        thunderheadAvailabilityRate.setValue(9);
        for(int i = 1; i <= 9; i ++) {
            MQ4CRangeToSweepWidthConversion.getItems().add(i);
            MQ9BRangeToSweepWidthConversion.getItems().add(i);
            integratorRangeToSweepWidthConversion.getItems().add(i);
            P1RangeToSweepWidthConversion.getItems().add(i);
            RQ58RangeToSweepWidthConversion.getItems().add(i);
            thunderheadRangeToSweepWidthConversion.getItems().add(i);
        }
        MQ4CRangeToSweepWidthConversion.setValue(9);
        MQ9BRangeToSweepWidthConversion.setValue(9);
        integratorRangeToSweepWidthConversion.setValue(6);
        P1RangeToSweepWidthConversion.setValue(9);
        RQ58RangeToSweepWidthConversion.setValue(6);
        thunderheadRangeToSweepWidthConversion.setValue(6);
        for(int i = 1; i <= 24; i ++) {
            MQ4CRevisitRate.getItems().add(i);
            MQ9BRevisitRate.getItems().add(i);
            integratorRevisitRate.getItems().add(i);
            P1RevisitRate.getItems().add(i);
            RQ58RevisitRate.getItems().add(i);
            thunderheadRevisitRate.getItems().add(i);
        }
        MQ4CRevisitRate.setValue(2);
        MQ9BRevisitRate.setValue(2);
        integratorRevisitRate.setValue(2);
        P1RevisitRate.setValue(2);
        RQ58RevisitRate.setValue(2);
        thunderheadRevisitRate.setValue(24);
        for(int i = 50000; i <= 3000000; i += 50000) {
            MQ4CAreaOfRegard.getItems().add(i);
            MQ9BAreaOfRegard.getItems().add(i);
            integratorAreaOfRegard.getItems().add(i);
            P1AreaOfRegard.getItems().add(i);
            RQ58AreaOfRegard.getItems().add(i);
            thunderheadAreaOfRegard.getItems().add(i);
        }
        MQ4CAreaOfRegard.setValue(300000);
        MQ9BAreaOfRegard.setValue(300000);
        integratorAreaOfRegard.setValue(300000);
        P1AreaOfRegard.setValue(300000);
        RQ58AreaOfRegard.setValue(300000);
        thunderheadAreaOfRegard.setValue(300000);
        populate();
        update();
    }
}