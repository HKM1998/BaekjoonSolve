package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EX1167 {
	static ArrayList<Edge>[] A;
	static boolean[] visited;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		// 정점의 개수 V 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());

		A = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		distance = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			A[i] = new ArrayList<Edge>();
		}

		// 정점과 연결된 다른 정점 및 거리 입력(-1 이 나올때까지)
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			while (true) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1)
					break;
				int weight = Integer.parseInt(st.nextToken());
				A[S].add(new Edge(node, weight));
			}
		}

		// BFS 실행
		// 처음 위치에서 가장 멀리있는 노드를 구함
		BFS(1);

		int maxIndex = 1;
		for (int i = 2; i <= V; i++) {
			if (distance[maxIndex] < distance[i]) {
				maxIndex = i;
			}
		}
		visited = new boolean[V + 1];
		distance = new int[V + 1];
		
		//가장 먼위치의 노드에서 다시 가장 먼 노드를 구해 지름을 구함
		BFS(maxIndex);
		Arrays.sort(distance);
		System.out.println(distance[V]);
	}

	static void BFS(int node) {
		// BFS 구현
		// 최대 거리 구하기
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;
		while (!queue.isEmpty()) {
			int nowEdge = queue.poll();
			for (Edge edge : A[nowEdge]) {
				int n = edge.node;
				int w = edge.weight;
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					// 현재 노드의 이동거리 + 다음노드까지의 거리를 다음노드 거리에 대입
					distance[n] = distance[nowEdge] + w; 
				}
			}
		}
	}
}

class Edge {
	int node;
	int weight;

	Edge(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}