package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(SampleController.class.getResource("Sample.fxml"));
			VBox root = fxmlLoader.load();
			//VBox root = (VBox)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			// Po si necesitamos acceder al controlador, getControler no devuelve una referencia a el.
			// En este caso no lo necesitamos.
			SampleController controller = fxmlLoader.getController();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Contador de texto");
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
