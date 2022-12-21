package edu.jerrych.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.jerrych.controller.FXController;

/**
 * Класс для редактирования текста
 * 
 * @ @author Maksim Tarasenka
 */
public class FormattedText {
	private static final Logger logger = LoggerFactory.getLogger(FormattedText.class);

	/**
	 * Форматирование субтитров
	 * 
	 * @param filePath путь к файлу, который необходимо отформатировать
	 * @param savePath место сохранения, отформатированного файла
	 */
	public void textFormatting(String filePath, String savePath) {
		try (RandomAccessFile file1 = new RandomAccessFile(filePath, "r");
		        RandomAccessFile file2 = new RandomAccessFile(savePath, "rw");
		        FileChannel fileChannel1 = file1.getChannel();
		        FileChannel fileChannel2 = file2.getChannel();
		        BufferedReader bufferedReader = new BufferedReader(Channels.newReader(fileChannel1, "UTF-8"));
		        BufferedWriter bufferedWriter = new BufferedWriter(Channels.newWriter(fileChannel2, "UTF-8"))) {
			List<String> list = bufferedReader.lines()
			                                  .filter(line -> (!line.isEmpty() && !Pattern.matches("\\s*\\[.+]", line)
			                                          && !Pattern.matches("\\s*\\d*.+\\d", line)
			                                          && !Pattern.matches("\\s*\\d*", line)))
			                                  .toList();
			int i = 0;
			String s = "";
			for (var word : list) {
				i += word.toCharArray().length;
				if (i >= 70) {
					s = "\n";
					i = 0;
				} else {
					s = " ";
				}
				bufferedWriter.write(word + s);
			}
			bufferedWriter.flush();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
