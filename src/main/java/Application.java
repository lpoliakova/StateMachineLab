import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by elena on 20.09.15.
 */
public class Application {
	public static void main(String[] args) {
		String filename1 = "exmp1";
		String filename2 = "exmp2";

		List<String> language1 = findLanguage(filename1);
		List<String> language2 = findLanguage(filename2);

		boolean similar = compareLanguages(language1, language2);

 		if (similar) {
			System.out.println("Machines are equivalent");
		} else {
			System.out.println("Machines are not equivalent");
		}
	}

	private static List<String> findLanguage(String filename) {
		try {
			Scanner file = new Scanner(new FileReader(filename));
			int alphabet = file.nextInt();
			int numOfStates = file.nextInt();
			int firstState = file.nextInt();
			int numOfLastStates = file.nextInt();
			int[] lastState = new int[numOfLastStates];
			for (int i = 0; i < numOfLastStates; i++) {
				lastState[i] = file.nextInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<String> language = new ArrayList<String>();
		return language;
	}

	private String findWord(int curState, String filename, String curWord) {
		try {
			Scanner file = new Scanner(new FileReader(filename));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return curWord;
	}

	private static boolean compareLanguages(List<String> language1, List<String> language2) {
		Collections.sort(language1);
		Collections.sort(language2);
		return language1.equals(language2);
	}
}
