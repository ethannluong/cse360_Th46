package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class function {
    @FXML
    private PasswordField password;
    @FXML
    private Button test;
    @FXML
    private Label valid;

    String code;

    private String adminUsername = "admin";
    private String adminPassword = "admin";

    public void submit(ActionEvent event) throws IOException {
        code = password.getText();
        if (isValidPassword(code)) {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("User Login");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Text sceneTitle = new Text("Authorization Check");
            sceneTitle.setTextAlignment(TextAlignment.CENTER);
            sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
            grid.add(sceneTitle, 0, 0, 2, 1);

            Label userName = new Label("Email Id:");
            grid.add(userName, 0, 1);

            TextField userTextField = new TextField();
            grid.add(userTextField, 1, 1);

            Label pw = new Label("Password:");
            grid.add(pw, 0, 2);

            PasswordField passwordBox = new PasswordField();
            grid.add(passwordBox, 1, 2);

            Button btn = new Button("Sign in");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 1, 4);

            Button btn2 = new Button("Create Account");
            HBox hbBtn2 = new HBox(10);
            hbBtn2.setAlignment(Pos.BASELINE_LEFT);
            hbBtn2.getChildren().add(btn2);
            grid.add(hbBtn2, 0, 4);

            final Text actiontarget = new Text();
            grid.add(actiontarget, 1, 6);

            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    String username = userTextField.getText().toString();
                    String password = passwordBox.getText().toString();

                    if (userTextField.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, "Form Error!",
                                "Please enter your email id");
                        return;
                    }
                    if (passwordBox.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, "Form Error!",
                                "Please enter a password");
                        return;
                    }

                    if (adminUsername.equals(username) && adminPassword.equals(password)) {
                        infoBox("Login Successful!", null, "Success");
                        try {
                			// Open the Effort Logger Console first when executed
                			Parent root = FXMLLoader.load(getClass().getResource("mainConsole.fxml"));
                			Scene scene = new Scene(root,700,600);
                			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                			primaryStage.setScene(scene);
                			primaryStage.show();
                		} catch(Exception e1) {
                			e1.printStackTrace();
                		}
                    } else {
                        infoBox("Please enter correct Email and Password", null, "Failed");
                    }
                }
            });

            btn2.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent a) {
                    // ... (rest of the code for btn2 action)
                    primaryStage.show();
                }
            });

            Scene scene = new Scene(grid, 300, 275);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            valid.setText("Password is invalid!");
        }
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 10) return false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
            if (hasUpperCase && hasSpecialChar) return true;
        }
        return false;
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}
