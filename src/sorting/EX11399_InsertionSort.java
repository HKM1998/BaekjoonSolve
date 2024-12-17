package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX11399_InsertionSort {

	void insertionSort() throws IOException {
		// 교재의 선택정렬 사용 풀이
		// 확인할 값을 구간에 삽입할 위치 확인 후
		// 삽입 위치부터 기존값을 쉬프트 후 삽입
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] S = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			int insert_pos = i;
			int insert_value = A[i];
			for(int j = i -1; j >= 0; j--) {
				if(A[i] > A[j]) {
					insert_pos = j + 1;
					break;
				}
				if(j == 0)
					insert_pos = j;
			}
			for(int j = i; j > insert_pos; j--) {
				A[j] = A[j - 1];
			}
			A[insert_pos] = insert_value;
		}
		S[0] = A[0];
		for(int i = 1; i< N;i++)
			S[i] = S[i-1] + A[i];
		int sum = 0;
		for(int i : S)
			sum += i;
		System.out.println(sum);
	}
	
	void arraysSort() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] S = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		S[0] = A[0];
		for(int i = 1; i< N;i++)
			S[i] = S[i-1] + A[i];
		int sum = 0;
		for(int i : S)
			sum += i;
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws IOException {

	}

}
