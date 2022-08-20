package koyonn.jerrych;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Класс запуска JavaFX приложения
 *
 * @author Maksim Tarasenka
 */
public class JerrychApplication extends Application {

    // Объект пользовательского интерфейса
    private static UserInterface ui;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Инициализация графического интерфейса
            ui = new UserInterface(stage);
        } catch (IOException e) {
            e.getStackTrace();
            throw e;
        }
    }

    /**
     * Геттер графического интерфейса
     *
     * @return экземпляр графического интерфейса
     */
    public static UserInterface getUI() {
        return ui;
    }

    /**
     * Запуск приложения
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
