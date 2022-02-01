package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private HibernateController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new HibernateController();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("Hibernate");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

