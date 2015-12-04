package drivelogger.logger.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

import java.io.File;

import drivelogger.logger.AppMain;

public class RootController {
	
	//Reference to main
	
	private AppMain appMain;
	
	public void setAppMain(AppMain appMain) {
		this.appMain = appMain;
	}
	/**
	 * New log
	 */
	@FXML
	private void newLog() {
		appMain.getEntryList().clear();
		appMain.setPath(null);
	}
	
	@FXML
	private void loadLog() {
		FileChooser pickOne = new FileChooser();
		// set filter
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("XML files", "*.xml");
		pickOne.getExtensionFilters().add(filter);
		//show dialog
		File file = pickOne.showOpenDialog(appMain.getPrimaryStage());
		if(file != null) {
			appMain.loadEntryData(file);
		}
	}
	  @FXML
	    private void handleSave() {
	        File personFile = appMain.getPath();
	        if (personFile != null) {
	            appMain.saveEntryData(personFile);
	        } else {
	            saveAs();
	        }
	    }
	@FXML 
	private void saveAs() {
		FileChooser pickOne = new FileChooser();
		// set filter
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("XML files", "*.xml");
		pickOne.getExtensionFilters().add(filter);
		// show save dialog
		File file = pickOne.showSaveDialog(appMain.getPrimaryStage());
		
		if(file != null) {
			if(!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			appMain.saveEntryData(file);
		}
	}
	 /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}	
