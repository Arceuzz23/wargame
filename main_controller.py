import sys
from PyQt5.QtWidgets import QApplication, QLabel, QMainWindow, QMessageBox, QVBoxLayout, QWidget, QLineEdit
from PyQt5.uic import loadUi

class MainController(QMainWindow):
    def __init__(self):
        super(MainController, self).__init__()
        self.forceMetricsController = None
        self.forceParametersController = None
        self.forceCostController = None
        self.assetController = None
        self.purchasingController = None

        self.mainBorderPane = QWidget()
        self.titleLabel = QLabel("Welcome")
        self.titleScreenView = self.load_ui("TitleScreen.ui")
        self.forceMetricsView = self.load_ui("ForceMetrics.ui")
        self.forceParametersView = self.load_ui("ForceParameters.ui")
        self.forceCostView = self.load_ui("ForceCost.ui")
        self.assetView = self.load_ui("Asset.ui")
        self.purchasingView = self.load_ui("Purchasing.ui")

        layout = QVBoxLayout()
        layout.addWidget(self.titleLabel)
        layout.addWidget(self.mainBorderPane)
        self.setLayout(layout)

        self.initialize()

    def load_ui(self, filename):
        try:
            widget = loadUi(filename)
            if filename == "ForceMetrics.ui":
                self.forceMetricsController = widget
            elif filename == "ForceParameters.ui":
                self.forceParametersController = widget
            elif filename == "ForceCost.ui":
                self.forceCostController = widget
            elif filename == "Asset.ui":
                self.assetController = widget
            elif filename == "Purchasing.ui":
                self.purchasingController = widget
            return widget
        except Exception as e:
            print(e)
            sys.exit(1)

    def on_purchasing_click(self):
        self.purchasingController.populate()
        self.purchasingController.alert()
        self.mainBorderPane.setCentralWidget(self.purchasingView)
        self.titleLabel.setText("Purchasing")

    def on_force_parameters_click(self):
        self.forceParametersController.populate()
        self.mainBorderPane.setCentralWidget(self.forceParametersView)
        self.titleLabel.setText("Force Parameters")

    def on_force_cost_click(self):
        self.forceCostController.populate()
        self.mainBorderPane.setCentralWidget(self.forceCostView)
        self.titleLabel.setText("Force Cost")

    def on_force_metrics_click(self):
        self.forceMetricsController.populate()
        self.mainBorderPane.setCentralWidget(self.forceMetricsView)
        self.titleLabel.setText("Force Metrics")

    def on_mq4c_click(self):
        self.assetController.populate(PurchasingBackend.cart.MQ4C)
        self.mainBorderPane.setCentralWidget(self.assetView)
        self.titleLabel.setText("Northrop Grumman MQ-4C Triton")

    def on_mq9b_click(self):
        self.assetController.populate(PurchasingBackend.cart.MQ9B)
        self.mainBorderPane.setCentralWidget(self.assetView)
        self.titleLabel.setText("GA Aeronautics MQ-9B SeaGuardian")

    def on_p1_click(self):
        self.assetController.populate(PurchasingBackend.cart.P1)
        self.mainBorderPane.setCentralWidget(self.assetView)
        self.titleLabel.setText("Kawasaki P-1")

    def on_integrator_click(self):
        self.assetController.populate(PurchasingBackend.cart.integrator)
        self.mainBorderPane.setCentralWidget(self.assetView)
        self.titleLabel.setText("Boeing Insitu Integrator ER")

    def on_rq58_click(self):
        self.assetController.populate(PurchasingBackend.cart.RQ58)
        self.mainBorderPane.setCentralWidget(self.assetView)
        self.titleLabel.setText("Kratos RQ-58 Valkyrie")

    def on_thunderhead_click(self):
        self.assetController.populate(PurchasingBackend.cart.thunderhead)
        self.mainBorderPane.setCentralWidget(self.assetView)
        self.titleLabel.setText("Raven Aerostar Thunderhead")

    @staticmethod
    def get_int(field):
        try:
            return int(field.text())
        except ValueError:
            msg = QMessageBox()
            msg.setIcon(QMessageBox.Warning)
            msg.setText("Please ensure the text you entered is an integer.")
            msg.setStandardButtons(QMessageBox.Ok)
            msg.exec_()
            return 0

    def initialize(self):
        self.mainBorderPane.setCentralWidget(self.titleScreenView)
        self.titleLabel.setText("Welcome")

if __name__ == "__main__":
    app = QApplication(sys.argv)
    mainController = MainController()
    mainController.show()
    sys.exit(app.exec_())
