package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX18352 {
	static ArrayList<Integer>[] A;
	static boolean[] visit;
	static int[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		visit = new boolean[N+1];
		D = new int[N+1];
		
		for(int i =0; i <= N ;i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i =0; i < M ;i++) {
			st = new StringTokenizer(br.readLine());
			A[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		BFS(X);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(D[i]==K) sb.append(i + "\n");
		}
		if(sb.length() > 0) System.out.println(sb.toString());
		else System.out.println(-1);
		
	}
	static void BFS(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		visit[num] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : A[now]) {
				if(!visit[i]) {
					visit[i] = true;
					D[i] = D[now] + 1;
					queue.add(i);
				}
			}
		}
	}
}
