package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1926 {
	static int[][] A;
	static boolean[][] visited;
	static ArrayList<Integer> picture;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int N, M;
	static int endX = 0;
	
	public static void main(String[] args) throws IOException {
		// 교제 BFS 문제만으로는 부족해서 예제 더 풀는 중
		// 정답 맞힌 후 결과 확인해보니 차라리 n, m 이중 for 문으로 BFS를 각 위치에서
		// 실행하고 방문 배열이 true 면 넘기도록 하는게 코드 짜기 편했을 것 같음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		visited = new boolean[N][M];
		picture = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j ++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0, 0 에서 시작하지 않고 1값을 가지는 위치에서 시작하도록 함
		int[] next = findNext();
		if(next != null)
			BFS(next[0],next[1]);
		
		// 최대 넓이 구하기 및 빈경우 0 출력
		int max = 0;
		for(int i = 0; i < picture.size(); i++) {
			if(max < picture.get(i))
				max = picture.get(i);
		}
		
		if(picture.isEmpty()) {
			System.out.println(picture.size());
			System.out.println(0);
		} else {
			System.out.println(picture.size());
			System.out.println(max);
		}
		
	}
	
	static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		int weight = 1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int k = 0; k < 4; k++) {
				int x= now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < N && y < M) {
					if(A[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						weight++;
						queue.add(new int[] {x,y});
					}
				}
			}
			// 큐 값이 비는경우 1개의 그림이 끝남
			// 따라서, 넓이값을 넓이 배열에 추가 및 초기화
			if(queue.isEmpty()) {
				if(weight > 0) {
					picture.add(weight);
					weight = 0;
				}
				int[] next = findNext();
				if(next == null) break;
				queue.add(new int[] {next[0],next[1]});
				visited[next[0]][next[1]] = true;
				weight++;
			}
		}
	}
	
	static int[] findNext() {
		for(int x = endX; x < N ; x ++) {
			for( int y = 0; y < M ; y++) {
				if(!visited[x][y] && A[x][y] == 1) {
					return new int[]{x, y};
				}
			}
			endX++;
		}
		return null;
	}

}
