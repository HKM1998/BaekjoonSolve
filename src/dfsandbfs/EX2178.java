package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX2178 {
	static int[][] A; // 2차원 배열로 입력 정보 저장
	static boolean[][] visited;
	static int n, m;
	// 확인 할 위치 배열 생성 x,y 값 기준 4방향
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		A = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}

		BFS(0, 0);
		System.out.println(A[n - 1][m - 1]);
	}

	static void BFS(int i, int j) {
		// 큐에 x, y 위치 정보 저장
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j }); // 초기 위치 지정
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			// 4방향 확인을 위한 배열 dx, dy 값 사용
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				// 확인할 x,y 좌표가 유효한 경우 실행
				if (x >= 0 && y >= 0 && x < n && y < m) {
					// 배열의 값이 0이 아니고(이동 가능한 위치이고), 방문하지 않는 위치인 경우 실행
					if (A[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; // 이동한 횟수 정보를 위치에 저장(중복 확인 없으므로 depth)
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}
}