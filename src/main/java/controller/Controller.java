package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import calendario.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {

	private IntegerProperty yearProperty = new SimpleIntegerProperty();

	@FXML
	private List<MonthCalendar> mesesList;

	@FXML
	private BorderPane view;

	@FXML
	private Label anioLabel;

	public Controller() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/calendario.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		yearProperty.set(LocalDate.now().getYear());
		anioLabel.textProperty().bind(yearProperty.asString());

		int numMes = 0;
		for (MonthCalendar mes : mesesList) {
			mes.setMonthProperty(numMes + 1);
			mes.yearPropertyProperty().bind(yearProperty);
			numMes++;
		}
	}

	public BorderPane getView() {
		return view;
	}

	@FXML
	private void onSiguienteAction(ActionEvent e) {
		yearProperty.set(yearProperty.get() + 1);
	}

	@FXML
	private void onAnteriorAction(ActionEvent e) {
		yearProperty.set(yearProperty.get() - 1);
	}

}