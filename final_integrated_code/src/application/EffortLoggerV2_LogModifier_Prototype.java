// EffortLoggerV2_LogModifier_Prototype.java
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EffortLoggerV2_LogModifier_Prototype {

    @FXML
    private TextField inputFileText;

    @FXML
    private TextField outputLogBox;

    @FXML
    private TextField folderSelectBox;

    @FXML
    private CheckBox personalDataCheckBox;

    @FXML
    private Label notify;
    
    @FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;

    public void handleUpdateLog(ActionEvent event) {
        // Your update log logic here
    }

    public void handleCreateNewLog(ActionEvent event) {
        // Your create new log logic here
    }

    public void handleSelectInputFile(ActionEvent event) {
        // Your select input file logic here
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            inputFileText.setText(file.toString());
        }
    }

    public void handleSelectOutputFile(ActionEvent event) {
        // Your select output file logic here
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            outputLogBox.setText(file.toString());
        }
    }

    public void handleSelectFolder(ActionEvent event) {
        // Your select folder logic here
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(null);
        if (directory != null) {
            folderSelectBox.setText(directory.getAbsolutePath());
        }
    }
    
    @FXML
	public void sceneOne(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("mainConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
