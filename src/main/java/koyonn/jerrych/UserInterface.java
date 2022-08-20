package koyonn.jerrych;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Пользовательский графический интерфейс
 *
 * @author Maksim Tarasenka
 */
public class UserInterface {

    // Сцена
    private final Stage stage;

    /**
     * Конструктор интерфейса
     *
     * @param stage сцена
     * @throws IOException ошибка чтения-записи
     */
    public UserInterface(Stage stage) throws IOException {
        this.stage = stage;
        initUI();
    }

    /**
     * Геттер сцены
     *
     * @return сцена
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Инициализация пользовательского графического интерфейса
     *
     * @throws IOException ошибка чтения-записи
     */
    private void initUI() throws IOException {
        FXMLLoader fxmlLoader
                = new FXMLLoader(JerrychApplication.class.getResource("FXML.fxml"));
        Scene scene
                = new Scene(fxmlLoader.load(), 480, 320);
        stage.getIcons().add(
                new Image(JerrychApplication.class.getResourceAsStream("sticker.png"))
        );
        stage.setResizable(false);
        stage.setTitle("Jerrych. Программа для форматирование субтитров");
        stage.setScene(scene);
        stage.show();
    }
}
