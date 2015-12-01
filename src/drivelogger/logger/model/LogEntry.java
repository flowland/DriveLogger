package drivelogger.logger.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LogEntry {

	private final StringProperty date, goal;
	private final IntegerProperty startValue, endValue;

	public LogEntry() {
		this(null);
	}

	public LogEntry(String date) {
		this.date = new SimpleStringProperty(date);
		this.startValue = new SimpleIntegerProperty(150000);
		this.endValue = new SimpleIntegerProperty(150100);
		this.goal = new SimpleStringProperty("Esinemine Tartus");
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public StringProperty dateProperty() {
		return date;
	}

	public Integer getStartValue() {
		return startValue.get();
	}

	public void setStartValue(int startValue) {
		this.startValue.set(startValue);
	}

	public IntegerProperty startValueProperty() {
		return startValue;
	}

	public Integer getEndValue() {
		return endValue.get();
	}

	public void setEndValue(int endValue) {
		this.endValue.set(endValue);
	}

	public IntegerProperty endValueProperty() {
		return endValue;
	}

	public String getGoal() {
		return goal.get();
	}

	public void setGoal(String goal) {
		this.goal.set(goal);
	}

	public StringProperty goalProperty() {
		return goal;
	}
}
