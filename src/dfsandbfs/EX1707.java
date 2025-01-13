package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EX1707 {
	static ArrayList<Integer>[] arr;
	static int[] check;
	static boolean[] visited;
	static boolean isBinaryGraph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		for (int t = 0; t < K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr = new ArrayList[V + 1];
			check = new int[V+1];
			visited = new boolean[V + 1];
			isBinaryGraph = true;
			for (int i = 1; i <= V; i++) {
				arr[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a].add(b);
				arr[b].add(a);
			}

			for (int i = 1; i <= V; i++) {
				if (isBinaryGraph)
					DFS(i);
				else
					break;
			}

			if (isBinaryGraph)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static void DFS(int now) {
		visited[now] = true;
		for (int next : arr[now]) {
			if(!visited[next]) {
				check[next] = (check[now] + 1) % 2;
				DFS(next);
			}
			else if(check[now] == check[next]) {
				isBinaryGraph = false;
			}
		}
	}
}
