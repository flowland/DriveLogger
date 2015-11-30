package drivelogger.logger;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class AppMain extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DRIVELOGGER MX2020");
		startRootLayout();
		showLogEntryView();
		
	}
	/**
	 * Starts the root layout
	 * @param args
	 */
	public void startRootLayout() {
		try{
			// load the layout from the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AppMain.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			// make and show the scene with root layout
			Scene newScene = new Scene(rootLayout);
			primaryStage.setScene(newScene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows the LogEntry AnchorPane inside the root layout (BorderPane)
	 * @param args
	 */
	public void showLogEntryView() {
		try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AppMain.class.getResource("view/LogEntryView.fxml"));
			AnchorPane logEntryView = (AnchorPane) loader.load();
			rootLayout.setCenter(logEntryView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Getter for the primary stage
	 * @param args
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
