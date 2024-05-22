package sample;

/**
 * This is the Login's page controller where we can control all of the login's buttons and functionality.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class LoginController {

    private Main mainApp;

    @FXML
    private TextField loginEmail;

    @FXML
    private TextField loginPassword;

    @FXML
    private Button loginButton;

    @FXML
    private TextField signupEmail;

    @FXML
    private TextField signupPassword;

    @FXML
    private Button signupButton;
    
    ObjectInputStream in=null;
    ObjectOutputStream out=null;
    Socket client = null;
    private static final int PORT = 4444;

    /**
     * This method sets the event for the login and signup buttons
     */

    @FXML
    private void initialize() {
        loginButton.setOnMouseClicked(clickEvent -> {
            this.logUserIn();
        });
        signupButton.setOnMouseClicked(clickEvent -> {
            this.signUserUp();
            signupEmail.setText("");
            signupPassword.setText("");
        });
    }

    /**
     * This method is used to verify login: it alerts if username or password are not correct and it
     * shows an alertbox if it's not, else it calls Main's method to choose the right layout
     * between admin and normal user layout.
     */


    private void logUserIn (){
        Person loggedIn = this.mainApp.getShop().login(loginEmail.getText(), loginPassword.getText());
        if (loggedIn == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid login");
            alert.setHeaderText(null);
            alert.setContentText("Check your email and your password");
            alert.showAndWait();
            return;
        }
        this.mainApp.setLoggedIn(loggedIn);
        if (loggedIn instanceof User)
            this.mainApp.initRootLayout();
        else
            this.mainApp.initAdminLayout();
    }

    /**
     * This method is used to sign up a new user, it sends you an alert message if username or password are missing
     * else it calls the Main method to save your account.
     * Finally it shows a welcome message
     */

    private void signUserUp() {
        if (signupEmail.getText().equals("") || signupPassword.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty deta");
            alert.setHeaderText(null);
            alert.setContentText("Enter the data");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (this.mainApp.getShop().signUp(signupEmail.getText(), signupPassword.getText())) {
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Welcome to the winery");
            alert.showAndWait();
        } else {
            alert.setTitle("Failed");
            alert.setHeaderText(null);
            alert.setContentText("Pre-existing user,check username and password");
            alert.showAndWait();
        }

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}
