package stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class AbsoluteValue{
	int absoluteValue;
	int value;
	
	public AbsoluteValue(int value) {
		this.absoluteValue = Math.abs(value);
		this.value = value;
	}
}

class AbsoluteValueComparator implements Comparator<AbsoluteValue>{
	@Override
	public int compare(AbsoluteValue o1, AbsoluteValue o2) {
		if(o1.absoluteValue == o2.absoluteValue) {
			return o1.value - o2.value;
		}
		else {
			return o1.absoluteValue - o2.absoluteValue;
		}
	}
}

public class EX11286 {

	public static void main(String[] args) throws IOException {
		// 교재의 우선순위 큐 사용만 확인 후 작성한 코드 
		// 우선순위 큐의 사용법은 아래 URL 참조
		// https://kbj96.tistory.com/49
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<AbsoluteValue> priorityQueue 
				= new PriorityQueue<AbsoluteValue>(1,new AbsoluteValueComparator());
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(priorityQueue.isEmpty()) {
					System.out.println("0");
				}
				else
					System.out.println(priorityQueue.poll().value);
			}
			else
				priorityQueue.add(new AbsoluteValue(num));
		}
	}

}
