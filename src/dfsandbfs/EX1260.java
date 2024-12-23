package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1260 {
	static ArrayList<Integer>[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// BFS 의 구현방법을 몰라 교재 참고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i = 1 ; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}

		for(int i = 1 ; i <= n; i++) {
			A[i].sort(Comparator.naturalOrder()); // ArrayList 오름차순 정렬
		}
		
		DFS(v);
		System.out.println();
		
		visited = new boolean[n+1];
		BFS(v);
	}
	
	static void DFS(int now) {
		if(visited[now]) return;
		visited[now] = true;
		System.out.print(now + " ");
		for(int i : A[now]) {
			if(!visited[i])
				DFS(i);
		}
	}
	
	static void BFS(int now) {
		// Queue 를 LinkedList 로 선언하여 사용
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(now);
		visited[now] = true;
		
		while(!Q.isEmpty()) { // Queue 가 빌때까지 반복
			int nowQ = Q.poll();
			System.out.print(nowQ + " ");
			for(int i : A[nowQ]) {
				if(!visited[i]) {
					visited[i] = true;
					Q.add(i);	
				}
			}
		}
	}

}
