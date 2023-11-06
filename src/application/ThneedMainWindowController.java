package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

	public ArrayList<Order> thneedOrders;

}
