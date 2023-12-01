package application;

import java.awt.Desktop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	//Ethan Luong
    private String adminUsername = "admin";
    private String adminPassword = "admin";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	
    	
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

                if(userTextField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Form Error!",
                            "Please enter your email id");
                    return;
                }
                if(passwordBox.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Form Error!",
                            "Please enter a password");
                    return;
                }

                if(adminUsername.equals(username) && adminPassword.equals(password)){
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
                } else{
                    infoBox("Please enter correct Email and Password", null, "Failed");
                }
            }
            //Ethan Luong
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	//Aidan Daly
        	@Override
        	public void handle(ActionEvent a) {
        		//Label for name 
        	      Text nameLabel = new Text("Name"); 
        	      Text eemail = new Text("Email");
        	      
        	      
        	      //Text field for name 
        	      TextField nameText = new TextField(); 
        	      TextField theText = new TextField(); 
        	      TextField email = new TextField();
        	      //Label for date of birth 
        	      Text dobLabel = new Text("User ID"); 
        	      
        	      //date picker to choose date 
        	      DatePicker datePicker = new DatePicker(); 
        	       
        	      //Label for gender
        	      Text genderLabel = new Text("Are you an EffortLogger staff member?"); 
        	      
        	      
        	      ToggleGroup groupGender = new ToggleGroup(); 
        	      RadioButton maleRadio = new RadioButton("Yes"); 
        	      maleRadio.setToggleGroup(groupGender); 
        	      RadioButton femaleRadio = new RadioButton("No"); 
        	      femaleRadio.setToggleGroup(groupGender); 

        	      Text messageText = new Text();
        	      

        	      ToggleButton Reservation = new ToggleButton(); 
        	      ToggleButton yes = new ToggleButton("Yes"); 
        	      ToggleButton no = new ToggleButton("No"); 
        	      ToggleGroup groupReservation = new ToggleGroup(); 
        	      yes.setToggleGroup(groupReservation);   
        	      no.setToggleGroup(groupReservation); 
        	      CheckBox cb = new CheckBox("a checkbox");
        	      cb.setIndeterminate(false);

        	      CheckBox javaCheckBox = new CheckBox("Agree to Privacy Terms and Conditions"); 
        	      javaCheckBox.setIndeterminate(false); 
        	      
        	      
        	      javaCheckBox.setIndeterminate(false); 
        	       

        	      Text educationLabel = new Text("Qualification"); 
        	      
        	 
        	      ObservableList<String> names = FXCollections.observableArrayList( 
        	         "Software Engineer", "Team Lead", "Manager", "Customer", "Other"); 
        	      ListView<String> educationListView = new ListView<String>(names); 
        	      
        	    
        	      Button buttonRegister = new Button("Create Password");  
        	      

        	      GridPane gridPane = new GridPane();    
        	      

        	      gridPane.setMinSize(900, 500); 
        	       
        	      //Setting the padding    
        	      gridPane.setPadding(new Insets(10, 10, 10, 10));  
        	    
        	      gridPane.setVgap(5); 
        	      gridPane.setHgap(5);       

        	      gridPane.setAlignment(Pos.CENTER); 

        	      gridPane.add(nameLabel, 0, 0); 
        	      gridPane.add(nameText, 1, 0); 
        	       
        	      gridPane.add(dobLabel, 0, 1);       
        	      gridPane.add(theText, 1, 1); 
        	      
        	      gridPane.add(genderLabel, 0, 2); 
        	      gridPane.add(maleRadio, 1, 2);       
        	      gridPane.add(femaleRadio, 2, 2); 
        	     
        	       
        	      gridPane.add(email, 1, 4); 
        	      gridPane.add(eemail, 0, 4);
        	      
        	      gridPane.add(educationLabel, 0, 5); 
        	      gridPane.add(educationListView, 1, 5);      
        	       
        	      gridPane.add(javaCheckBox, 1, 6);    
        	       
        	      gridPane.add(buttonRegister, 1, 8);      
        	              	      
        	      buttonRegister.setOnAction(event -> {
        	    	  if (nameText.getText().isEmpty() || theText.getText().isEmpty() ||
        	                  (!maleRadio.isSelected() && !femaleRadio.isSelected()) ||
        	                  email.getText().isEmpty() || educationListView.getSelectionModel().isEmpty() ||
        	                  !javaCheckBox.isSelected()) {

        	             
        	              messageText.setText("Error: Please fill out all sections!");
        	              messageText.setFill(Color.RED);
        	              
        	             
        	          }
        	    //Leo Montes
        	    	  else {try {
        	  			Parent root = FXMLLoader.load(getClass().getResource("password.fxml"));
        	  			Scene scene = new Scene(root);
        	  			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        	  			primaryStage.setScene(scene);
        	  			primaryStage.show();
        	  		} catch(Exception e) {
        	  			primaryStage.show();
        	  			e.printStackTrace();
        	  		}
        	    	  }
        	    	  gridPane.add(messageText, 2, 8);
        	      });
        	       
				
        	      gridPane.setStyle("-fx-background-color: WHITE;");       
        	       
        	      //Creating a scene object 
        	      Scene scene = new Scene(gridPane); 
        	      
        	      //Setting title to the Stage 
        	      primaryStage.setTitle("EffortLogger Ver.2 Account Setup"); 
        	         
        	      //Adding scene to the stage 
        	      primaryStage.setScene(scene);  
        	      
        	      //Displaying the contents of the stage 
        	      primaryStage.show(); 
        	}
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    
}