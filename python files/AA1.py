#!/usr/bin/env python
# package: com.example.demo
import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.FileChooser
import javafx.stage.Stage
import javafx.stage.WindowEvent
import java.io.IOException
import java.io.PrintWriter
import java.io.File
import java.util.Scanner

class AssetApplication(Application):
    """ generated source for class AssetApplication """
    def start(self, stage):
        """ generated source for method start """
        fileChooser = FileChooser()
        fileChooser.setTitle("Please choose Log File from folder")
        fileChooser.getExtensionFilters().add(FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv"))
        file_ = fileChooser.showOpenDialog(stage)
        stage.getIcons().add(Image(AssetApplication.__class__.getResourceAsStream("icon.png")))
        root = FXMLLoader.load(AssetApplication.__class__.getResource("MainUI.fxml"))
        stage.setTitle("JMSDF ISR Wargame")
        stage.setScene(Scene(root))
        stage.setResizable(True)
        readCSV(file_)
        stage.setOnCloseRequest(EventHandler())
        stage.show()

    @classmethod
    def main(cls, args):
        """ generated source for method main """
        launch()

    def writeCSV(self, file_):
        """ generated source for method writeCSV """
        try:
            lineBuilder.append("Asset Name,")
            lineBuilder.append("Units Purchased,")
            lineBuilder.append("GCS/Launchers Purchased,")
            lineBuilder.append("Average Opposing Wind (kn),")
            lineBuilder.append("Cruise Altitude (ft),")
            lineBuilder.append("Availability Rate (*10),")
            lineBuilder.append("Range to Sweep Width Conversion (*10),")
            lineBuilder.append("Revisit Rate (hrs),")
            lineBuilder.append("Area of Regard (nm^2)")
            pw.write(lineBuilder + "\n")
            for asset in PurchasingBackend.cart.assetList:
                lineBuilder = StringBuilder()
                lineBuilder.append(asset.name + ",")
                lineBuilder.append(asset.UAVPurchased + ",")
                lineBuilder.append(asset.GCSPurchased + ",")
                lineBuilder.append(asset.averageOpposingWind + ",")
                lineBuilder.append(asset.cruiseAltitudeFt + ",")
                lineBuilder.append(asset.availabilityRate + ",")
                lineBuilder.append(asset.rangeToSweepWidthConversion + ",")
                lineBuilder.append(asset.revisitRate + ",")
                lineBuilder.append(asset.areaOfRegard + "")
                pw.write(lineBuilder + "\n")
            pw.write("Initial Budget ($)," + PurchasingBackend.cart.initialBudget + "\n")
            pw.flush()
            pw.close()
        except Exception as e:
            return

    def readCSV(self, file_):
        """ generated source for method readCSV """
        try:
            csv.nextLine()
            for asset in PurchasingBackend.cart.assetList:
                line = csv.nextLine().split(",")
                asset.UAVPurchased = Integer.parseInt(line[1])
                asset.GCSPurchased = Integer.parseInt(line[2])
                asset.averageOpposingWind = Integer.parseInt(line[3])
                asset.cruiseAltitudeFt = Integer.parseInt(line[4])
                asset.availabilityRate = Integer.parseInt(line[5])
                asset.rangeToSweepWidthConversion = Integer.parseInt(line[6])
                asset.revisitRate = Integer.parseInt(line[7])
                asset.areaOfRegard = Integer.parseInt(line[8])
            line = csv.nextLine().split(",")
            PurchasingBackend.cart.initialBudget = Long.parseLong(line[1])
        except Exception as e:
            return