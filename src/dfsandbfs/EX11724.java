package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX11724 {
	static ArrayList<Integer>[] A;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 문제 조건에서 정점이 1에서 시작하므로 0이 제외된 n+1 개 배열필요
		A = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		Arrays.fill(visit, false);

		// 1부터 n 까지 정점 배열 추가
		for (int i = 1; i < n + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 각 정점배열에 연결된 모든 정점 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		int count = 0;
		for( int i = 1; i <= n; i++) {
			if(!visit[i]) {
				DFS(i);
				count ++;
			}
		}
		System.out.println(count);
	}

	public static void DFS(int v) {
		// 방문한 정점은 실행 안함.
		if (visit[v])
			return;
		visit[v] = true; // 방문 배열 값 변경
		for (int i : A[v]) { // 연결된 모든 정점 확인
			if (!visit[i]) // 연결된 정점에 방문했으면 실행 안함
				DFS(i);
		}
	}
}
