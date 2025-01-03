package needremind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX11723 {
	static boolean[] intArr = new boolean[21];

	public static void main(String[] args) throws IOException {
		// 비트 마스킹을 사용하는 방법이 존재한다고 해서 구현해보았음
		// 직접 처음부터 만들기에는 아직 이해 부족함 비슷한 문제 풀어봐야할듯!
		bitMasking();
	}

	static void bitMasking() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int set = 0;

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "add":
				set = set | (1 << Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if ((set & (1 << Integer.parseInt(st.nextToken()))) > 0)
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "remove":
				set = set & ~(1 << Integer.parseInt(st.nextToken()));
				break;
			case "toggle":
				set = set ^ (1 << Integer.parseInt(st.nextToken()));
				break;
			case "empty":
				set = 0;
				break;
			case "all":
				set = (1 << 21) - 1;
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}
	
	static void booleanArray() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "add":
				intArr[Integer.parseInt(st.nextToken())] = true;
				break;
			case "check":
				if (intArr[Integer.parseInt(st.nextToken())])
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "remove":
				intArr[Integer.parseInt(st.nextToken())] = false;
				break;
			case "toggle":
				int t = Integer.parseInt(st.nextToken());
				intArr[t] = !intArr[t];
				break;
			case "empty":
				intArr = new boolean[21];
				break;
			case "all":
				Arrays.fill(intArr, true);
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
