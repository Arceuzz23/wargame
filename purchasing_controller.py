from javafx.event import ActionEvent
from javafx.fxml import FXML
from javafx.scene.control import Label
from javafx.scene.paint import Color

class PurchasingController:
    @FXML
    private Label MQ4CTally
    @FXML
    private Label MQ4CGCSTally
    @FXML
    private Label MQ4CSpend
    @FXML
    private Label MQ4COAndS
    @FXML
    private Label MQ4CPersonnel
    @FXML
    private Label MQ9BTally
    @FXML
    private Label MQ9BGCSTally
    @FXML
    private Label MQ9BSpend
    @FXML
    private Label MQ9BOAndS
    @FXML
    private Label MQ9BPersonnel
    @FXML
    private Label P1Tally
    @FXML
    private Label P1Spend
    @FXML
    private Label P1OAndS
    @FXML
    private Label P1Personnel
    @FXML
    private Label integratorTally
    @FXML
    private Label integratorGCSTally
    @FXML
    private Label integratorSpend
    @FXML
    private Label integratorOAndS
    @FXML
    private Label integratorPersonnel
    @FXML
    private Label RQ58Tally
    @FXML
    private Label RQ58GCSTally
    @FXML
    private Label RQ58Spend
    @FXML
    private Label RQ58OAndS
    @FXML
    private Label RQ58Personnel
    @FXML
    private Label thunderheadTally
    @FXML
    private Label thunderheadGCSTally
    @FXML
    private Label thunderheadSpend
    @FXML
    private Label thunderheadOAndS
    @FXML
    private Label thunderheadPersonnel
    @FXML
    private Label UAVPurchased
    @FXML
    private Label GCSPurchased
    @FXML
    private Label totalSpend
    @FXML
    private Label totalOAndS
    @FXML
    private Label totalPersonnel
    @FXML
    private Label budget

    def __init__(self):
        pass

    @FXML
    private def onMQ4CIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ4CTally)
        if curr == 0:
            self.MQ4CTally.setText("4")
            if MainController.getInt(self.MQ4CGCSTally) < 2:
                self.MQ4CGCSTally.setText("2")
        else:
            self.MQ4CTally.setText(str(curr + 1))

        self.onTickerClick()

    @FXML
    private def onMQ4CDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ4CTally)
        if curr != 0:
            if curr == 4:
                self.MQ4CTally.setText("0")
                self.MQ4CGCSTally.setText("0")
            else:
                self.MQ4CTally.setText(str(curr - 1))

            self.onTickerClick()

    @FXML
    private def onMQ4CGCSIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ4CGCSTally)
        if MainController.getInt(self.MQ4CTally) > 0:
            self.MQ4CGCSTally.setText(str(curr + 1))
            self.onTickerClick()

    @FXML
    private def onMQ4CGCSDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ4CGCSTally)
        if curr != 0 and (MainController.getInt(self.MQ4CTally) <= 0 or curr > 2):
            self.MQ4CGCSTally.setText(str(curr - 1))
            self.onTickerClick()

    @FXML
    private def onMQ9BIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ9BTally)
        if curr == 0:
            self.MQ9BTally.setText("4")
            if MainController.getInt(self.MQ9BGCSTally) < 2:
                self.MQ9BGCSTally.setText("2")
        else:
            self.MQ9BTally.setText(str(curr + 1))

        self.onTickerClick()

    @FXML
    private def onMQ9BDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ9BTally)
        if curr != 0:
            if curr == 4:
                self.MQ9BTally.setText("0")
                self.MQ9BGCSTally.setText("0")
            else:
                self.MQ9BTally.setText(str(curr - 1))

            self.onTickerClick()

    @FXML
    private def onMQ9BGCSIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ9BGCSTally)
        if MainController.getInt(self.MQ9BTally) > 0:
            self.MQ9BGCSTally.setText(str(curr + 1))
            self.onTickerClick()

    @FXML
    private def onMQ9BGCSDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.MQ9BGCSTally)
        if curr != 0 and (MainController.getInt(self.MQ9BTally) <= 0 or curr > 2):
            self.MQ9BGCSTally.setText(str(curr - 1))
            self.onTickerClick()

    @FXML
    private def onIntegratorIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.integratorTally)
        if curr == 0:
            self.integratorTally.setText("4")
            if MainController.getInt(self.integratorGCSTally) < 2:
                self.integratorGCSTally.setText("2")
        else:
            self.integratorTally.setText(str(curr + 1))

        self.onTickerClick()

    @FXML
    private def onIntegratorDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.integratorTally)
        if curr != 0:
            if curr == 4:
                self.integratorTally.setText("0")
                self.integratorGCSTally.setText("0")
            else:
                self.integratorTally.setText(str(curr - 1))

            self.onTickerClick()

    @FXML
    private def onIntegratorGCSIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.integratorGCSTally)
        if MainController.getInt(self.integratorTally) > 0:
            self.integratorGCSTally.setText(str(curr + 1))
            self.onTickerClick()

    @FXML
    private def onIntegratorGCSDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.integratorGCSTally)
        if curr != 0 and (MainController.getInt(self.integratorTally) <= 0 or curr > 2):
            self.integratorGCSTally.setText(str(curr - 1))
            self.onTickerClick()

    @FXML
    private def onP1Increment(self, e: ActionEvent):
        curr = MainController.getInt(self.P1Tally)
        self.P1Tally.setText(str(curr + 1))
        self.onTickerClick()

    @FXML
    private def onP1Decrement(self, e: ActionEvent):
        curr = MainController.getInt(self.P1Tally)
        if curr != 0:
            self.P1Tally.setText(str(curr - 1))
            self.onTickerClick()

    @FXML
    private def onRQ58Increment(self, e: ActionEvent):
        curr = MainController.getInt(self.RQ58Tally)
        if curr == 0:
            self.RQ58Tally.setText("4")
            if MainController.getInt(self.RQ58GCSTally) < 2:
                self.RQ58GCSTally.setText("2")
        else:
            self.RQ58Tally.setText(str(curr + 1))

        self.onTickerClick()

    @FXML
    private def onRQ58Decrement(self, e: ActionEvent):
        curr = MainController.getInt(self.RQ58Tally)
        if curr != 0:
            if curr == 4:
                self.RQ58Tally.setText("0")
                self.RQ58GCSTally.setText("0")
            else:
                self.RQ58Tally.setText(str(curr - 1))

            self.onTickerClick()

    @FXML
    private def onRQ58GCSIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.RQ58GCSTally)
        if MainController.getInt(self.RQ58Tally) > 0:
            self.RQ58GCSTally.setText(str(curr + 1))
            self.onTickerClick()

    @FXML
    private def onRQ58GCSDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.RQ58GCSTally)
        if curr != 0 and (MainController.getInt(self.RQ58Tally) <= 0 or curr > 2):
            self.RQ58GCSTally.setText(str(curr - 1))
            self.onTickerClick()

    @FXML
    private def onThunderheadIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.thunderheadTally)
        if curr == 0:
            self.thunderheadTally.setText("4")
            if MainController.getInt(self.thunderheadGCSTally) < 2:
                self.thunderheadGCSTally.setText("2")
        else:
            self.thunderheadTally.setText(str(curr + 1))

        self.onTickerClick()

    @FXML
    private def onThunderheadDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.thunderheadTally)
        if curr != 0:
            if curr == 4:
                self.thunderheadTally.setText("0")
                self.thunderheadGCSTally.setText("0")
            else:
                self.thunderheadTally.setText(str(curr - 1))

            self.onTickerClick()

    @FXML
    private def onThunderheadGCSIncrement(self, e: ActionEvent):
        curr = MainController.getInt(self.thunderheadGCSTally)
        if MainController.getInt(self.thunderheadTally) > 0:
            self.thunderheadGCSTally.setText(str(curr + 1))
            self.onTickerClick()

    @FXML
    private def onBudgetDecrement(self, e: ActionEvent):
        curr = PurchasingBackend.cart.initialBudget
        if curr > 100000000:
            PurchasingBackend.cart.initialBudget -= 100000000
            self.onTickerClick()

    @FXML
    private def onBudgetIncrement(self, e: ActionEvent):
        PurchasingBackend.cart.initialBudget += 100000000
        self.onTickerClick()

    @FXML
    private def onThunderheadGCSDecrement(self, e: ActionEvent):
        curr = MainController.getInt(self.thunderheadGCSTally)
        if curr != 0 and (MainController.getInt(self.thunderheadTally) <= 0 or curr > 2):
            self.thunderheadGCSTally.setText(str(curr - 1))
            self.onTickerClick()

    def populate(self):
        self.MQ4CTally.setText(str(PurchasingBackend.cart.MQ4C.UAVPurchased))
        self.MQ9BTally.setText(str(PurchasingBackend.cart.MQ9B.UAVPurchased))
        self.P1Tally.setText(str(PurchasingBackend.cart.P1.UAVPurchased))
        self.integratorTally.setText(str(PurchasingBackend.cart.integrator.UAVPurchased))
        self.RQ58Tally.setText(str(PurchasingBackend.cart.RQ58.UAVPurchased))
        self.thunderheadTally.setText(str(PurchasingBackend.cart.thunderhead.UAVPurchased))
        self.MQ4CGCSTally.setText(str(PurchasingBackend.cart.MQ4C.GCSPurchased))
        self.MQ9BGCSTally.setText(str(PurchasingBackend.cart.MQ9B.GCSPurchased))
        self.integratorGCSTally.setText(str(PurchasingBackend.cart.integrator.GCSPurchased))
        self.RQ58GCSTally.setText(str(PurchasingBackend.cart.RQ58.GCSPurchased))
        self.thunderheadGCSTally.setText(str(PurchasingBackend.cart.thunderhead.GCSPurchased))
        self.MQ4CSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ4C.getTotalCost()))
        self.MQ9BSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ9B.getTotalCost()))
        self.integratorSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.integrator.getTotalCost()))
        self.P1Spend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.P1.getTotalCost()))
        self.RQ58Spend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.RQ58.getTotalCost()))
        self.thunderheadSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.thunderhead.getTotalCost()))
        self.MQ4COAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ4C.getOAndSCost()))
        self.MQ9BOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.MQ9B.getOAndSCost()))
        self.integratorOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.integrator.getOAndSCost()))
        self.P1OAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.P1.getOAndSCost()))
        self.RQ58OAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.RQ58.getOAndSCost()))
        self.thunderheadOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.thunderhead.getOAndSCost()))
        self.MQ4CPersonnel.setText(str(PurchasingBackend.cart.MQ4C.getPersonnelRequirement()))
        self.MQ9BPersonnel.setText(str(PurchasingBackend.cart.MQ9B.getPersonnelRequirement()))
        self.integratorPersonnel.setText(str(PurchasingBackend.cart.integrator.getPersonnelRequirement()))
        self.P1Personnel.setText(str(PurchasingBackend.cart.P1.getPersonnelRequirement()))
        self.RQ58Personnel.setText(str(PurchasingBackend.cart.RQ58.getPersonnelRequirement()))
        self.thunderheadPersonnel.setText(str(PurchasingBackend.cart.thunderhead.getPersonnelRequirement()))
        self.UAVPurchased.setText(str(PurchasingBackend.cart.getTotalUAV()))
        self.GCSPurchased.setText(str(PurchasingBackend.cart.getTotalGCS()))
        self.totalSpend.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.getTotalSpend()))
        self.totalOAndS.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.getOAndSSpend()))
        self.totalPersonnel.setText(str(PurchasingBackend.cart.getPersonnelRequirement()))
        self.budget.setText(PurchasingBackend.priceFormat(PurchasingBackend.cart.initialBudget))

    def alert(self):
        if PurchasingBackend.cart.getTotalSpend() > PurchasingBackend.cart.initialBudget:
            self.totalSpend.setTextFill(Color.rgb(161, 0, 0))
        else:
            self.totalSpend.setTextFill(Color.BLACK)

    private def onTickerClick(self):
        PurchasingBackend.cart.MQ4C.UAVPurchased = MainController.getInt(self.MQ4CTally)
        PurchasingBackend.cart.MQ9B.UAVPurchased = MainController.getInt(self.MQ9BTally)
        PurchasingBackend.cart.P1.UAVPurchased = MainController.getInt(self.P1Tally)
        PurchasingBackend.cart.integrator.UAVPurchased = MainController.getInt(self.integratorTally)
        PurchasingBackend.cart.RQ58.UAVPurchased = MainController.getInt(self.RQ58Tally)
        PurchasingBackend.cart.thunderhead.UAVPurchased = MainController.getInt(self.thunderheadTally)
        PurchasingBackend.cart.MQ4C.GCSPurchased = MainController.getInt(self.MQ4CGCSTally)
        PurchasingBackend.cart.MQ9B.GCSPurchased = MainController.getInt(self.MQ9BGCSTally)
        PurchasingBackend.cart.integrator.GCSPurchased = MainController.getInt(self.integratorGCSTally)
        PurchasingBackend.cart.RQ58.GCSPurchased = MainController.getInt(self.RQ58GCSTally)
        PurchasingBackend.cart.thunderhead.GCSPurchased = MainController.getInt(self.thunderheadGCSTally)
        self.populate()
        self.alert()

    def initialize(self):
        self.populate()
        self.alert()

