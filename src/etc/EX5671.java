package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX5671 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while(true) {
			str = br.readLine();
			if (str == null) break;
			st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] nCount;
			int count = m - n + 1;
			for(int i = n; i <= m; i++) {
				nCount = new int[11];
				for(int j = 0; j < (int)Math.log10(i) + 1; j++) {
					
					nCount[(i/(int)Math.pow(10, j) % 10)]++;
				}
				for(int j = 0; j <10;j++) {
					if(nCount[j]>1) {
						count--;
						break;
					}
				}
			}
			
			System.out.println(count);
		}
	}

}
