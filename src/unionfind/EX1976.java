package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX1976 {
	static int[] city;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		city = new int[N + 1];
		for (int i = 1; i <= N; i++)
			city[i] = i;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int question = Integer.parseInt(st.nextToken());
				if (question != 1)
					continue;
				union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		int base = find(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i < M; i++) {
			if (base != find(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}

		}
		System.out.println("YES");

	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			city[b] = a;
		}
	}

	static int find(int a) {
		if (city[a] == a)
			return a;
		else
			return city[a] = find(city[a]);
	}
}
