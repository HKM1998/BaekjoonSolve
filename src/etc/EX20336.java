package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class EX20336 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] menuList = new String[N];
		for (int i = 0; i < N; i++) {
			menuList[i] = br.readLine();
		}
		int random = new Random().nextInt(N);
		
		for(String str : menuList[random].split(" ")) {
			System.out.println(str);
		}
	}

}
