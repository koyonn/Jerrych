package koyonn.jerrych;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Контроллер приложения
 *
 * @author Maksim Tarasenka
 */
public class FXController {
    // Путь к файлу
    private String filePath;
    // Путь к месту сохранения файла
    private String savePath;

    private static boolean checkFilePath = false;

    private static boolean checkSavePath = false;

    // Кнопка "Начать форматирование"
    @FXML
    protected Button btnFormatting;
    // Кнопка "Выберите файл для форматирования"
    @FXML
    protected Button btnOpen;
    // Кнопка "Выберите папку для сохранения"
    @FXML
    protected Button btnSave;
    // Текстовое поле
    @FXML
    protected TextArea textArea;

    // Окно выбора файла
    private final FileChooser fileChooser = new FileChooser();
    // Окно выбора директории
    private final DirectoryChooser directoryChooser = new DirectoryChooser();

    // Действие при нажатии на кнопку btnOpen
    @FXML
    protected void onBtnOpen() {
        fileChooser.setTitle("Выбор файла с субтитрами");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT", "*.txt")
        );
        File file = fileChooser.showOpenDialog(JerrychApplication.getUI().getStage());
        if (file != null) {
            filePath = file.getAbsolutePath();
            textArea.appendText("\n" + file.getAbsolutePath());
            checkFilePath = true;
        }
    }

    // Действие при нажатии на кнопку btnSave
    @FXML
    protected void onBtnSave() {
        directoryChooser.setTitle("Выбор места сохранения отформатированного файла");
        File file = directoryChooser.showDialog(JerrychApplication.getUI().getStage());
        if (file != null) {
            savePath = file.toString() + "\\export.txt";
            textArea.appendText("\n" + file.getAbsolutePath());
            checkSavePath = true;
        }
    }

    // Действие при нажатии на кнопку btnFormatting
    @FXML
    protected void onBtnFormatting() {
        if (checkFilePath && checkSavePath) {
            textArea.appendText("\nЗапуск форматирования!\n");
            FormattedTextLogic.buildProgram(filePath, savePath);
            textArea.appendText("Файл сохранен " + savePath + "\n");
        } else {
            if (!checkFilePath) {
                textArea.appendText("Не выбран файл.\n");
            }
            if (!checkSavePath) {
                textArea.appendText("Не выбрана директория для сохранения файла.\n");
            }
        }
    }
}
