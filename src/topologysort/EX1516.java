package topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1516 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		int[] D = new int[N+1];
		int[] time = new int[N+1];
		int[] timeResult = new int[N+1];
		for(int i = 0; i <= N ; i++)
			arr.add(new ArrayList<Integer>());
		
		for(int i = 1; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			int now;
			while((now = Integer.parseInt(st.nextToken())) > 0) {
				arr.get(now).add(i);
				D[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			if(D[i] == 0) {
				queue.add(i);
				timeResult[i] += time[i];
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : arr.get(now)) {
				D[i]--;
				timeResult[i] = Math.max(timeResult[i], timeResult[now] + time[i]);
				if(D[i]==0)
					queue.add(i);
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.println(timeResult[i]);
		}
	}

}
