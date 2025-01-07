package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX27172 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean[] player = new boolean[1000001];
		int[] playerIndex = new int[N];
		int[] score = new int[1000001];
		
		for(int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			player[idx] = true;
			playerIndex[i] = idx;
		}
		for(int i = 0; i < N ; i++) {
			if(playerIndex[i] < 5000001) {
				for(int j = playerIndex[i] + playerIndex[i]; j <= 1000000 ; j += playerIndex[i]) {
					if(player[j]) {
						score[playerIndex[i]]++;
						score[j]--;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(score[playerIndex[i]] + " ");
		}
		System.out.print(sb.toString());
	}

}
