package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class EX1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		int result = 0;
		while(queue.size() != 1) {
			int a = queue.poll();
			int b = queue.poll();
			result += a + b;
			queue.add(a + b);
		}
		
		System.out.println(result);
	}

}
