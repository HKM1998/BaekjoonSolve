package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1325 {
	static ArrayList<Integer>[] A;
	static int[] D;
	static boolean[] visit;
	static int maxValue = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		D = new int[N+1];
		
		for(int i = 1; i <= N ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		for(int i = 1; i <= N ; i++) {
			visit = new boolean[N+1];
			BFS(i);
		}
		
		for(int i = 1; i <= N; i++) {
			if(D[i] == maxValue) System.out.print(i +" ");
		}
	}

	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.clear();
		queue.add(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			for(int newNode : A[nowNode]) {
				if(!visit[newNode]) {
					visit[newNode] = true;
					D[newNode] ++;
					if(maxValue < D[newNode])
						maxValue = D[newNode]; 
					queue.add(newNode);
				}
			}
		}
	}
}
