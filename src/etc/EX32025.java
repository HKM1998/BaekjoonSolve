package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX32025 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		
		System.out.println(H > W ? W * 50 : H * 50);
	}

}
