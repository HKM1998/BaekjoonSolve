package topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> Arr = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			Arr.add(new ArrayList<Integer>());

		int[] indegree = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			Arr.get(S).add(E);
			indegree[E]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N ; i++) {
			if(indegree[i]==0)
				queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now + " ");
			for(int next : Arr.get(now)) {
				indegree[next]--;
				if(indegree[next] == 0)
					queue.add(next);
			}
		}
		
		System.out.println(sb.toString());
	}
}