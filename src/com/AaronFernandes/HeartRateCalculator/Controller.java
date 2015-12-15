package com.AaronFernandes.HeartRateCalculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller class
 */
public class Controller implements Initializable {

	//Main Grid Pane
	@FXML private GridPane mainGrid;

	//Text
	@FXML private Text titleText;

	//Radio Buttons
	@FXML private RadioButton genderM;
	@FXML private RadioButton genderF;

	//Age Txt
	@FXML private TextField ageText;

	//cal Button
	@FXML private Button calBtn;

	//Text outputs
	@FXML private Text maxHrate;
	@FXML private Text tHeartRange;

	//Alert
	Alert alert;

	/**
	 * Sets the Male radio button to select and sets the css stuff
	 * @param url							??
	 * @param resourceBundle	??
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		genderM.setSelected(true);
		alert=new Alert(Alert.AlertType.ERROR);
	}

	/**
	 * Action when the calculate button is clicked
	 */
	public void calculateButtonClicked(){
		//Check if see if age is valid
		try {
			int age = Integer.parseInt(ageText.getText());
			if (age<1){
				throw new NumberFormatException();
			}
			else if (age>125){
				throw new NumberFormatException();
			}
			int maxHeartRate=220-age;
			double rangeMin= maxHeartRate*0.5;
			double rangeMax=maxHeartRate*0.85;

			this.maxHrate.setText(String.format("%d", maxHeartRate));
			this.tHeartRange.setText(String.format("%.0f-%.0f", rangeMin,rangeMax));
		}
		catch (NumberFormatException exception){
			alert.setContentText("Not a valid number!\nOr no input provided\nUse a number between 1 and 125");
			alert.showAndWait();
		}

	}

	/**
	 * Sets the select radio button
	 * and CSS class
	 */
	public void genderMAction(){
		genderF.setSelected(false);
		genderM.setSelected(true);
		mainGrid.setStyle("-fx-background-color:#cccaff");
	}

	/**
	 * Sets the select radio button
	 * and CSS class
	 */
	public void genderFAction(){
		genderM.setSelected(false);
		genderF.setSelected(true);
		mainGrid.setStyle("-fx-background-color:#ffcccc");
	}
}
