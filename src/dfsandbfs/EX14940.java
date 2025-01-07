package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX14940 {
	static int[][] A;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] start = null;
		A = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) 
					start = new int[]{i, j};
				A[i][j] = num;
			}
		}
		
		bfs(start);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visit[i][j] && A[i][j] != 0)
					sb.append(-1 + " ");
				else sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		A[start[0]][start[1]] = 0;
		visit[start[0]][start[1]] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i ++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if(x >=0 && y >= 0 && x < A.length && y < A[0].length) {
					if(!visit[x][y] && A[x][y] != 0) {
						A[x][y] += A[now[0]][now[1]];
						visit[x][y] = true;
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}
}
