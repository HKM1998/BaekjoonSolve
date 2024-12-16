package prefixsum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX11659 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt( st.nextToken());
		int m = Integer.parseInt( st.nextToken());
		int x = 0;
		int y = 0;
		
		// 메모리에 상관없이 에러 방지를 위해서는 long 타입 선언을 하는것이 좋음
		// 합 배열만 생성하여도 상관없음... -> 입력된 일반 배열은 사용하는 부분이 없음
		int[] inputArray = new int[n];
		long[] sumArray = new long[n];
		st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i<n;i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
			sumArray[i] = i > 0 ? sumArray[i - 1] + inputArray[i]:inputArray[i];
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			System.out.println(sumArray[y] - ((x-1 >= 0) ? sumArray[x-1] : 0) );
		}
	}

}
