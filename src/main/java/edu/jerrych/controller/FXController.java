package edu.jerrych.controller;

import java.io.File;
import java.io.IOException;

import edu.jerrych.logic.FormattedText;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Контроллер приложения
 *
 * @author Maksim Tarasenka
 */
public class FXController {
	private Stage stage;
	private String filePath;
	private String savePath;
	private boolean checkFilePath;
	private boolean checkSavePath;
	@FXML
	protected Button btnFormatting;
	@FXML
	protected Button btnOpen;
	@FXML
	protected Button btnSave;
	@FXML
	protected TextArea textArea;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	protected void onBtnOpen() throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Выбор файла с субтитрами");
		fileChooser.getExtensionFilters()
		           .addAll(new FileChooser.ExtensionFilter("TXT", "*.txt"));
		if (stage != null) {
			File file = fileChooser.showOpenDialog(stage);
			if (file == null) {
				return;
			}
			filePath = file.getAbsolutePath();
			textArea.appendText("\n" + file.getAbsolutePath());
			checkFilePath = true;
		} else {
			throw new IOException("Ошибка загрузки интерфейса");
		}
	}

	@FXML
	protected void onBtnSave() throws IOException {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Выбор места сохранения отформатированного файла");
		if (stage != null) {
			File file = directoryChooser.showDialog(stage);
			if (file == null) {
				return;
			}
			savePath = file.toString() + "\\export.txt";
			textArea.appendText("\n" + file.getAbsolutePath());
			checkSavePath = true;
		} else {
			throw new IOException("Ошибка загрузки интерфейса");
		}
	}

	@FXML
	protected void onBtnFormatting() {
		if (checkFilePath && checkSavePath) {
			textArea.appendText("\nЗапуск форматирования!\n");
			new FormattedText().textFormatting(filePath, savePath);
			textArea.appendText("Файл сохранен " + savePath + "\n");
		} else {
			if (!checkFilePath) {
				textArea.appendText("\nНе выбран файл.");
			}
			if (!checkSavePath) {
				textArea.appendText("\nНе выбрана директория для сохранения файла.");
			}
		}
	}
}
