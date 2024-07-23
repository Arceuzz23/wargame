import os
import csv
from tkinter import Tk, filedialog
from tkinter.messagebox import showinfo
from PIL import Image, ImageTk
import tkinter as tk

class Asset:
    def __init__(self, name, UAVPurchased, GCSPurchased, averageOpposingWind, cruiseAltitudeFt, availabilityRate, rangeToSweepWidthConversion, revisitRate, areaOfRegard):
        self.name = name
        self.UAVPurchased = UAVPurchased
        self.GCSPurchased = GCSPurchased
        self.averageOpposingWind = averageOpposingWind
        self.cruiseAltitudeFt = cruiseAltitudeFt
        self.availabilityRate = availabilityRate
        self.rangeToSweepWidthConversion = rangeToSweepWidthConversion
        self.revisitRate = revisitRate
        self.areaOfRegard = areaOfRegard

class PurchasingBackend:
    class Cart:
        def __init__(self):
            self.assetList = []
            self.initialBudget = 0

    cart = Cart()

class AssetApplication(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("JMSDF ISR Wargame")
        self.iconphoto(False, ImageTk.PhotoImage(Image.open("icon.png")))
        self.geometry("800x600")
        self.resizable(True, True)
        self.protocol("WM_DELETE_WINDOW", self.on_closing)
        self.file = None
        self.readCSV(self.file)
        self.mainloop()

    def on_closing(self):
        if self.file:
            self.writeCSV(self.file)
        self.destroy()

    def writeCSV(self, file):
        try:
            with open(file, 'w', newline='') as csvfile:
                writer = csv.writer(csvfile)
                writer.writerow(["Asset Name", "Units Purchased", "GCS/Launchers Purchased", "Average Opposing Wind (kn)", "Cruise Altitude (ft)", "Availability Rate (*10)", "Range to Sweep Width Conversion (*10)", "Revisit Rate (hrs)", "Area of Regard (nm^2)"])
                for asset in PurchasingBackend.cart.assetList:
                    writer.writerow([asset.name, asset.UAVPurchased, asset.GCSPurchased, asset.averageOpposingWind, asset.cruiseAltitudeFt, asset.availabilityRate, asset.rangeToSweepWidthConversion, asset.revisitRate, asset.areaOfRegard])
                writer.writerow(["Initial Budget ($)", PurchasingBackend.cart.initialBudget])
        except Exception as e:
            print(e)

    def readCSV(self, file):
        try:
            with open(file, 'r') as csvfile:
                reader = csv.reader(csvfile)
                next(reader)  # Skip header
                for asset, line in zip(PurchasingBackend.cart.assetList, reader):
                    asset.UAVPurchased = int(line[1])
                    asset.GCSPurchased = int(line[2])
                    asset.averageOpposingWind = int(line[3])
                    asset.cruiseAltitudeFt = int(line[4])
                    asset.availabilityRate = int(line[5])
                    asset.rangeToSweepWidthConversion = int(line[6])
                    asset.revisitRate = int(line[7])
                    asset.areaOfRegard = int(line[8])
                line = next(reader)
                PurchasingBackend.cart.initialBudget = int(line[1])
        except Exception as e:
            print(e)

if __name__ == "__main__":
    root = Tk()
    root.withdraw()  # Hide the root window
    file_path = filedialog.askopenfilename(title="Please choose Log File from folder", filetypes=[("CSV Files", "*.csv")])
    if file_path:
        app = AssetApplication()
        app.file = file_path
        app.readCSV(file_path)
    else:
        showinfo("No file selected", "No file was selected. Exiting application.")
        root.destroy()





