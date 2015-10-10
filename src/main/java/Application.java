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

		Machine mach1 = new Machine(filename1);
		Machine mach2 = new Machine(filename2);

		boolean similar = true;

 		if (similar) {
			System.out.println("Machines are equivalent");
		} else {
			System.out.println("Machines are not equivalent");
		}
	}

}
