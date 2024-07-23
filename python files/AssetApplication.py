import tkinter as tk
from tkinter import filedialog
import csv

class AssetApplication:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("JMSDF ISR Wargame")
        self.root.iconphoto(True, tk.PhotoImage(file="icon.png"))
        
        # Load UI from a separate file (assuming MainUI.py exists)
        from MainUI import create_ui
        create_ui(self.root)
        
        self.root.resizable(True, True)
        
        self.file = self.choose_file()
        if self.file:
            self.read_csv(self.file)
        
        self.root.protocol("WM_DELETE_WINDOW", self.on_closing)
        
    def choose_file(self):
        file = filedialog.askopenfilename(
            title="Please choose Log File from folder",
            filetypes=[("CSV Files", "*.csv")]
        )
        return file if file else None
    
    def on_closing(self):
        if self.file:
            self.write_csv(self.file)
        self.root.destroy()
    
    def write_csv(self, file):
        try:
            with open(file, 'w', newline='') as csvfile:
                writer = csv.writer(csvfile)
                writer.writerow([
                    "Asset Name", "Units Purchased", "GCS/Launchers Purchased",
                    "Average Opposing Wind (kn)", "Cruise Altitude (ft)",
                    "Availability Rate (*10)", "Range to Sweep Width Conversion (*10)",
                    "Revisit Rate (hrs)", "Area of Regard (nm^2)"
                ])
                for asset in PurchasingBackend.cart.assetList:
                    writer.writerow([
                        asset.name, asset.UAVPurchased, asset.GCSPurchased,
                        asset.averageOpposingWind, asset.cruiseAltitudeFt,
                        asset.availabilityRate, asset.rangeToSweepWidthConversion,
                        asset.revisitRate, asset.areaOfRegard
                    ])
                writer.writerow(["Initial Budget ($)", PurchasingBackend.cart.initialBudget])
        except Exception:
            pass
    
    def read_csv(self, file):
        try:
            with open(file, 'r') as csvfile:
                reader = csv.reader(csvfile)
                next(reader)  # Skip header
                for asset, row in zip(PurchasingBackend.cart.assetList, reader):
                    asset.UAVPurchased = int(row[1])
                    asset.GCSPurchased = int(row[2])
                    asset.averageOpposingWind = int(row[3])
                    asset.cruiseAltitudeFt = int(row[4])
                    asset.availabilityRate = int(row[5])
                    asset.rangeToSweepWidthConversion = int(row[6])
                    asset.revisitRate = int(row[7])
                    asset.areaOfRegard = int(row[8])
        except Exception:
            pass
    
    def run(self):
        self.root.mainloop()

if __name__ == "__main__":
    app = AssetApplication()
    app.run()

