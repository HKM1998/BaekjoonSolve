package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EX1033 {
	static ArrayList<node>[] list;
	static boolean[] visit;
	static long lcm;
	static long[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		visit = new boolean[N];
		D = new long[N];
		lcm = 1;

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<node>();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			list[a].add(new node(b, p, q));
			list[b].add(new node(a, q, p));
			lcm *= ((p * q) / gcd(p, q));
		}
		D[0] = lcm;
		DFS(0);
		long mgcd = D[0];
		for (int i = 0; i < N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " ");
		}
	}

	static long gcd(long a, long b) {
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}

	static void DFS(int now) {

		visit[now] = true;
		for (node n : list[now]) {
			if (!visit[n.b]) {
				D[n.b] = D[now] * n.q / n.p;
				DFS(n.b);
			}
		}
	}
}

class node {
	int b;
	int p;
	int q;

	node(int b, int p, int q) {
		this.b = b;
		this.p = p;
		this.q = q;
	}
}