package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EX29808 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int S = sc.nextInt();

		if (S % 4763 > 0) {
			System.out.println(0);
			return;
		}
		int sumScore = S / 4763;

		ArrayList<int[]> arr = new ArrayList<int[]>();

		for (int i = 0; i <= 200; i++) {
			for (int j = 0; j <= 200; j++) {
				if (sumScore == i * 508 + j * 212 || sumScore == i * 108 + j * 212 || sumScore == i * 508 + j * 305
						|| sumScore == i * 108 + j * 305) {
					arr.add(new int[] { i, j });
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(arr.size() + "\n");
		for (int[] i : arr) {
			sb.append(i[0] + " " + i[1] + "\n");
		}
		System.out.println(sb.toString());
	}

}
