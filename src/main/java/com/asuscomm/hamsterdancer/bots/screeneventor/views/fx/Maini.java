package com.asuscomm.hamsterdancer.bots.screeneventor.views.fx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Maini extends Application {

	@Override
	public void start(final Stage primaryStage) throws IOException {
		final Parent root = FXMLLoader.load(getClass().getResource(
				"ActionConfigPane.fxml"));

		final Scene scene = new Scene(root, 300, 275);

		primaryStage.setTitle("FXML Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
