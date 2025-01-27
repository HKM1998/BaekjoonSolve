package topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1948 {

	public static void main(String[] args) throws IOException {
		// 풀이와 수도코드만 작성하였음
		// 아직 위상 정렬에 대한 활용은 부족,,,, 공부 더 해야할듯
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<node>> arr = new ArrayList<ArrayList<node>>();
		ArrayList<ArrayList<node>> rArr = new ArrayList<ArrayList<node>>();
		int[] D = new int[n + 1];
		int[] time = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<node>());
			rArr.add(new ArrayList<node>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			arr.get(S).add(new node(E, T));
			rArr.get(E).add(new node(S, T));
			D[E]++;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(node next : arr.get(now)) {
				D[next.city]--;
				time[next.city] = Math.max(time[next.city], time[now] + next.time);
				if(D[next.city] == 0) {
					queue.add(next.city);
				}
			}
		}
		
		boolean[] visited = new boolean[n + 1];
		int count = 0;
		queue.add(end);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(node next : rArr.get(now)) {
				if(next.getTime() == (time[now] - time[next.city])) {
					count++;
					if(!visited[next.city]) {
						queue.add(next.city);
						visited[next.city] = true;
					}
				}
			}
		}
		
		System.out.println(time[end]);
		System.out.println(count);
	}

}

class node {
	int city;
	int time;

	public node(int a, int b) {
		this.city = a;
		this.time = b;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}