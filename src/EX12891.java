import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX12891 {
	// 교재 풀이용 static 변수 선언
	static int[] checkArr;
	static int[] myArr;
	static int checkSecret;
	
	static void mySolution() throws IOException{
		/*
		 * 풀이 보기전 작성한 코드
		 * 1. 문자열을 String 클래스의 toCharArray() 메서드를 통해 Char[] 로 변환
		 * 2. 각 문자 A, C, G, T 별 최소 개수를 변수에 저장
		 * 3. 최초 p 구간에 대한 각 문자 카운트를 구하고 최초 결과값 확인
		 * 4. p구간을 i번째로 이동 시켯다고 가정했을 때 인덱스 i번은 제외 i-p+1번 인덱스는 추가
		 * 5. 기존 문자 개수 카운트에 추가, 감소되는 값만 계산한 후 조건을 만족하는지 확인
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());

		char[] arr = st.nextToken().toCharArray();

		st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int result = 0;
		int aCount = 0;
		int cCount = 0;
		int gCount = 0;
		int tCount = 0;
		
		for (int i = 0; i < p; i++) {
			switch (arr[i]) {
			case 'A':
				aCount++;
				break;
			case 'C':
				cCount++;
				break;
			case 'G':
				gCount++;
				break;
			case 'T':
				tCount++;
				break;
			}
		}

		if (a <= aCount && c <= cCount && g <= gCount && t <= tCount)
			result++;
		
		for (int i = 1; i <= s - p; i++) {
			switch (arr[i-1]) {
			case 'A':
				aCount--;
				break;
			case 'C':
				cCount--;
				break;
			case 'G':
				gCount--;
				break;
			case 'T':
				tCount--;
				break;
			}
			switch (arr[i-1+p]) {
			case 'A':
				aCount++;
				break;
			case 'C':
				cCount++;
				break;
			case 'G':
				gCount++;
				break;
			case 'T':
				tCount++;
				break;
			}
			
			if (a <= aCount && c <= cCount && g <= gCount && t <= tCount)
				result++;
		}

		System.out.println(result);
	}
	
	static void bookSolution() throws IOException{
		/*
		 * 교재 풀이 
		 * 구간의 각 문자 합을 저장하는 배열을 만들고
		 * Add, Remove 메서드를 만들어 호출하도록 만듬
		 * 4가지 조건을 모두 만족하는지 여부는 checkSecret 으로 선언된 변수를 통해
		 * 각 조건이 만족되는 시점에 ++, 각 조건이 불만족되는 시점에 -- 를 통해
		 * checkSecret 의 값이 4인 경우 조건을 만족하므로 반복시 추가 삭제를 진행하고, 조건 만족시 결과값 +1
		 */
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int result = 0;
		char[] A = new char[s];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		
		A = bf.readLine().toCharArray();
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0;i<4;i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i]==0)
				checkSecret++;
		}
		for(int i = 0;i < p;i++) {
			Add(A[i]);
		}
		if(checkSecret == 4)
			result++;
		
		for(int i = p; i<s; i++) {
			int j = i-p;
			Add(A[i]);
			Remove(A[j]);
			if(checkSecret == 4) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static void Add(char c) {
		switch (c) {
		case 'A': 
			myArr[0]++;
			if(myArr[0] == checkArr[0])
				checkSecret++;
			break;
		case 'C': 
			myArr[1]++;
			if(myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case 'G': 
			myArr[2]++;
			if(myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case 'T': 
			myArr[3]++;
			if(myArr[3] == checkArr[3])
				checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) {
		switch (c) {
		case 'A': 
			if(myArr[0] == checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case 'C': 
			if(myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case 'G': 
			if(myArr[2] == checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case 'T': 
			if(myArr[3] == checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		mySolution();
		
	}

}
