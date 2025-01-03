package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class EX1764 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<String>();
		HashSet<String> resultSet = new HashSet<String>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String input = br.readLine();
			if(set.contains(input)) {
				resultSet.add(input);
			}
		}
		Object[] str = resultSet.toArray();
		Arrays.sort(str);
		System.out.println(str.length);
		for(Object s : str) {
			System.out.println(s.toString());
		}
	}

}
