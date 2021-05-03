package week4;

import acm.program.ConsoleProgram;
import acm.util.*;
import java.io.*;
import java.util.*;

public class Histograms extends ConsoleProgram {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
		initHistogram();
		readScoresIntoHistogram();
		printHistogram();
	}

	private void initHistogram() {
		histogramArray = new int[11];
		for (int i = 0; i < histogramArray.length; i++) {
			histogramArray[i] = 0;
		}
	}

	private void readScoresIntoHistogram() {
		try {
			Scanner fileScanner =
					new Scanner(new File(DATA_FILE));
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				int score = Integer.parseInt(line);
				if (score < 0 || score > 100) {
					fileScanner.close();
					throw new ErrorException(
							"That score is out of range");
				} else {
					int range = score / 10;
					histogramArray[range]++;
				}
			}
			fileScanner.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	private void printHistogram() {
		for (int range = 0; range <= 10; range++) {
			String label;
			if (range == 0) {
				label = "00-09";
			} else if (range == 10) {
				label = " 100";
			} else {
				label = (10 * range) + "-" + (10 * range + 9);
			}
			String stars = createStars(histogramArray[range]);
			println(label + ": " + stars);
		}
	}

	private String createStars(int n) {
		String stars = "";
		for (int i = 0; i < n; i++) {
			stars += "*";
		}
		return stars;
	}

	private int[] histogramArray;

	private static final String DATA_FILE = "MidtermScores.txt";
}