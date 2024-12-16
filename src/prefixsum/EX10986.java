package prefixsum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX10986 {

	public static void main(String[] args) throws IOException {
		// 문제만 보고는 풀이가 생각나지 않아 교재 참고
		// 슈도코드 보고 작성한 소스임
		// 1. (a + b) % c  ==  ((a % c) + (b % c)) % c 또한 동일한 결과
		// 2. 1 에 따라 각 구간의 합의 나머지 연산과 특정 구간의 나머지 연산의 결과는 동일 
		// 3. sumArray[j] - sumArray[i - 1] 은 i부터 j까지의 합계이므로
		// 4. 합계 구간의 나머지 값이 같다면 해당 구간의 합계의 나머지는 0
		// 		=> 동일 값인 경우 해당 값 사이 구간의 합은 나머지가 0인 결과값 (나머지가 0인 값)
		// 5. 따라서 동일한 나머지 값을 가지는 배열합의 조합 수를 구하면 됨.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long count = 0;
		long[] sumArray = new long[n];
		long[] comArray = new long[m];
		
		st = new StringTokenizer(bf.readLine());
		
		// 합 배열 생성
		sumArray[0] = Integer.parseInt(st.nextToken());	
		for(int i = 1; i < n ; i++) {
			sumArray[i] = sumArray[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		//각 배열 합의 나머지 값을 구함	
		for(int i = 0; i< n ; i++) {
			int remainder = (int)(sumArray[i] % m);
			if(remainder == 0)
				count++;
			comArray[remainder]++;
		}
		
		// 나머지 값 개수 배열의 각 자리의 조합 수 구하여 합함
		for(int i = 0; i < m ; i++) {
			if(comArray[i] > 1) {
				count += (comArray[i] * (comArray[i] - 1)) / 2;
			}
		}
		
		System.out.println(count);
		
	}

}
