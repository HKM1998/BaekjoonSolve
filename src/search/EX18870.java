package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EX18870 {

	public static void main(String[] args) throws IOException {
		// 풀이 참고 없이 이전 이진 탐색 문제 풀이를 보다 hashmap 을 사용하여 중복 제거를 하는 방법이 떠올라 활용
		// 각 배열의 값을 중복 제거 후 hashmap 에 담고 키 값의 배열을 정렬하여 value에 우선 순위 지정
		// 전체 배열에 대한 정렬이 필요없음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			A[i] = key;
			if(!map.containsKey(key))
				map.put(key, 0);
		}
		
		Object[] result = map.keySet().toArray();
		Arrays.sort(result);
		for(int i = 0; i < result.length ; i++) {
			map.put((int)result[i], i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : A) {
			sb.append(map.get(i) + " ");
		}
		System.out.println(sb);
	}

}
