package sample;

/**
 * This is the controller for the Admin's homepage where we can control the Ship button
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AdminHomeOverview {

    private Main mainApp;

    @FXML
    private Text pendingOrdersNo;

    @FXML
    private Button shipButton;

    /**
     * This method sets the event for the Ship button and calls the Main's method to ship al the pending
     * orders.
     * Finally it sends an "ok" message
     */

    @FXML
    private void initialize() {
        shipButton.setOnMouseClicked(clickEvent -> {
            this.mainApp.getShop().shipWines((Seller) this.mainApp.getLoggedIn());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText(null);
            alert.setContentText("Shipped all the pending orders. Good job!");
            alert.showAndWait();
            this.pendingOrdersNo.setText("0");
            shipButton.setDisable(true);
        });
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        Integer pendingOrders = this.mainApp.getShop().getPendingOrdersNo();
        this.pendingOrdersNo.setText(pendingOrders.toString());
        if (pendingOrders.equals(0)) {
            shipButton.setDisable(true);
        }
    }
}
