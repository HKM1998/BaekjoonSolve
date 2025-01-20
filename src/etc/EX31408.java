package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class EX31408 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		int[] arr = new int[100001];
		for(int i = 0; i< N; i++) {
			int now = Integer.parseInt(st.nextToken());
			set.add(now);
			arr[now]++;
		}
		if(set.size() > 1) {
			int max = 0;
			
			for(Object i : set.toArray())
				max = arr[(int)i] > max ? arr[(int)i] : max;
			
			if(N % 2 == 0) {
				if(max <= N/2)
					System.out.println("YES");
				else
					System.out.println("NO");
			}else {
				if(max <= N/2+1)
					System.out.println("YES");
				else
					System.out.println("NO");
				
			}
		}
		else
			if(N == 1)
				System.out.println("YES");
			else
				System.out.println("NO");
	}

}
