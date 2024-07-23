package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class AssetController {
    @FXML private ImageView assetImageViewer;
    @FXML private Label flavorText, baselineInitialPackage, baselineAnnualOAndS, baselinePersonnelRequired, additionalProcurement, additionalOAndS, additionalPersonnelRequired, additionalGCS, maxRange, cruiseSpeed, cruiseAltitudeFt, cruiseAltitudeM;
    @FXML private GridPane baselineGrid, GCSGrid;
    public void populate(Asset asset) {
        if(asset.name.equals("P-1")) {
            baselineInitialPackage.setText("N/A");
            baselineAnnualOAndS.setText("N/A");
            baselinePersonnelRequired.setText("N/A");
            additionalGCS.setText("N/A");
        }
        else if (asset.name.equals("Thunderhead")){
            baselineInitialPackage.setText(PurchasingBackend.priceFormat(asset.UAVCost * 4 + asset.baseCost + asset.GCSCost * 2));
            baselineAnnualOAndS.setText(PurchasingBackend.priceFormat(9200000));
            baselinePersonnelRequired.setText("32");
            additionalGCS.setText(PurchasingBackend.priceFormat(asset.GCSCost));
        }
        else {
            baselineInitialPackage.setText(PurchasingBackend.priceFormat(asset.UAVCost * 4 + asset.baseCost + asset.GCSCost * 2));
            baselineAnnualOAndS.setText(PurchasingBackend.priceFormat(asset.OAndSCost * 4));
            baselinePersonnelRequired.setText("" + (asset.personnelRequired * 4));
            additionalGCS.setText(PurchasingBackend.priceFormat(asset.GCSCost));
        }
        assetImageViewer.setImage(asset.image);
        flavorText.setText(asset.flavorText);
        additionalProcurement.setText(PurchasingBackend.priceFormat(asset.UAVCost));
        additionalOAndS.setText(PurchasingBackend.priceFormat(asset.OAndSCost));
        additionalPersonnelRequired.setText("" + asset.personnelRequired);
        maxRange.setText("" + asset.maxRange);
        cruiseSpeed.setText("" + asset.cruiseSpeed);
        cruiseAltitudeFt.setText("" + asset.cruiseAltitudeFt);
        cruiseAltitudeM.setText("" + asset.getCruiseAltitudeM());
    }
}
