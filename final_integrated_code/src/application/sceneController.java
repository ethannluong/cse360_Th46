package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.animation.PauseTransition;
import java.nio.*;

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
	
	public void scenceSix(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("EffortLoggerV2_LogModifier_Prototype.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
	
	
	//private void EffortLoggerV2_LogModifier_Prototype() {
		// TODO Auto-generated method stub
		String inputLogDirectory = "";
		String outputLogDirectory = "";
		String directory = "";
		
		public void start(Stage primaryStage) {
	        primaryStage.setTitle("EffortLoggerV2");
	        logFiles logFiles = new logFiles();
	        Button exportBtn = new Button();
	        Button selectInputFileBtn = new Button();
	        Button selectOutputFileBtn = new Button();
	        Button selectFolderBtn = new Button();
	        Button createNewLogFileBtn = new Button();
	        FileChooser fc = new FileChooser();
	        DirectoryChooser dc = new DirectoryChooser();
	        Label notify = new Label("");
	        notify.setLayoutX(200);
	        notify.setLayoutY(300);
	        PauseTransition notifyFade = new PauseTransition(Duration.seconds(3));
	        notifyFade.setOnFinished(event->notify.setText(""));
	        Label inputFileLabel = new Label("Input Log File:");
	        inputFileLabel.setLayoutX(50);
	        inputFileLabel.setLayoutY(50);
	        TextField inputFileText = new TextField();
	        inputFileText.setLayoutX(50);
	        inputFileText.setLayoutY(70);
	        inputFileText.setPrefWidth(300);
	        inputFileText.setEditable(false);
	        Label outputLogBoxLabel = new Label("Main Log File:");
	        outputLogBoxLabel.setLayoutX(50);
	        outputLogBoxLabel.setLayoutY(100);
	        TextField outputLogBox = new TextField();
	        outputLogBox.setLayoutX(50);
	        outputLogBox.setLayoutY(120);
	        outputLogBox.setPrefWidth(300);
	        outputLogBox.setEditable(false);
	        Label folderSelectLabel = new Label("Log Folder:");
	        folderSelectLabel.setLayoutX(50);
	        folderSelectLabel.setLayoutY(150);
	        TextField folderSelectBox = new TextField();
	        folderSelectBox.setLayoutX(50);
	        folderSelectBox.setLayoutY(170);
	        folderSelectBox.setPrefWidth(300);
	        folderSelectBox.setEditable(false);
	        CheckBox personalDataCheckBox = new CheckBox("Wipe Personal Data");
	        personalDataCheckBox.setLayoutX(600);
	        personalDataCheckBox.setLayoutY(100);
	        exportBtn.setText("Update Log");
	        exportBtn.setLayoutX(600);
	        exportBtn.setLayoutY(70);
	        exportBtn.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	if(logFiles.combineExistingLogFiles(inputLogDirectory,outputLogDirectory,personalDataCheckBox.isSelected()))
	            	{
	            		notify.setText("Log file "+inputLogDirectory+"\nsuccessfully appended into\n"+outputLogDirectory);
	            	}
	            	else
	            	{
	            		
	            	}
	            }
	        });
	        createNewLogFileBtn.setText("Create New Log");
	        createNewLogFileBtn.setLayoutX(550);
	        createNewLogFileBtn.setLayoutY(170);
	        createNewLogFileBtn.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	if(logFiles.createNewLog(directory))
	            	{
	            		notify.setText("New log file successfully created!");
	            		notifyFade.play();
	            	}
	            	else
	            	{
	            		notify.setText("Error in creating new log file.\nCheck directory.");
	            	}
	            }
	        });
	        selectInputFileBtn.setText("Select File");
	        selectInputFileBtn.setLayoutX(350);
	        selectInputFileBtn.setLayoutY(70);
	        selectInputFileBtn.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	File file = fc.showOpenDialog(primaryStage);
	            	inputLogDirectory = file.toString();
	            	inputFileText.setText(inputLogDirectory);
	            }
	        });
	        selectOutputFileBtn.setText("Select File");
	        selectOutputFileBtn.setLayoutX(350);
	        selectOutputFileBtn.setLayoutY(120);
	        selectOutputFileBtn.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	File file = fc.showOpenDialog(primaryStage);
	            	outputLogDirectory = file.toString();
	            	outputLogBox.setText(outputLogDirectory);
	            }
	        });
	        selectFolderBtn.setText("Select Folder");
	        selectFolderBtn.setLayoutX(350);
	        selectFolderBtn.setLayoutY(170);
	        selectFolderBtn.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	File file = dc.showDialog(primaryStage);
	            	directory = file.getAbsolutePath();
	            	folderSelectBox.setText(directory);
	            }
	        });
	        Pane exportPane = new Pane();
	        exportPane.getChildren().add(notify);
	        exportPane.getChildren().add(exportBtn);
	        exportPane.getChildren().add(createNewLogFileBtn);
	        exportPane.getChildren().add(personalDataCheckBox);
	        exportPane.getChildren().add(selectInputFileBtn);
	        exportPane.getChildren().add(selectOutputFileBtn);
	        exportPane.getChildren().add(inputFileText);
	        exportPane.getChildren().add(outputLogBox);
	        exportPane.getChildren().add(outputLogBoxLabel);
	        exportPane.getChildren().add(inputFileLabel);
	        exportPane.getChildren().add(folderSelectLabel);
	        exportPane.getChildren().add(folderSelectBox);
	        exportPane.getChildren().add(selectFolderBtn);
	        primaryStage.setScene(new Scene(exportPane, 800, 500));
	        primaryStage.show();
	    }
	//}

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
