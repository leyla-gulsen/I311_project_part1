package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Thneed Window");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/ThneedMainWindow.fxml"));
			AnchorPane sampleLayout = (AnchorPane)loader.load();
			Scene scene = new Scene(sampleLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

