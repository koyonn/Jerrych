package edu.jerrych.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class FormattedTextTest {
	@Test
	public void textFormatting() throws IOException {
		String filePath1 = "src\\test\\resources\\edu\\jerrych\\logic\\Test1.txt";
		String filePath2 = "src\\test\\resources\\edu\\jerrych\\logic\\Test2.txt";
		String savePath1 = "src\\test\\resources\\edu\\jerrych\\logic\\export1.txt";
		String savePath2 = "src\\test\\resources\\edu\\jerrych\\logic\\export2.txt";
		String rightOption1 = "src\\test\\resources\\edu\\jerrych\\logic\\formatted_subs1.txt";
		String rightOption2 = "src\\test\\resources\\edu\\jerrych\\logic\\formatted_subs2.txt";
		new FormattedText().textFormatting(filePath1, savePath1);
		new FormattedText().textFormatting(filePath2, savePath2);
		new File(savePath1).deleteOnExit();
		new File(savePath2).deleteOnExit();
		try (BufferedReader br1 = new BufferedReader(new FileReader(savePath1));
		        BufferedReader br2 = new BufferedReader(new FileReader(savePath2));
		        BufferedReader br3 = new BufferedReader(new FileReader(rightOption1));
		        BufferedReader br4 = new BufferedReader(new FileReader(rightOption2))) {
			String line;
			while ((line = br1.readLine()) != null) {
				assertEquals(line, br3.readLine());
			}
			assertNull("Отформатированный файл имеет больше строк, чем ожидается", br1.readLine());
			assertNull("Готовый файл имеет больше строк, чем ожидается", br3.readLine());
			while ((line = br2.readLine()) != null) {
				assertEquals(line, br4.readLine());
			}
			assertNull("Отформатированный файл имеет больше строк, чем ожидается", br2.readLine());
			assertNull("Готовый файл имеет больше строк, чем ожидается", br4.readLine());
		}
	}
}
