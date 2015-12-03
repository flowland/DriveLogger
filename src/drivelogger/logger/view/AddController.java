package drivelogger.logger.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import drivelogger.logger.model.LogEntry;

public class AddController {
	@FXML
	private TextField dateField;
	@FXML
	private TextField startField;
	@FXML
	private TextField endField;
	@FXML
	private TextField goalField;

	private Stage addStage;
	private LogEntry entry;
	private boolean isOk = false;

	public void setStage(Stage addStage) {
		this.addStage = addStage;
	}

	public void setEntry(LogEntry entry) {
		this.entry = entry;
		dateField.setText(entry.getDate());
		startField.setText(Integer.toString(entry.getStartValue()));
		endField.setText(Integer.toString(entry.getEndValue()));
		goalField.setText(entry.getGoal());
	}

	// true if ok is clicked, false if it isnt
	public boolean isOk() {
		return isOk;
	}

	@FXML
	private void clickOk() {
		entry.setDate(dateField.getText());
		entry.setStartValue(Integer.parseInt(startField.getText()));
		entry.setEndValue(Integer.parseInt(endField.getText()));
		entry.setGoal(goalField.getText());
		isOk = true;
		addStage.close();
	}

	@FXML
	private void clickCancel() {
		addStage.close();
	}
}
