package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EX1377 {

	public static void main(String[] args) throws IOException {
		// 교재 소스보고 작성하였음
		// 새로운 클래스를 지정하여 정렬후 진행이라는 발상을 하지 못했음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		indexValue[] A = new indexValue[N];
		for(int i =0 ; i< N; i++) {
			A[i] = new indexValue(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(A);
		int Max = 0;
		
		for (int i=0; i<N; i++) {
			if(Max < A[i].index - i)
				Max = A[i].index - i; 
		}
		System.out.println(Max + 1);
	}
}

// Comparable 인터페이스를 상속하여 정렬 기준 지정 가능
// Comparable 사용법을 정리하고 갈 필요성 있음
class indexValue implements Comparable<indexValue>{
	int value;
	int index;
	
	public indexValue(int value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(indexValue o) {
		// 자기 자신에서 비교할 값을 빼줌으로써 
		// 자신이 크면 양수
		// 같으면 0
		// 비교대상이 크면 음수
		// 위 3가지 케이스의 조건문 생략 가능(overflow 에 주의하여 사용하여야 함.)
		return this.value - o.value;
	}
	
	
}
