package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX26068 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i < n; i++) {
			if(Integer.parseInt(br.readLine().split("-")[1]) <= 90)
				result++;
		}
		System.out.println(result);
	}

}
