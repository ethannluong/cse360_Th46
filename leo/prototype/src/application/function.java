package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class function {
	@FXML
	private PasswordField password;
	@FXML
	private Button test;
	@FXML
	private Label valid;
	
	String code;
	
	public void submit(ActionEvent event) throws IOException
	{
		 code = password.getText();
	        if (isValidPassword(code)) {
	            valid.setText("Password is valid!");
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
}
