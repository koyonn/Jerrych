package koyonn.jerrych;

import java.io.File;

/**
 * Класс для хранения констант
 *
 * @author Maksim Tarasenka
 */
public class Constants {

    // Путь к директории, где будут создаваться временные файлы
    private static final String tempFilePath
            = System.getProperty("user.home") + File.separator + "Documents";

    /**
     * Метод для получения места сохранения временного файла
     *
     * @return путь к месту хранения временного файла
     */
    public static String getTempFilePath() {
        return tempFilePath;
    }
}
