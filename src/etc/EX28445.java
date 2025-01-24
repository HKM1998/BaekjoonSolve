package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class EX28445 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		set.add(st.nextToken());
		set.add(st.nextToken());
		st = new StringTokenizer(br.readLine());
		set.add(st.nextToken());
		set.add(st.nextToken());
		
		Object[] str = set.toArray();
		Arrays.sort(str);
		
		StringBuilder sb = new StringBuilder();
		for(Object h : str) {
			for(Object t : str) {
				sb.append(h + " " + t + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}
