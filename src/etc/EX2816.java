package etc;
import java.util.Scanner;

public class EX2816 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int pos1 = 0;
		int pos2 = 0;
		String temp = null;
		StringBuilder outputStr = new StringBuilder();
		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			temp = sc.next();

			if (temp.equals("KBS1"))
				pos1 = i;
			else if (temp.equals("KBS2"))
				pos2 = i;
		}

		if (pos1 > pos2)
			pos2++;
		
		for (int i = 0; i < pos1; i++) {
			outputStr.append("1");
		}
		for (int i = 0; i < pos1; i++) {
			outputStr.append("4");
		}
		for (int i = 0; i < pos2; i++) {
			outputStr.append("1");
		}
		for (int i = 0; i < pos2 - 1; i++) {
			outputStr.append("4");
		}

		System.out.println(outputStr.toString());
	}

}
