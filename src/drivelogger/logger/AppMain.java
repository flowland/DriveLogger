package drivelogger.logger;

import java.io.IOException;

import drivelogger.logger.model.LogEntry;
import drivelogger.logger.view.OverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AppMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<LogEntry> entryList = FXCollections.observableArrayList();

	/**
	 * Constructor
	 */
	public AppMain() {
		entryList.add(new LogEntry("12.11.2015"));
		entryList.add(new LogEntry("13.11.2015"));
		entryList.add(new LogEntry("15.11.2015"));
		entryList.add(new LogEntry("16.12.2015"));
	}

	public ObservableList<LogEntry> getEntryList() {
		return entryList;
	}

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("DRIVELOGGER MX2020");
		startRootLayout();
		showEntryView();

	}

	/**
	 * Starts the root layout
	 * 
	 * @param args
	 */
	public void startRootLayout() {
		try {
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
	 * 
	 * @param args
	 */
	public void showEntryView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AppMain.class.getResource("view/LogEntryView.fxml"));
			AnchorPane logEntryPane = (AnchorPane) loader.load();
			rootLayout.setCenter(logEntryPane);
			// access to the main app for controller
			OverviewController controllerObj = loader.getController();
			controllerObj.setAppMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter for the primary stage
	 * 
	 * @param args
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
