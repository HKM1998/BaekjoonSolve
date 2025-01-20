package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX1717 {
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new int[N+1];
		
		for(int i = 1; i <= N ; i++)
			A[i] = i;

		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(question== 0)
				union(a,b);
			else
				if(find(a) == find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
		}
	}
	

	static void union(int a, int b) {
		// 대표 노드끼리 합 연산
		a = find(a);
		b = find(b);
		if(a != b) {
			A[b] = a;
		}
	}
	
	static int find(int a) {
		// 인덱스와 대표노드가 같으면 리턴
		// 다른 경우 대표노드를 초기화 하면서 부모노드 find
		if(A[a] == a) return a;
		else return A[a] = find(A[a]);
	}
}
