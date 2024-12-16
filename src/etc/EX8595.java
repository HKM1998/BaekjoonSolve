package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX8595 {

	static void useRegexSolution() throws IOException{
		// 실무하던 시기에 정규식을 사용해서
		// 문자열 핸들링하던 방법이 생각나서 사용해 보았음
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		String str = st.nextToken().trim();
		
		//String[] array = st.nextToken().trim().split("[^0-9]");
		String[] array = str.split("[^0-9]+");
		//String[] array2 = str.split("[a-zA-Z]+");
		
		long sum = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == "") continue;
			sum += Integer.parseInt(array[i]);
		}
		System.out.println(sum);
	}
	
	static void notUseRegexSolution() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		char[] charArray = st.nextToken().toCharArray();
		
		long sum = 0;
		int num = 0;
		for(int i = 0;i < n; i++) {
			// 숫자가 아닌경우
			if(!(charArray[i] >= '0'&& charArray[i] <= '9')) {
				sum += num;
				num = 0;
				continue;
			}
			
			num *= 10;
			num += (int)charArray[i] - (int)'0';
		}
		sum += num;
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws IOException{
		notUseRegexSolution();
	}

}
