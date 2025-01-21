package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX1043 {
	static int[] A;
	static int[] truth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		if (K > 0) {
			truth = new int[K];
			for (int i = 0; i < K; i++)
				truth[i] = Integer.parseInt(st.nextToken());
		} else {
			System.out.println(M);
			return;
		}

		int[][] party = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			party[i] = new int[p];
			for (int j = 0; j < p; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
				if (j > 0)
					union(party[i][j - 1], party[i][j]);
			}
		}

		int pCount = 0;
		for (int i = 0; i < M; i++) {
			boolean known = false;
			for (int j = 0; j < party[i].length; j++) {
				for (int k : truth) {
					if (find(k) == find(party[i][j])) {
						known = true;
						break;
					}
				}
				if (known)
					break;
			}
			if (!known)
				pCount++;
		}
		System.out.println(pCount);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			A[b] = a;
		}
	}

	static int find(int a) {
		if (A[a] == a)
			return a;
		else
			return A[a] = find(A[a]);
	}
}
