package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX1541 {
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// 괄호 하나만 사용해서 값 구하는 것으로 인지해서 문제를 틀렸었음
		// 괄호 여러개 사용 가능하므로 "-" 뒤 값을 합쳐서 빼도록 소스 수정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("[^0-9]");
		String[] arrpn = str.split("[0-9]+");
		
		int result = Integer.parseInt(arr[0]);
		for(int i = 1; i < arrpn.length; i++) {
			int temp = Integer.parseInt(arr[i]);
			if(arrpn[i].equals("-")) {
				for(int j = i+1 ; j < arr.length; j++) {
					if(arrpn[j].equals("-")) {
						break;
					}else
						temp += Integer.parseInt(arr[j]);
					i++;
				}
				result -= temp;
			}
			else
				result += Integer.parseInt(arr[i]);
		}
		
		System.out.println(result);
	}
	
	static void bookAnswer() throws IOException {
		// 교재 풀이 "-" 로만 나눈뒤 +값들을 합치고 계산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("-");
		
		for(int i = 0; i < arr.length; i++) {
			int temp = bookSum(arr[i]);
			if(i==0)
				answer += temp;
			else
				answer -= temp;
		}
		
		System.out.println(answer);
	}
	static int bookSum(String a) {
		int sum =0;
		String[] temp = a.split("+");
		for(int i =0; i< temp.length;i++) {
			sum += Integer.parseInt(temp[i]);
		}
		
		return sum;
	}
}
