package koyonn.jerrych;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Класс для редактирования текста
 *
 * @author Maksim Tarasenka
 */
public class FormattedTextImp implements FormattedTextContract {

    // Путь к файлу
    private final String filePath;
    // Пусть к месту сохранения
    private final String savePath;
    // Временный файл
    private final File tempFile;

    public FormattedTextImp(File tempFile, String filePath, String savePath) {
        this.tempFile = tempFile;
        this.filePath = filePath;
        this.savePath = savePath;
    }

    // Метод для удаления временного файла
    public void deleteTempFile() {
        tempFile.deleteOnExit();
    }

    // Метод для удаления тайм-кодов из субтитров
    @Override
    public void deleteTimeCodes() {
        // Объект, где будет храниться строка из документа
        String line;
        try {
            // Буферизированный символьный поток чтения из исходного файла
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath), StandardCharsets.UTF_8
                    )
            );
            // Буферизированный поток для записи во временный файл
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(tempFile)
            );
            while (br.ready()) {
                // Чтение строки из исходного файла
                line = br.readLine();
                // Проверка на пустую строку
                if (!line.equals("")) {
                    // Содержание в строке только чисел (которые являеются номером строки в исходном файле)
                    if (!Character.isDigit(line.toCharArray()[0])) {
                        // Проверка на длину
                        if (line.length() > 2) {
                            // Проверка на наличие тайм-кода
                            if (line.charAt(2) != ':' && line.charAt(0) != '['
                                    && line.charAt(line.length() - 1) != ']') {
                                bw.write(line + "\n");
                            }
                        }
                    }
                }
            }
            //закрытие потоков
            br.close();
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    // Метод для форматирования текста
    @Override
    public void textFormatting() {
        // Объект, где будет храниться строка из документа
        String line;
        try {
            // Буферизированный символьный поток чтения из временного файла
            BufferedReader br = new BufferedReader(
                    new FileReader(tempFile)
            );
            // Буферизированный поток для записи в конечный файл
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(savePath)
            );
            while (br.ready()) {
                // Чтение строки
                line = br.readLine();
                // Запись строки без пробелов по краям и последующим добавлением одно пробела справа.
                bw.write(line.strip() + " ");
            }
            // Закрытие потоков
            br.close();
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
