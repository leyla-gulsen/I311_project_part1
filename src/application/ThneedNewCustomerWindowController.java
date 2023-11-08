package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.util.List;

import javafx.event.ActionEvent;

public class ThneedNewCustomerWindowController {
	@FXML
	private TextField customerNameField;
	@FXML
	private TextField customerAddressField;
	@FXML
	private TextField customerPhoneNumField;
	@FXML
	private Button customerSubmitButton;
	@FXML
	private Button customerCancelButton;

	// Event Listener on Button[#customerSubmitButton].onAction
	@FXML
	public void customerSubmitButtonClick(ActionEvent event) {
//		getting text from usrInput
		Customer newCustomer = new Customer(customerNameField.getText(), customerAddressField.getText(), customerPhoneNumField.getText());
//		loading customer list with load customers function in FileIO class
		List<Customer> customers = FileIO.loadCustomers();
//		adding new customer to list
		customers.add(newCustomer);
//		writing changes to file with save customers function in FileIO class
		FileIO.saveCustomers(customers);
		
		customerNameField.clear();
		customerAddressField.clear();
		customerPhoneNumField.clear();
	}
	
	// Event Listener on Button[#customerCancelButton].onAction
//	Clearing New customer pop up fields
	@FXML
	public void customerCancelButtonClick(ActionEvent event) {
		customerNameField.clear();
		customerAddressField.clear();
		customerPhoneNumField.clear();
	}
}
