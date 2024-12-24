package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1697 {
	static int N, K;
	static int[] time = new int[200001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		BFS();

		System.out.println(time[K]);
	}

	static void BFS() {
		Queue<Position> queue = new LinkedList<Position>();
		if (N == K)
			return;
		queue.add(new Position(N, 0));

		while (!queue.isEmpty()) {
			Position now = queue.poll();
//			if (now == K)
//				return;
			int nowTime = now.time;
			if(nowTime != time[now.pos]) continue;
			
			int dN = now.pos * 2;
			int pN = now.pos + 1;
			int mN = now.pos - 1;
			
			if (pN <= K && (time[pN] == 0 || time[pN] > nowTime + 1)) {
				queue.add(new Position(pN, nowTime + 1));
				time[pN] = nowTime + 1;
			}

			if (mN >= 0 && (time[mN] == 0 || time[mN] > nowTime + 1)) {
				queue.add(new Position(mN, nowTime + 1));
				time[mN] = nowTime + 1;
			}
			
			if (dN <= K * 2 && (time[dN] == 0 || time[dN] > nowTime + 1)) {
				queue.add(new Position(dN, nowTime + 1));
				time[dN] = nowTime + 1;
			}
		}
	}
}

class Position{
	int pos;
	int time;
	
	public Position(int pos, int time) {
		this.pos = pos;
		this.time = time;
	}
}
