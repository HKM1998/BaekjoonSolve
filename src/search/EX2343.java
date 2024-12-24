package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 길이 n, 분할 수 m 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] A = new int[n];

		st = new StringTokenizer(br.readLine());
		int start = 0;
		int end = 0;
		// 배열 입력
		// 합계 값을 찾기 위해 시작 인덱스, 종료인덱스 지정
		// 합계에 대한 탐색이기 때문에 
		// 시작 위치 = 배열의 최댓값
		// 종료 위치 = 배열 전체 합계
		for(int i = 0; i< n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			start = start > A[i]? start:A[i];
			end += A[i];
		}
		
		while(start <= end) {
			int mid = (start + end)/2;
			int sum = 0;
			int count = 0;
			for(int i = 0; i < n; i++) {
				if(sum + A[i] > mid) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if(sum > 0) count ++;
			if(count > m) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		System.out.println(start);
		
	}

}
