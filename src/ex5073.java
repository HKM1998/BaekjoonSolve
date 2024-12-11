import java.util.Scanner;

public class EX5073 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		int max = 0;

		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();

			if (a + b + c < 1)
				break;
			
			max = a > b ? a > c ? a : c : b > c ? b : c;
			if (max < a + b + c - max) {
				if (a == b && b == c)
					System.out.println("Equilateral");
				else if (a == b || b == c || c == a)
					System.out.println("Isosceles");
				else
					System.out.println("Scalene");
			} else
				System.out.println("Invalid");
		}
	}

}
