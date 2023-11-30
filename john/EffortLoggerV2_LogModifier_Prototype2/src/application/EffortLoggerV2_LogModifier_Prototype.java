//Author: John S Fischer
//Arizona State University
//Prototype program to modify and export excel log files so as to protect personal data that may be stored.

package application;

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

public class EffortLoggerV2_LogModifier_Prototype extends Application
{
	//"C:\\Users\\john3\\Desktop\\ASU\\CSE360\\Team Assignments\\Phase4\\samplelogs\\SampleLog1.xlsx"
	//"C:\\Users\\john3\\Desktop\\ASU\\CSE360\\Team Assignments\\Phase4\\EffortLoggerV2_ModifiedLogs\\EffortLoggerV2_ModifiedLog1"
	String inputLogDirectory = "";
	String outputLogDirectory = "";
	String directory = "";
	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EffortLoggerV2_LogModifier_Prototype");
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
}