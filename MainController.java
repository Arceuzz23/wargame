package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;


public class MainController {
    //Declares controllers
    private ForceMetricsController forceMetricsController;
    private ForceParametersController forceParametersController;
    private ForceCostController forceCostController;
    private AssetController assetController;
    private PurchasingController purchasingController;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Label titleLabel;
    //Loads FXML and controllers for child panes
    private Node loadFXML(String filename) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
            Node node = loader.load();
            switch(filename) {
                case "ForceMetrics.fxml":
                    forceMetricsController = loader.getController();
                    break;
                case "ForceParameters.fxml":
                    forceParametersController = loader.getController();
                    break;
                case "ForceCost.fxml":
                    forceCostController = loader.getController();
                    break;
                case "Asset.fxml":
                    assetController = loader.getController();
                    break;
                case "Purchasing.fxml":
                    purchasingController = loader.getController();
                    break;
            }
            return node;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
    private Node titleScreenView = loadFXML("TitleScreen.fxml");
    private Node forceMetricsView = loadFXML("ForceMetrics.fxml");
    private Node forceParametersView = loadFXML("ForceParameters.fxml");
    private Node forceCostView = loadFXML("ForceCost.fxml");
    private Node assetView = loadFXML("Asset.fxml");
    private Node purchasingView = loadFXML("Purchasing.fxml");


    @FXML
    private void onPurchasingClick (ActionEvent e) {
        purchasingController.populate();
        purchasingController.alert();
        mainBorderPane.setCenter(purchasingView);
        titleLabel.setText("Purchasing");

    }
    @FXML
    private void onForceParametersClick(ActionEvent e) {
        forceParametersController.populate();
        mainBorderPane.setCenter(forceParametersView);
        titleLabel.setText("Force Parameters");
    }
    @FXML
    private void onForceCostClick (ActionEvent e) {
        forceCostController.populate();
        mainBorderPane.setCenter(forceCostView);
        titleLabel.setText("Force Cost");
    }
    @FXML private void onForceMetricsClick (ActionEvent e) {
        forceMetricsController.populate();
        mainBorderPane.setCenter(forceMetricsView);
        titleLabel.setText("Force Metrics");
    }
    @FXML
    private void onMQ4CClick (ActionEvent e) {
        assetController.populate(PurchasingBackend.cart.MQ4C);
        mainBorderPane.setCenter(assetView);
        titleLabel.setText("Northrop Grumman MQ-4C Triton");
    }
    @FXML
    private void onMQ9BClick (ActionEvent e) {
        assetController.populate(PurchasingBackend.cart.MQ9B);
        mainBorderPane.setCenter(assetView);
        titleLabel.setText("GA Aeronautics MQ-9B SeaGuardian");
    }
    @FXML
    private void onP1Click (ActionEvent e) {
        assetController.populate(PurchasingBackend.cart.P1);
        mainBorderPane.setCenter(assetView);
        titleLabel.setText("Kawasaki P-1");
    }
    @FXML
    private void onIntegratorClick (ActionEvent e) {
        assetController.populate(PurchasingBackend.cart.integrator);
        mainBorderPane.setCenter(assetView);
        titleLabel.setText("Boeing Insitu Integrator ER");
    }
    @FXML
    private void onRQ58Click (ActionEvent e) {
        assetController.populate(PurchasingBackend.cart.RQ58);
        mainBorderPane.setCenter(assetView);
        titleLabel.setText("Kratos RQ-58 Valkyrie");
    }
    @FXML
    private void onThunderheadClick (ActionEvent e) {
        assetController.populate(PurchasingBackend.cart.thunderhead);
        mainBorderPane.setCenter(assetView);
        titleLabel.setText("Raven Aerostar Thunderhead");
    }
    //Basic utilities
    public static int getInt(Label field) {
        int num = 0;
        try {
            num = Integer.parseInt(field.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please ensure the text you entered is an integer.", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            return num;
        }
        return num;
    }
    public static int getInt(TextField field) {
        int num = 0;
        try {
            num = Integer.parseInt(field.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please ensure the text you entered is an integer.", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            return num;
        }
        return num;
    }
    public void initialize() {
        mainBorderPane.setCenter(titleScreenView);
        titleLabel.setText("Welcome");
    }
}