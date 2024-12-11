import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX2750_A {
	public static void main(String[] args) throws IOException{
		// 시간 복잡도 N^2
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int temp = 0;
		int[] intArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			intArr[i] = Integer.parseInt(bf.readLine());
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n - i; j++) {
				if(intArr[j] > intArr[j+1]) {
					temp = intArr[j];
					intArr[j] =intArr[j+1];
					intArr[j+1] = temp;
				}
			}
		}
		
		for(int i : intArr) {
			System.out.println(i);
		}
	}
}
