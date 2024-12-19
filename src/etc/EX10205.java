package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX10205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1;i <= n ; i++) {
			int h = Integer.parseInt(br.readLine());
			char[] action = br.readLine().toCharArray();
			
			for(int j = 0; j < action.length; j++) {
				if(h == 0) break;
				if(action[j] == 'c') {
					h++;
				}
				else {
					h--;
				}
			}
			System.out.println("Data Set " + i + ":");
			System.out.println(h + "\n");
		}
	}

}
