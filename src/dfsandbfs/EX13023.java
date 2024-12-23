package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EX13023 {
	static ArrayList<Integer>[] A;
	static boolean[] visit;
	static boolean result;
	
	public static void main(String[] args) throws IOException {
		// 교재 안보고 풀이하였음
		// 너무 어렵게 생각해서 각 값이 이어져야한다 라고 생각함
		// 교재 풀이는 탐색의 깊이가 5면 종료 
		// -> 문제가 시간복잡도가 더 어렵게 되어있었으면 오답이였음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N];
		visit = new boolean[N];

		for(int i = 0; i < N ; i++) 
			A[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}
		
		result = false;
		
		for(int i = 0; i < N; i++ ) {
			if(result) {
				break;
			}
			myDFS(i, 0);
			//bookDFS(i, 1);
		}
		System.out.println(result ? 1 : 0);
		
	}
	
	static void myDFS(int num, int depth) {
		if(result)
			return;
		if(depth == 4) {
			if(!visit[num])
				result = true;
			return;
		}else {
			visit[num] = true;
			for(int i : A[num]) {
				if(visit[i]) continue;
				myDFS(i, depth + 1);
				if(result)
					return;
			}
			visit[num] = false;
		}
	}

	static void bookDFS(int now, int depth) {
		// 기본적인 틀은 비슷하나 조건문이 더 간결함!
		if(depth == 5 || result) {
			result = true;
			return;
		}
		visit[now] = true;
		for(int i : A[now]) {
			if(!visit[i]) {
				bookDFS(i, depth+1);
			}
		}
		visit[now] = false;
	}
}
