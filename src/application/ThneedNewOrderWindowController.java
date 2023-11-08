package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import java.util.Date;
import java.util.List;

import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

public class ThneedNewOrderWindowController {
	@FXML
	private Button cancelOrderButton;
	@FXML
	private TextField orderQuantityField;
	@FXML
	private TextField orderCustomerNameField;
	@FXML
	private TextField orderDatePlacedField;
	@FXML
	private TextField orderDateFilledField;
	@FXML
	private Button submitOrderButton;
	@FXML
	private RadioButton pinkThneedButton;
	@FXML
	private ToggleGroup thneedColorGroup;
	@FXML
	private RadioButton orangeThneedButton;
	@FXML
	private RadioButton yellowThneedButton;
	@FXML
	private RadioButton smallThneedButton;
	@FXML
	private RadioButton mediumThneedButton;
	@FXML
	private RadioButton largeThneedButton;
	@FXML
	private RadioButton XLThneedButton;
	@FXML
	private ToggleGroup thneedSizeGroup;
	@FXML
	private RadioButton greenThneedButton;
	@FXML
	private RadioButton purpleThneedButton;

	// Event Listener on Button[#cancelOrderButton].onAction
	@FXML
	public void cancelOrderButtonClick(ActionEvent event) {
		orderQuantityField.clear();
		orderCustomerNameField.clear();
		orderDatePlacedField.clear();
		orderDateFilledField.clear();
		pinkThneedButton.setSelected(false);
		orangeThneedButton.setSelected(false);
		yellowThneedButton.setSelected(false);
		smallThneedButton.setSelected(false);
		mediumThneedButton.setSelected(false);
		largeThneedButton.setSelected(false);
		XLThneedButton.setSelected(false);
		greenThneedButton.setSelected(false);
		purpleThneedButton.setSelected(false);
	}
	
	// Event Listener on Button[#submitOrderButton].onAction
	@FXML
	public void submitOrderButtonClick(ActionEvent event) {
		int quantity = Integer.parseInt(orderQuantityField.getText());
		String customerName = orderCustomerNameField.getText();
		String datePlaced = orderDatePlacedField.getText();
		String dateFilled = orderDateFilledField.getText();
		
		String color = "";
		RadioButton selectedColorButton = (RadioButton) thneedColorGroup.getSelectedToggle();
		if (selectedColorButton != null) {
			color = selectedColorButton.getText();
		}
		String size = "";
		RadioButton selectedSizeButton =(RadioButton) thneedSizeGroup.getSelectedToggle();
		if (selectedSizeButton != null) {
			size = selectedSizeButton.getText();
		}
		
		ThneedOrders thneed = new ThneedOrders(quantity, size, color);
		
		Customer customer = findCustomer(customerName);
		
		Order order = new Order(customer);
		order.addThneed(thneed);
		
		List<Order> orders = FileIO.loadOrders();
		
		orders.add(order);
		
		FileIO.saveData(FileIO.loadCustomers(), orders);
		
	}
	
//	function to get the customer from the list
	private Customer findCustomer(String customerName) {
		List<Customer> customers = FileIO.loadCustomers();
		for (int i = 0; i< customers.size(); i++) {
			Customer customer = customers.get(i);
			if (customer.getName().equals(customerName)) {
				return customer;
			}
	}
		return null;
	}
}
