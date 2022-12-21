package edu.jerrych;

import java.io.IOException;

import edu.jerrych.controller.FXController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class JerrychApp extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Jerrych_FXML.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 480, 320);
		setStageInController(fxmlLoader, stage);
		stage.getIcons()
		     .add(new Image(JerrychApp.class.getResourceAsStream("sticker.png")));
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.setTitle("Jerrych. Программа для форматирование субтитров");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Передать текущий объект Stage в контроллер
	 * 
	 * @param fxmlLoader FXML с настройками
	 * @param stage      контейнер
	 */
	private void setStageInController(FXMLLoader fxmlLoader, Stage stage) {
		FXController fxc = (FXController) fxmlLoader.getController();
		fxc.setStage(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
