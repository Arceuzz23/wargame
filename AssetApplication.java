package com.example.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class AssetApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Please choose Log File from folder");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv"));
        File file = fileChooser.showOpenDialog(stage);
        stage.getIcons().add(new Image(AssetApplication.class.getResourceAsStream("icon.png")));
        Parent root = FXMLLoader.load(AssetApplication.class.getResource("MainUI.fxml"));
        stage.setTitle("JMSDF ISR Wargame");
        stage.setScene(new Scene(root));
        stage.setResizable(true);
        readCSV(file);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                writeCSV(file);
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public void writeCSV(File file) {
        try {
            PrintWriter pw = new PrintWriter(file);
            StringBuilder lineBuilder = new StringBuilder();
            lineBuilder.append("Asset Name,");
            lineBuilder.append("Units Purchased,");
            lineBuilder.append("GCS/Launchers Purchased,");
            lineBuilder.append("Average Opposing Wind (kn),");
            lineBuilder.append("Cruise Altitude (ft),");
            lineBuilder.append("Availability Rate (*10),");
            lineBuilder.append("Range to Sweep Width Conversion (*10),");
            lineBuilder.append("Revisit Rate (hrs),");
            lineBuilder.append("Area of Regard (nm^2)");
            pw.write(lineBuilder + "\n");
            for(Asset asset : PurchasingBackend.cart.assetList) {
                lineBuilder = new StringBuilder();
                lineBuilder.append(asset.name + ",");
                lineBuilder.append(asset.UAVPurchased + ",");
                lineBuilder.append(asset.GCSPurchased + ",");
                lineBuilder.append(asset.averageOpposingWind + ",");
                lineBuilder.append(asset.cruiseAltitudeFt + ",");
                lineBuilder.append(asset.availabilityRate + ",");
                lineBuilder.append(asset.rangeToSweepWidthConversion + ",");
                lineBuilder.append(asset.revisitRate + ",");
                lineBuilder.append(asset.areaOfRegard + "");
                pw.write(lineBuilder + "\n");
            }
            pw.write("Initial Budget ($)," + PurchasingBackend.cart.initialBudget + "\n");
            pw.flush();
            pw.close();
        } catch (Exception e) {
            return;
        }
    }
    public void readCSV(File file) {
        try {
            Scanner csv = new Scanner(file);
            csv.nextLine();
            String[] line;
            for(Asset asset : PurchasingBackend.cart.assetList) {
                line = csv.nextLine().split(",");
                asset.UAVPurchased = Integer.parseInt(line[1]);
                asset.GCSPurchased = Integer.parseInt(line[2]);
                asset.averageOpposingWind = Integer.parseInt(line[3]);
                asset.cruiseAltitudeFt = Integer.parseInt(line[4]);
                asset.availabilityRate = Integer.parseInt(line[5]);
                asset.rangeToSweepWidthConversion = Integer.parseInt(line[6]);
                asset.revisitRate = Integer.parseInt(line[7]);
                asset.areaOfRegard = Integer.parseInt(line[8]);
            }
            line = csv.nextLine().split(",");
            PurchasingBackend.cart.initialBudget = Long.parseLong(line[1]);
        } catch (Exception e) {
            return;
        }
    }
}