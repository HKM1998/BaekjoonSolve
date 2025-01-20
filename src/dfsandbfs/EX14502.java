package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX14502 {
	static int[][] A;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int zeroCount = 0;
	static ArrayList<int[]> startIdx = new ArrayList<int[]>();
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == 2) {
					startIdx.add(new int[] { i, j });
					visited[i][j] = true;
				} else if (A[i][j] == 0) {
					zeroCount++;
				} else {
					visited[i][j] = true;
				}
			}
		}
		int max = 0;
		
		for(int i = 0; i < N * M ; i ++) {
			if(visited[i/M][i%M]) continue;
			for(int j = i+1; j < N * M ; j ++) {
				if(visited[j/M][j%M]) continue;
				for(int k = j+1; k < N * M ; k ++) {
					if(visited[k/M][k%M]) continue;
					boolean[][] cloneVisit =  new boolean[N][M];
					for(int l = 0; l < visited.length; l++)
						System.arraycopy(visited[l], 0, cloneVisit[l], 0, cloneVisit[l].length);
					cloneVisit[i/M][i%M] = true;
					cloneVisit[j/M][j%M] = true;
					cloneVisit[k/M][k%M] = true;
					int nowZero = BFS(cloneVisit);
					max = max > nowZero ? max : nowZero;
				}
			}
		}
		
		System.out.println(max);
	}

	static int BFS(boolean[][] cloneVisited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int nowZero = zeroCount - 3; // 기둥 3개를 추가로 세우므로 0 개수가 3개 작아야함!
		for (int[] start : startIdx) {
			queue.add(start);
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if(x >= 0 && x < N && y >= 0 && y < M) {
					if(!cloneVisited[x][y] && A[x][y] == 0) {
						cloneVisited[x][y] = true;
						nowZero--;
						queue.add(new int[] {x, y});
					}
				}
			}

		}
		return nowZero;
	}
}
