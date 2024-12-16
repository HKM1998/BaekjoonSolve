package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class EX30958 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String str = bf.readLine();
		
		int[] count = new int[25];
		
		for(int i = 0; i< n; i++) {
			if((int)(str.charAt(i))>=(int)'a')
				count[(int)(str.charAt(i))-(int)'a']++;
		}
		Arrays.sort(count);
		System.out.println(count[count.length-1]);
	}

}
