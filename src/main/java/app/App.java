package app;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	public static Stage primaryStage;
	private Controller controller = new Controller();

	@Override
	public void start(Stage primaryStage) throws Exception {

		App.primaryStage = primaryStage;

		primaryStage.setTitle("Calendario");
		primaryStage.getIcons().add(new Image("/images/calendar-64x64.png"));
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
