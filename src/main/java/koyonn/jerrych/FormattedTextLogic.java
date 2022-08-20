package koyonn.jerrych;

import java.io.IOException;

/**
 * Класс, отвечающий за построение логики программы
 *
 * @author Maksim Tarasenka
 */
public class FormattedTextLogic {

    /**
     * Построение логики приложения
     * @param filePath путь к файлу
     * @param savePath путь к месту сохранения файла
     */
    public static void buildProgram(String filePath, String savePath) {
        try {
            FormattedTextImp fti
                    = new FormattedTextImp(FormattedTextUtilities.getTempFile(), filePath, savePath);
            fti.deleteTimeCodes();
            fti.textFormatting();
            fti.deleteTempFile();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
