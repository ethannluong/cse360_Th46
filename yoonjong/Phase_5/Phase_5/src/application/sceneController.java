package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.*;

// Author : Yoonjong Jang

public class sceneController {
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;
	@FXML
	private Label labelOne; // (user story) label on the Planning Poker console
	@FXML
	private Label labelTwo; // (points) label on the Planning Poker console
	@FXML
	private TextArea textOne; // TextArea on the Planning Poker console
	@FXML
	private Button buttonOne; // Save button on the Planning Poker console
	@FXML
	private Button buttonTwo; // Search button on the Planning Poker console
	@FXML
	private Button buttonThree; // "1" button on the Planning Poker console
	@FXML
	private Button buttonFour; // "2" button on the Planning Poker console
	@FXML
	private Button buttonFive; // "3" button on the Planning Poker console
	@FXML
	private Button buttonSix; // "4" button on the Planning Poker console
	@FXML
	private Button buttonSeven; // "5" button on the Planning Poker console
	@FXML
	private Button buttonEight; // "6" button on the Planning Poker console
	@FXML
	private Button buttonNine; // "7" button on the Planning Poker console
	@FXML
	private Button buttonTen; // "8" button on the Planning Poker console
	@FXML
	private Button buttonEleven; // "9" button on the Planning Poker console
	@FXML
	private Button buttonTwelve; // "10" button on the Planning Poker console
	
	private String userStory;
	private int points;
	
	// Method that will let the button to switch to the Effort Logger Console
	@FXML
	public void sceneOne(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("mainConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
		
	// Method that will let the button to switch to the Effort Log Editor
	@FXML
	public void sceneTwo(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("editConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
		
	// Method that will let the button to switch to the Defect Console
	@FXML
	public void sceneThree(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("defectConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	// Method that will let the button to switch to the Planning Poker Console
	@FXML
	public void sceneFour(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ppokerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	// Method that will let the button to switch to the Story Point Console
	@FXML
	public void sceneFive(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("pointConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	// Method that will save the user story the user has entered
	@FXML
	public void storyInput(ActionEvent event) throws IOException {
		userStory = textOne.getText();
		System.out.println(userStory);
	}
	
	// Method that displays the user story the user has searched
	@FXML
	public void setLabel(ActionEvent event) throws IOException {
		labelOne.setText(userStory);
	}
	
	// Method that lets the user to give 1 story point to the user story
	@FXML
	public void setLabelTwo(ActionEvent event) throws IOException {
		points = 1;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 2 story points to the user story
	@FXML
	public void setLabelThree(ActionEvent event) throws IOException {
		points = 2;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 3 story points to the user story
	@FXML
	public void setLabelFour(ActionEvent event) throws IOException {
		points = 3;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 4 story points to the user story
	@FXML
	public void setLabelFive(ActionEvent event) throws IOException {
		points = 4;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 5 story points to the user story
	@FXML
	public void setLabelSix(ActionEvent event) throws IOException {
		points = 5;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 6 story points to the user story
	@FXML
	public void setLabelSeven(ActionEvent event) throws IOException {
		points = 6;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 7 story points to the user story
	@FXML
	public void setLabelEight(ActionEvent event) throws IOException {
		points = 7;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 8 story points to the user story
	@FXML
	public void setLabelNine(ActionEvent event) throws IOException {
		points = 8;
		labelTwo.setText(points + "");
	}
		
	// Method that lets the user to give 9 story points to the user story
	@FXML
	public void setLabelTen(ActionEvent event) throws IOException {
		points = 9;
		labelTwo.setText(points + "");
	}
			
	// Method that lets the user to give 10 story points to the user story
	@FXML
	public void setLabelEleven(ActionEvent event) throws IOException {
		points = 10;
		labelTwo.setText(points + "");
	}
}
