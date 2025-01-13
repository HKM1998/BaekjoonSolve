package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EX11725 {
	static ArrayList<Integer>[] arr;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new ArrayList[N + 1];
		parents = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
					
			arr[a].add(b);
			arr[b].add(a);
		}

		DFS(1);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i] +"\n");
		}
		System.out.println(sb.toString());
	}

	static void DFS(int node) {
		visited[node] = true;
		for (int next : arr[node]) {
			if(!visited[next]) {
				parents[next] = node;
				DFS(next);
			}
		}
	}
}
