package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class PurchasingController {
    @FXML private Label MQ4CTally, MQ4CGCSTally, MQ4CSpend, MQ4COAndS, MQ4CPersonnel;
    @FXML private Label MQ9BTally, MQ9BGCSTally, MQ9BSpend, MQ9BOAndS, MQ9BPersonnel;
    @FXML private Label P1Tally, P1Spend, P1OAndS, P1Personnel;
    @FXML private Label integratorTally, integratorGCSTally, integratorSpend, integratorOAndS, integratorPersonnel;
    @FXML private Label RQ58Tally, RQ58GCSTally, RQ58Spend, RQ58OAndS, RQ58Personnel;
    @FXML private Label thunderheadTally, thunderheadGCSTally, thunderheadSpend, thunderheadOAndS, thunderheadPersonnel;
    @FXML private Label UAVPurchased, GCSPurchased, totalSpend, totalOAndS, totalPersonnel;
    @FXML private Label budget;
    @FXML private void onMQ4CIncrement(ActionEvent e) {
        int curr = MainController.getInt(MQ4CTally);
        if(curr == 0) {
            MQ4CTally.setText("4");
            if(MainController.getInt(MQ4CGCSTally) < 2) {
                MQ4CGCSTally.setText("2");
            }
        }
        else {
            MQ4CTally.setText("" + (curr + 1));
        }
        onTickerClick();
    }
    @FXML private void onMQ4CDecrement(ActionEvent e) {
        int curr = MainController.getInt(MQ4CTally);
        if(curr == 0) {
            return;
        }
        if(curr == 4) {
            MQ4CTally.setText("0");
            MQ4CGCSTally.setText("0");
        }
        else {
            MQ4CTally.setText("" + (curr - 1));
        }
        onTickerClick();
    }
    @FXML private void onMQ4CGCSIncrement(ActionEvent e) {
        int curr = MainController.getInt(MQ4CGCSTally);
        if(MainController.getInt(MQ4CTally) <= 0) {
            return;
        }
        MQ4CGCSTally.setText("" + (curr + 1));
        onTickerClick();
    }
    @FXML private void onMQ4CGCSDecrement(ActionEvent e) {
        int curr = MainController.getInt(MQ4CGCSTally);
        if((curr == 0) || ((MainController.getInt(MQ4CTally) > 0) && (curr <= 2))) {
            return;
        }
        MQ4CGCSTally.setText("" + (curr - 1));
        onTickerClick();
    }
    @FXML private void onMQ9BIncrement(ActionEvent e) {
        int curr = MainController.getInt(MQ9BTally);
        if(curr == 0) {
            MQ9BTally.setText("4");
            if(MainController.getInt(MQ9BGCSTally) < 2) {
                MQ9BGCSTally.setText("2");
            }
        }
        else {
            MQ9BTally.setText("" + (curr + 1));
        }
        onTickerClick();
    }
    @FXML private void onMQ9BDecrement(ActionEvent e) {
        int curr = MainController.getInt(MQ9BTally);
        if(curr == 0) {
            return;
        }
        if(curr == 4) {
            MQ9BTally.setText("0");
            MQ9BGCSTally.setText("0");
        }
        else {
            MQ9BTally.setText("" + (curr - 1));
        }
        onTickerClick();
    }
    @FXML private void onMQ9BGCSIncrement(ActionEvent e) {
        int curr = MainController.getInt(MQ9BGCSTally);
        if(MainController.getInt(MQ9BTally) <= 0) {
            return;
        }
        MQ9BGCSTally.setText("" + (curr + 1));
        onTickerClick();
    }
    @FXML private void onMQ9BGCSDecrement(ActionEvent e) {
        int curr = MainController.getInt(MQ9BGCSTally);
        if((curr == 0) || ((MainController.getInt(MQ9BTally) > 0) && (curr <= 2))) {
            return;
        }
        MQ9BGCSTally.setText("" + (curr - 1));
        onTickerClick();
    }
    @FXML private void onIntegratorIncrement(ActionEvent e) {
        int curr = MainController.getInt(integratorTally);
        if(curr == 0) {
            integratorTally.setText("4");
            if(MainController.getInt(integratorGCSTally) < 2) {
                integratorGCSTally.setText("2");
            }
        }
        else {
            integratorTally.setText("" + (curr + 1));
        }
        onTickerClick();
    }
    @FXML private void onIntegratorDecrement(ActionEvent e) {
        int curr = MainController.getInt(integratorTally);
        if(curr == 0) {
            return;
        }
        if(curr == 4) {
            integratorTally.setText("0");
            integratorGCSTally.setText("0");
        }
        else {
            integratorTally.setText("" + (curr - 1));
        }
        onTickerClick();
    }
    @FXML private void onIntegratorGCSIncrement(ActionEvent e) {
        int curr = MainController.getInt(integratorGCSTally);
        if(MainController.getInt(integratorTally) <= 0) {
            return;
        }
        integratorGCSTally.setText("" + (curr + 1));
        onTickerClick();
    }
    @FXML private void onIntegratorGCSDecrement(ActionEvent e) {
        int curr = MainController.getInt(integratorGCSTally);
        if((curr == 0) || ((MainController.getInt(integratorTally) > 0) && (curr <= 2))) {
            return;
        }
        integratorGCSTally.setText("" + (curr - 1));
        onTickerClick();
    }
    @FXML private void onP1Increment(ActionEvent e) {
        int curr = MainController.getInt(P1Tally);
        P1Tally.setText("" + (curr + 1));
        onTickerClick();
    }
    @FXML private void onP1Decrement(ActionEvent e) {
        int curr = MainController.getInt(P1Tally);
        if(curr == 0) {
            return;
        }
        P1Tally.setText("" + (curr - 1));
        onTickerClick();
    }
    @FXML private void onRQ58Increment(ActionEvent e) {
        int curr = MainController.getInt(RQ58Tally);
        if(curr == 0) {
            RQ58Tally.setText("4");
            if(MainController.getInt(RQ58GCSTally) < 2) {
                RQ58GCSTally.setText("2");
            }
        }
        else {
            RQ58Tally.setText("" + (curr + 1));
        }
        onTickerClick();
    }
    @FXML private void onRQ58Decrement(ActionEvent e) {
        int curr = MainController.getInt(RQ58Tally);
        if(curr == 0) {
            return;
        }
        if(curr == 4) {
            RQ58Tally.setText("0");
            RQ58GCSTally.setText("0");
        }
        else {
            RQ58Tally.setText("" + (curr - 1));
        }
        onTickerClick();
    }
    @FXML private void onRQ58GCSIncrement(ActionEvent e) {
        int curr = MainController.getInt(RQ58GCSTally);
        if(MainController.getInt(RQ58Tally) <= 0) {
            return;
        }
        RQ58GCSTally.setText("" + (curr + 1));
        onTickerClick();
    }
    @FXML private void onRQ58GCSDecrement(ActionEvent e) {
        int curr = MainController.getInt(RQ58GCSTally);
        if((curr == 0) || ((MainController.getInt(RQ58Tally) > 0) && (curr <= 2))) {
            return;
        }
        RQ58GCSTally.setText("" + (curr - 1));
        onTickerClick();
    }
    @FXML private void onThunderheadIncrement(ActionEvent e) {
        int curr = MainController.getInt(thunderheadTally);
        if(curr == 0) {
            thunderheadTally.setText("4");
            if(MainController.getInt(thunderheadGCSTally) < 2) {
                thunderheadGCSTally.setText("2");
            }
        }
        else {
            thunderheadTally.setText("" + (curr + 1));
        }
        onTickerClick();
    }
    @FXML private void onThunderheadDecrement(ActionEvent e) {
        int curr = MainController.getInt(thunderheadTally);
        if(curr == 0) {
            return;
        }
        if(curr == 4) {
            thunderheadTally.setText("0");
            thunderheadGCSTally.setText("0");
        }
        else {
            thunderheadTally.setText("" + (curr - 1));
        }
        onTickerClick();
    }
    @FXML private void onThunderheadGCSIncrement(ActionEvent e) {
        int curr = MainController.getInt(thunderheadGCSTally);
        if(MainController.getInt(thunderheadTally) <= 0) {
            return;
        }
        thunderheadGCSTally.setText("" + (curr + 1));
        onTickerClick();
    }
    @FXML private void onBudgetDecrement(ActionEvent e) {
        long curr = PurchasingBackend.cart.initialBudget;
        if(curr <= 100000000) {
            return;
        }
        PurchasingBackend.cart.initialBudget -= 100000000;
        onTickerClick();
    }
    @FXML private void onBudgetIncrement(ActionEvent e) {
        PurchasingBackend.cart.initialBudget += 100000000;
        onTickerClick();
    }
    @FXML private void onThunderheadGCSDecrement(ActionEvent e) {
        int curr = MainController.getInt(thunderheadGCSTally);
        if((curr == 0) || ((MainController.getInt(thunderheadTally) > 0) && (curr <= 2))) {
            return;
        }
        thunderheadGCSTally.setText("" + (curr - 1));
        onTickerClick();
    }
    public void populate() {
        //Populate UAV tallies
        MQ4CTally.setText("" + PurchasingBackend.cart.MQ4C.UAVPurchased);
        MQ9BTally.setText("" + PurchasingBackend.cart.MQ9B.UAVPurchased);
        P1Tally.setText("" + PurchasingBackend.cart.P1.UAVPurchased);
        integratorTally.setText("" + PurchasingBackend.cart.integrator.UAVPurchased);
        RQ58Tally.setText("" + PurchasingBackend.cart.RQ58.UAVPurchased);
        thunderheadTally.setText("" + PurchasingBackend.cart.thunderhead.UAVPurchased);
        //Populate GCS tallies
        MQ4CGCSTally.setText("" + PurchasingBackend.cart.MQ4C.GCSPurchased);
        MQ9BGCSTally.setText("" + PurchasingBackend.cart.MQ9B.GCSPurchased);
        integratorGCSTally.setText("" + PurchasingBackend.cart.integrator.GCSPurchased);
        RQ58GCSTally.setText("" + PurchasingBackend.cart.RQ58.GCSPurchased);
        thunderheadGCSTally.setText("" + PurchasingBackend.cart.thunderhead.GCSPurchased);
        //Populates procurement prices
        MQ4CSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ4C.getTotalCost()));
        MQ9BSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ9B.getTotalCost()));
        integratorSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.integrator.getTotalCost()));
        P1Spend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.P1.getTotalCost()));
        RQ58Spend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.RQ58.getTotalCost()));
        thunderheadSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.thunderhead.getTotalCost()));
        //Populates O&S prices
        MQ4COAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ4C.getOAndSCost()));
        MQ9BOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ9B.getOAndSCost()));
        integratorOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.integrator.getOAndSCost()));
        P1OAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.P1.getOAndSCost()));
        RQ58OAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.RQ58.getOAndSCost()));
        thunderheadOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.thunderhead.getOAndSCost()));
        //Populates personnel requirement
        MQ4CPersonnel.setText("" + PurchasingBackend.cart.MQ4C.getPersonnelRequirement());
        MQ9BPersonnel.setText("" + PurchasingBackend.cart.MQ9B.getPersonnelRequirement());
        integratorPersonnel.setText("" + PurchasingBackend.cart.integrator.getPersonnelRequirement());
        P1Personnel.setText("" + PurchasingBackend.cart.P1.getPersonnelRequirement());
        RQ58Personnel.setText("" + PurchasingBackend.cart.RQ58.getPersonnelRequirement());
        thunderheadPersonnel.setText("" + PurchasingBackend.cart.thunderhead.getPersonnelRequirement());
        //Populates totals
        UAVPurchased.setText("" + PurchasingBackend.cart.getTotalUAV());
        GCSPurchased.setText("" + PurchasingBackend.cart.getTotalGCS());
        totalSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.getTotalSpend()));
        totalOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.getOAndSSpend()));
        totalPersonnel.setText("" + PurchasingBackend.cart.getPersonnelRequirement());
        budget.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.initialBudget));
    }
    public void alert() {
        if((PurchasingBackend.cart.getTotalSpend() > PurchasingBackend.cart.initialBudget)) {
            totalSpend.setTextFill(Color.rgb(161, 0, 0));
        } else {
            totalSpend.setTextFill(Color.BLACK);
        }
    }
    private void onTickerClick() {
        PurchasingBackend.cart.MQ4C.UAVPurchased = MainController.getInt(MQ4CTally);
        PurchasingBackend.cart.MQ9B.UAVPurchased = MainController.getInt(MQ9BTally);
        PurchasingBackend.cart.P1.UAVPurchased = MainController.getInt(P1Tally);
        PurchasingBackend.cart.integrator.UAVPurchased = MainController.getInt(integratorTally);
        PurchasingBackend.cart.RQ58.UAVPurchased = MainController.getInt(RQ58Tally);
        PurchasingBackend.cart.thunderhead.UAVPurchased = MainController.getInt(thunderheadTally);
        PurchasingBackend.cart.MQ4C.GCSPurchased = MainController.getInt(MQ4CGCSTally);
        PurchasingBackend.cart.MQ9B.GCSPurchased = MainController.getInt(MQ9BGCSTally);
        PurchasingBackend.cart.integrator.GCSPurchased = MainController.getInt(integratorGCSTally);
        PurchasingBackend.cart.RQ58.GCSPurchased = MainController.getInt(RQ58GCSTally);
        PurchasingBackend.cart.thunderhead.GCSPurchased = MainController.getInt(thunderheadGCSTally);
        populate();
        alert();
    }
    public void initialize() {
        populate();
        alert();
    }
}
