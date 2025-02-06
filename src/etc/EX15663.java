package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX15663 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		print("", 1);
		
		System.out.println(sb.toString());
	}

	static void print(String tmp, int depth) {
		if(depth == m) {
			for(int i = 0; i < n ; i++) {
				if(visited[i]) continue;
				if(depth != 1) {
					sb.append(tmp);
					sb.append(" ");
				}
				sb.append(arr[i]);
				sb.append("\n");
			}
		}else {
			for(int i = 0; i <n ; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				if(depth != 1)
					print(tmp + " " + arr[i], depth+1);
				else 
					print("" + arr[i], depth+1);
				visited[i] = false;
			}
		}
	}
}
