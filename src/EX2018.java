
import java.util.Scanner;

public class EX2018 {
	public static void main(String[] args) {
		// 교재의 풀이 방식대로 진행
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 1; // n 값이 무조건 1번 해당되므로 1에서 시작
		int sum = 1; // 연속된 숫자의 합계
		int startIndex = 1; // 합계 시작위치
		int endIndex = 1; // 합계 종료위치
		
		// endIndex가 +1 씩 진행하여 n과 같아질때 종료
		while(endIndex != n) {
			// 합계가 n 값 보다 큰경우 기존 시작위치를 합계에서 빼고 시작위치 +1
			if(sum > n) {
				sum -= startIndex;
				startIndex++;
			}
			// 합계가 n 보다 작은 경우 종료 위치+1, 합계에 더하기
			else if(sum < n) {
				endIndex++;
				sum += endIndex;
			}
			// 합계와 n 값이 같은 경우 종료지점+1, 합계에 더하기, 결과값에 1 추가
			else { // (sum == n)
				endIndex++;
				sum += endIndex;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
