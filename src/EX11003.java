import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EX11003 {
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		/* 
		 * 교재를 보고 코드 작성하였음
		 * Deque 구조를 개념만 알고 처음 사용해 보아서 구현 방법을 제대로 몰랐음
		 * Deque 를 통해 index(슬라이딩 윈도우 범위를 위해), value 값을 가지는 Node 클래스 배열 생성
		 * 1. 현재값과 덱의 마지막 value 값을 비교하고 덱의 값이 큰경우 덱의 마지막 값을 지워줌
		 * 2. 덱의 마지막에 현재 값 추가
		 * 		-> 덱이 빈경우 현재값 추가, 값이 있는 경우 현재값이 더 작으면 덱의 마지막 값 지우고 추가
		 * 		-> 현재 값이 더 크면 가지고만 있는 것(먼저 들어가있는 최솟값이 범위를 벗어나면 다음으로 작은값이므로)
		 * 3. 덱 첫번째 값이 인덱스 범위를 벗어나는 경우 첫번째 덱 삭제
		 * 위 과정을 반복하여 1번의 과정당 맨앞의 덱의 value 값이 구간별 최소 값이 됨
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Deque<Node> myDeque = new LinkedList<>(); 
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!myDeque.isEmpty() && myDeque.getLast().value > now) {
				myDeque.removeLast();
			}
			myDeque.addLast(new Node(now, i));
			
			if(myDeque.getFirst().index <= i -L) {
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
