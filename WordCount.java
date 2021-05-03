package week4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import acm.program.ConsoleProgram;

public class WordCount extends ConsoleProgram {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void run() {
		int lines = 0;
		int words = 0;
		int chars = 0;
		Scanner fileScanner = openScanner("File: ");
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			lines++;
			words += countWords(line);
			chars += line.length();
		}
		fileScanner.close();
		System.out.println("Lines = " + lines);
		System.out.println("Words = " + words);
		System.out.println("Chars = " + chars);
	}

	private Scanner openScanner(String prompt) {
		Scanner fileScanner = null;
		while (fileScanner == null) {
			String name = readLine(prompt);
			try {
				fileScanner = new Scanner(new File(name));
			} catch (IOException ex) {
				System.out.println("Can't open that file.");
			}
		}
		return fileScanner;
	}	
	private int countWords(String line) {
		boolean inWord = false;
		int words = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord) {
					words++;
				}
				inWord = false;
			}
		}
		if (inWord) {
			words++;
		}
		return words;
	}
}