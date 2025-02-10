package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX9468 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nowP = Integer.parseInt(st.nextToken());
			int count = 0;
			int temp = 0;
			for(int j = 0; j < 15; j ++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(temp > num) {
					count++;
					temp = num;
				}else
					temp = num;
			}
			
			System.out.println(nowP + " " + count);
		}
	}
}
