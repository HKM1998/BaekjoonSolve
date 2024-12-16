package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX2164 {

	public static void main(String[] args) {
		// Queue 사용법만 확인하고 작성한 코드
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Queue<Integer> cardQ = new LinkedList<Integer>();
		
		for(int i = 1; i<=n ; i++) {
			cardQ.add(i);
		}
		
		while(cardQ.size() > 1) {
			cardQ.poll();
			cardQ.add(cardQ.poll());
		}
		
		System.out.println(cardQ.peek());
	}
}
