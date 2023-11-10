package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import java.text.SimpleDateFormat;
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
	
    @FXML
    public void initialize() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        orderDatePlacedField.setText(formattedDate);
    }
	

	// Event Listener on Button[#cancelOrderButton].onAction
	@FXML
	public void cancelOrderButtonClick(ActionEvent event) {
		orderQuantityField.clear();
		orderCustomerNameField.clear();
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
		try {
//			get the input data
			int quantity = Integer.parseInt(orderQuantityField.getText());
			String customerName = orderCustomerNameField.getText();
			String datePlaced = orderDatePlacedField.getText();
			String dateFilled = orderDateFilledField.getText();
			
//			ensuring date values aren't empty. date functions will crash if empty
			if (datePlaced.isEmpty()) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	            Date currentDate = new Date();
	            datePlaced = dateFormat.format(currentDate);
	        }
			if (dateFilled.isEmpty()) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//	            Date currentDate = new Date();
	            dateFilled = dateFormat.format(00-00-0000);
	        }
			
			
//			getting the input from toggle color
			String color = "";
			RadioButton selectedColorButton = (RadioButton) thneedColorGroup.getSelectedToggle();
			if (selectedColorButton != null) {
				color = selectedColorButton.getText();
			}
//			getting input from toggle size
			String size = "";
			RadioButton selectedSizeButton =(RadioButton) thneedSizeGroup.getSelectedToggle();
			if (selectedSizeButton != null) {
				size = selectedSizeButton.getText();
			}
			
//			parsing the date strings into date objects.
			Date parsedDatePlaced = new SimpleDateFormat("dd-MM-yyyy").parse(datePlaced);
			Date parsedDateFilled = new SimpleDateFormat("dd-MM-yyyy").parse(dateFilled);
//			loading list of customers
			
			List<Customer> customers = FileIO.loadCustomers();
//			initializing customer object
			Customer customer = null;
			
//			iterating through list of customers to see if they exist.
			for (int i = 0; i < customers.size(); i++) {
				Customer c = customers.get(i);
				if (c.getName().equals(customerName)) {
					customer = c;
					break;
				}
			}
			
//			checking if customer was found
			if (customer != null) {
//				creating new ThneedOrders object
				ThneedOrders thneed = new ThneedOrders(quantity, size, color);
				
//				New Order object
				Order order = new Order(customer);
				
//				setting values for order object
				order.setDateOrdered(parsedDatePlaced);
				order.setDateFilled(parsedDateFilled);
				order.addThneed(thneed);
				
//				loading current orders
				List<Order> orders = FileIO.loadOrders();
//				adding new order to list of orders
				orders.add(order);
				
//				saving to file
				FileIO.saveOrders(orders);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
//		clearing fields when saved
		orderQuantityField.clear();
		orderCustomerNameField.clear();
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
}
