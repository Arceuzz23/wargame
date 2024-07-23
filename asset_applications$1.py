import os
from functools import partial
from javafx.event import EventHandler
from javafx.stage import WindowEvent

class AssetApplication:
    def write_csv(self, file):
        # Implementation of writeCSV method
        pass

class AssetApplicationHandler:
    def __init__(self, asset_application, file):
        self.asset_application = asset_application
        self.file = file

    def handle(self, we):
        self.asset_application.write_csv(self.file)

# Example usage
asset_application = AssetApplication()
file = os.path.join("path", "to", "file.csv")
handler = AssetApplicationHandler(asset_application, file)
# Assuming `we` is an instance of WindowEvent
# handler.handle(we)


