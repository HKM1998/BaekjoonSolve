package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX24860 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long vj1 = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long vj2 = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long vdj = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken())
				* Long.parseLong(st.nextToken());
		long result = (vj1 + vj2) * vdj;
		System.out.print(result);
	}

}
