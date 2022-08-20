package koyonn.jerrych;

import java.io.File;
import java.io.IOException;

/**
 * Utility class
 *
 * @author Maksim Tarasenka
 */
public class FormattedTextUtilities {

    /**
     * Метод для получения временного файла
     *
     * @return временный файл формата .txt
     * @throws IOException ошибка чтения-записи
     */
    public static File getTempFile() throws IOException {
        return File.createTempFile("temp_text_file", ".txt",
                new File(Constants.getTempFilePath())
        );
    }
}
