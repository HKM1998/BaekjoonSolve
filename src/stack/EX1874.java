package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class EX1874 {

	public static void main(String[] args) throws IOException {
		/*
		 * 교재의 풀이를 보고 작성하였음 
		 * 스텍에 조건을 만족할때까지 값을 push 
		 * 다음값이 입력수열의 값보다 큰 경우 pop 
		 * pop 에서 나온 값이 입력수열의 값보다 큰 경우 불가능한 수열
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());			
		}
		
		int count = 1;
		StringBuilder sb = new StringBuilder();
		boolean result = true;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] >= count) {
				while(arr[i] >= count) {
					stack.push(count);
					sb.append("+\n");
					count++;
				}
				sb.append("-\n");
				stack.pop();
			}
			else {
				int num = stack.pop();
				if(num > arr[i]) {
					System.out.println("NO");
					result = false;
					break;
				}
				sb.append("-\n");
			}
		}
		if(result)
			System.out.println(sb.toString());
	}

}
