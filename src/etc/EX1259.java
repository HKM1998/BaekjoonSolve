package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX1259 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) break;
			int lognum = (int)Math.log10(num) + 1;
			if(lognum%2 == 0)
				System.out.println("no");
			else {
				if(num % (10^lognum) == num % 10) {
					lognum--;
					
				}
			}
		}
	}

}
