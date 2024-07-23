import matplotlib.pyplot as plt
from collections import namedtuple
import numpy as np

# Mocking the PurchasingBackend and Asset classes for the sake of this example
class PurchasingBackend:
    class cart:
        @staticmethod
        def getTotalSpend():
            return 1000000

        @staticmethod
        def getOAndSSpend():
            return 500000

        @staticmethod
        def getGroundInfrastructureSpend():
            return 300000

        @staticmethod
        def getPersonnelRequirement():
            return 200

        assetList = [
            namedtuple('Asset', 'name getProcurementCost getOAndSCost getGroundInfrastructureCost getPersonnelRequirement getTotalCost')(
                'Asset1', 100000, 50000, 30000, 20, 200000),
            namedtuple('Asset', 'name getProcurementCost getOAndSCost getGroundInfrastructureCost getPersonnelRequirement getTotalCost')(
                'Asset2', 200000, 100000, 60000, 40, 400000),
            # Add more assets as needed
        ]

class ForceCostController:
    def __init__(self):
        self.procurementChartData = []
        self.OAndSChartData = []
        self.groundInfrastructureChartData = []
        self.personnelChartData = []

    def populate(self):
        print("Total: " + self.priceFormat(PurchasingBackend.cart.getTotalSpend()))
        print("Total: " + self.priceFormat(PurchasingBackend.cart.getOAndSSpend()))
        print("Total: " + self.priceFormat(PurchasingBackend.cart.getGroundInfrastructureSpend()))
        print("Total: " + str(PurchasingBackend.cart.getPersonnelRequirement()) + " people")
        self.populateProcurement()
        self.populateOAndS()
        self.populateGroundInfrastructure()
        self.populatePersonnel()

    def priceFormat(self, price):
        return f"${price:,.2f}"

    def populateProcurement(self):
        self.procurementChartData.clear()
        total = sum(asset.getProcurementCost for asset in PurchasingBackend.cart.assetList)
        for asset in PurchasingBackend.cart.assetList:
            if asset.getTotalCost > 0:
                percentage = (asset.getProcurementCost * 100) / total
                self.procurementChartData.append((asset.name, percentage, asset.getProcurementCost))
        self.plotPieChart(self.procurementChartData, "Procurement Chart")

    def populateOAndS(self):
        self.OAndSChartData.clear()
        total = sum(asset.getOAndSCost for asset in PurchasingBackend.cart.assetList)
        for asset in PurchasingBackend.cart.assetList:
            if asset.getTotalCost > 0:
                percentage = (asset.getOAndSCost * 100) / total
                self.OAndSChartData.append((asset.name, percentage, asset.getOAndSCost))
        self.plotPieChart(self.OAndSChartData, "OAndS Chart")

    def populateGroundInfrastructure(self):
        self.groundInfrastructureChartData.clear()
        total = sum(asset.getGroundInfrastructureCost for asset in PurchasingBackend.cart.assetList)
        for asset in PurchasingBackend.cart.assetList:
            if asset.getTotalCost > 0:
                percentage = (asset.getGroundInfrastructureCost * 100) / total
                self.groundInfrastructureChartData.append((asset.name, percentage, asset.getGroundInfrastructureCost))
        self.plotPieChart(self.groundInfrastructureChartData, "Ground Infrastructure Chart")

    def populatePersonnel(self):
        self.personnelChartData.clear()
        total = sum(asset.getPersonnelRequirement for asset in PurchasingBackend.cart.assetList)
        for asset in PurchasingBackend.cart.assetList:
            if asset.getTotalCost > 0:
                percentage = (asset.getPersonnelRequirement * 100) / total
                self.personnelChartData.append((asset.name, percentage, asset.getPersonnelRequirement))
        self.plotPieChart(self.personnelChartData, "Personnel Chart")

    def plotPieChart(self, data, title):
        labels, sizes, _ = zip(*data)
        fig1, ax1 = plt.subplots()
        ax1.pie(sizes, labels=labels, autopct='%1.1f%%', startangle=90)
        ax1.axis('equal')  # Equal aspect ratio ensures that pie is drawn as a circle.
        plt.title(title)
        plt.show()

# Example usage
controller = ForceCostController()
controller.populate()


