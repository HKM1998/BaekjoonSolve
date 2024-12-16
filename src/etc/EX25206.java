package etc;
import java.util.Scanner;

public class EX25206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int count = 20;
		double totalScore = 0;
		double classScore = 0;
		double tempScore = 0;
		String[] str = null;

		for (int i = 0; i < 20; i++) {
			str = in.nextLine().split(" ");
			tempScore = Double.parseDouble(str[1]);
			switch (str[2]) {
				case "P":
					continue;
				case "F":
					break;
				case "A+": {
					classScore += 4.5 * tempScore;
					break;
				}
				case "A0": {
					classScore += 4.0 * tempScore;
					break;
				}
				case "B+": {
					classScore += 3.5 * tempScore;
					break;
				}
				case "B0": {
					classScore += 3.0 * tempScore;
					break;
				}
				case "C+": {
					classScore += 2.5 * tempScore;
					break;
				}
				case "C0": {
					classScore += 2.0 * tempScore;
					break;
				}
				case "D+": {
					classScore += 1.5 * tempScore;
					break;
				}
				case "D0": {
					classScore += 1.0 * tempScore;
					break;
				}
			}
			totalScore += tempScore;

		}
		System.out.println(classScore / totalScore);
	}
}
