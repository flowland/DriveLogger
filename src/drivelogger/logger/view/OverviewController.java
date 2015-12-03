package drivelogger.logger.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import drivelogger.logger.AppMain;
import drivelogger.logger.model.LogEntry;
import drivelogger.logger.view.DeleteAlert;


public class OverviewController {
	@FXML
	private TableView<LogEntry> logEntries;
	@FXML
	private TableColumn<LogEntry, String> dateColumn;
	@FXML
	private Label dateLabel;
	@FXML
	private Label startLabel;
	@FXML
	private Label endLabel;
	@FXML
	private Label goalLabel;

	// reference to AppMain object from this class
	private AppMain appMain;

	/**
	 * The constructor. Gets called before the initialize method();
	 */
	public OverviewController() {
	}

	// Runs the code after the logentry view loads
	@FXML
	private void initialize() {
		dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		// dateColumn.setCellValueFactory(new PropertyValueFactory<LogEntry,
		// String>("date"));

		showEntry(null);
		logEntries.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showEntry(newValue));
	}

	public void setAppMain(AppMain appMain) {
		this.appMain = appMain;
		logEntries.setItems(appMain.getEntryList());
	}

	private void showEntry(LogEntry entry) {
		if (entry != null) {
			dateLabel.setText(entry.getDate());
			startLabel.setText(Integer.toString(entry.getStartValue()));
			endLabel.setText(Integer.toString(entry.getEndValue()));
			goalLabel.setText(entry.getGoal());
		} else {
			dateLabel.setText("");
			startLabel.setText("");
			endLabel.setText("");
			goalLabel.setText("");
		}
	}

	@FXML
	private void deleteFromList() {
		DeleteAlert dalert = new DeleteAlert();
		int index = logEntries.getSelectionModel().getSelectedIndex();
		if (index < 0) {
			Alert redAlert = new Alert(AlertType.WARNING);
			redAlert.initOwner(appMain.getPrimaryStage());
			redAlert.setTitle("Warning!");
			redAlert.setHeaderText("Tühi sissekanne");
			redAlert.setContentText("Palun valige üks päeviku sissekanne");
			redAlert.showAndWait();
		} else if(dalert.showDeleteConfirmation() == true) {
			logEntries.getItems().remove(index);
		}
	}

	@FXML
	private void addNewEntry() {
		LogEntry newEntry = new LogEntry();
		boolean clickOk = appMain.showEntryWindow(newEntry);
		if (clickOk) {
			appMain.getEntryList().add(newEntry);
		}
	}

	@FXML
	private void editEntry() {
		LogEntry selectedEntry = logEntries.getSelectionModel().getSelectedItem();
		if (selectedEntry != null) {
			boolean clickOk = appMain.showEntryWindow(selectedEntry);
			if (clickOk) {
				showEntry(selectedEntry);
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(appMain.getPrimaryStage());
			alert.setTitle("No selection");
			alert.setHeaderText("No person selected");
			alert.setContentText("Please select  a person in the table");
			alert.showAndWait();
		}

	}

}
