from tkinter import Label, PhotoImage
from tkinter.ttk import Grid

class AssetController:
    def __init__(self):
        self.assetImageViewer = None
        self.flavorText = None
        self.baselineInitialPackage = None
        self.baselineAnnualOAndS = None
        self.baselinePersonnelRequired = None
        self.additionalProcurement = None
        self.additionalOAndS = None
        self.additionalPersonnelRequired = None
        self.additionalGCS = None
        self.maxRange = None
        self.cruiseSpeed = None
        self.cruiseAltitudeFt = None
        self.cruiseAltitudeM = None
        self.baselineGrid = None
        self.GCSGrid = None

    def populate(self, asset):
        if asset.name == "P-1":
            self.baselineInitialPackage.config(text="N/A")
            self.baselineAnnualOAndS.config(text="N/A")
            self.baselinePersonnelRequired.config(text="N/A")
            self.additionalGCS.config(text="N/A")
        elif asset.name == "Thunderhead":
            self.baselineInitialPackage.config(text=PurchasingBackend.priceFormat(asset.UAVCost * 4 + asset.baseCost + asset.GCSCost * 2))
            self.baselineAnnualOAndS.config(text=PurchasingBackend.priceFormat(9200000))
            self.baselinePersonnelRequired.config(text="32")
            self.additionalGCS.config(text=PurchasingBackend.priceFormat(asset.GCSCost))
        else:
            self.baselineInitialPackage.config(text=PurchasingBackend.priceFormat(asset.UAVCost * 4 + asset.baseCost + asset.GCSCost * 2))
            self.baselineAnnualOAndS.config(text=PurchasingBackend.priceFormat(asset.OAndSCost * 4))
            self.baselinePersonnelRequired.config(text=str(asset.personnelRequired * 4))
            self.additionalGCS.config(text=PurchasingBackend.priceFormat(asset.GCSCost))

        self.assetImageViewer.config(image=asset.image)
        self.flavorText.config(text=asset.flavorText)
        self.additionalProcurement.config(text=PurchasingBackend.priceFormat(asset.UAVCost))
        self.additionalOAndS.config(text=PurchasingBackend.priceFormat(asset.OAndSCost))
        self.additionalPersonnelRequired.config(text=str(asset.personnelRequired))
        self.maxRange.config(text=str(asset.maxRange))
        self.cruiseSpeed.config(text=str(asset.cruiseSpeed))
        self.cruiseAltitudeFt.config(text=str(asset.cruiseAltitudeFt))
        self.cruiseAltitudeM.config(text=str(asset.getCruiseAltitudeM()))


