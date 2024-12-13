import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX1253 {

	public static void main(String[] args) throws IOException {
		// 직접 풀었을때에는 n 번째 값을 첫번째 값 부터 n-1번째 사이 값의 합이 일치하는지 확인 하도록 설계
		// 음수일때를 고려하지 못하여 n 번째 = 가장 큰수 라는 전제가 잘못된 것을 확인
		// 전체 값을 다 확인하도록 하였음
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] numArray = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numArray);
		int startIdx, endIdx;
		int count = 0;
		for (int i = 0; i < n; i++) {
			startIdx = 0;
			endIdx = n - 1;
			while (startIdx < endIdx) {
				if (numArray[startIdx] + numArray[endIdx] < numArray[i]) {
					startIdx++;
				} else if (numArray[startIdx] + numArray[endIdx] > numArray[i]) {
					endIdx--;
				} else {
					if (startIdx != i && endIdx != i) {
						count++;
						break;
					}
					else if (startIdx == i)
						startIdx++;
					else if(endIdx == i)
						endIdx--;
				}
			}
		}
		System.out.println(count);
	}

}
