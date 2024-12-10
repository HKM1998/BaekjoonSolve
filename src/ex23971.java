import java.util.Scanner;

public class ex23971 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();

		int a = h / (n + 1);
		int b = w / (m + 1);

		if (h % (n + 1) > 0)
			a++;
		if (w % (m + 1) > 0)
			b++;

		System.out.println(a * b);
	}

}
