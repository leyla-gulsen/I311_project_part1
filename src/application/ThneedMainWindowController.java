package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class ThneedMainWindowController {
	@FXML
	private Button newOrderButton;
	@FXML
	private TextField listField;
	@FXML
	private TextField currentField;
	@FXML
	private Button custInfoButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button newCustButton;
	@FXML
	private Button editDateButton;

	public ArrayList<Order> thneedOrders;

	// Event Listener on Button[#newOrderButton].onAction
	@FXML
	public void newOrderClick(ActionEvent event) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ThneedNewOrderWindow.fxml"));
		AnchorPane dialogRoot;
		//try except to ge the new window to show
		try {
			dialogRoot = (AnchorPane) loader.load();
			Scene dialogScene = new Scene(dialogRoot);
			Stage dialogStage = new Stage();
			dialogStage.setScene(dialogScene);
			ThneedNewOrderWindowController dialogController = (ThneedNewOrderWindowController) loader.getController();
			dialogStage.show();
			System.out.println("After dialogStage.show()");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#custInfoButton].onAction
	@FXML
	public void newCustClick(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ThneedNewCustomerWindow.fxml"));
		AnchorPane dialogRoot;
		//try except to ge the new window to show
		try {
			dialogRoot = (AnchorPane) loader.load();
			Scene dialogScene = new Scene(dialogRoot);
			Stage dialogStage = new Stage();
			dialogStage.setScene(dialogScene);
			ThneedNewCustomerWindowController dialogController = (ThneedNewCustomerWindowController) loader.getController();
			dialogStage.show();
			System.out.println("After dialogStage.show()");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveButtonClick(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#newCustButton].onAction
	@FXML
	public void viewCustomerClick(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ThneedViewCustomerWindow.fxml"));
		AnchorPane dialogRoot;
		//try except to ge the new window to show
		try {
			dialogRoot = (AnchorPane) loader.load();
			Scene dialogScene = new Scene(dialogRoot);
			Stage dialogStage = new Stage();
			dialogStage.setScene(dialogScene);
			ThneedViewCustomerWindowController dialogController = (ThneedViewCustomerWindowController) loader.getController();
			dialogStage.show();
			System.out.println("After dialogStage.show()");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Event Listener on Button[#editDateButton].onAction
	@FXML
	public void editDateClick(ActionEvent event) {
		// TODO Autogenerated
	}
}
