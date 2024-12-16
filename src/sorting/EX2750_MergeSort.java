package sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2750번 문제
// Do it 알고리즘에서 병합정렬에 대한 언급이 있어 실습
// 구현의 난이도는 오르더라도 시간 복잡도에서 이득
// 참조링크 https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html 
public class EX2750_MergeSort {
	static int[] sortedArray;
	
	static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		int l = 0;
		
		/*
		 * 왼쪽 인덱스가 중간보다 작고 
		 * 중간값 + 1 값이 오른쪽 인덱스 보다 작을때 실행
		 * 		-> 최소 단위 일때까지 실행, 최소 단위일때 실행 안함
		 * 왼쪽 끝값과 중앙값을 비교
		 * 		-> 각 구간의 최소 단위부터 실행됨
		 */
		while(i<=mid && j <= right) {
			if(arr[i]<=arr[j]) 
				sortedArray[k++] = arr[i++];
			else 
				sortedArray[k++] = arr[j++];
		}
		
		// 왼쪽 인덱스가 중앙값 보다 큰경우 중앙값 부터 오른쪽 끝값까지 정렬된 배열에 저장,
		// 아닌 경우 왼쪽 값부터 중앙값 까지 저장
		// -> 저장 안된 값들을 옮겨주기
		if(i>mid)
			for(l = j; l<=right;l++)
				sortedArray[k++] = arr[l];
		else
			for(l = i; l<=mid;l++)
				sortedArray[k++] = arr[l];
		
		// 정렬된 배열을 다시 기존 배열에 대입
		for(l = left;l<=right;l++)
			arr[l] = sortedArray[l];
	}
	
	static void mergeSorting(int[] arr, int left, int right) {
		int mid = 0;
		
		// 매개변수 left(왼쪽 끝 인덱스)가 right(오른쪽 끝 인덱스) 보다 작아야만 실행
		// 분할 가능한 최소치까지 분할 한다는 뜻
		if(left < right) {
			// 입력 매개변수 기준 중간 값으로 균등하게 분할
			mid = (left+right)/2;
			// 분할 앞 부분 배열 정렬
			mergeSorting(arr, left, mid);
			// 분할 뒤 부분 배열 정렬
			mergeSorting(arr, mid+1, right);
			// 배열 병합 밑 정렬
			merge(arr, left, mid, right);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int[] inputArr = new int[n];
		sortedArray = new int[n];

		for (int i = 0; i < n; i++) {
			inputArr[i] = Integer.parseInt(bf.readLine());
		}
		
		// 합병정렬 시행 (입력배열, 배열 시작, 배열 끝)
		mergeSorting(inputArr, 0, n - 1);
		
		for(int i: sortedArray)
			System.out.println(i);
	}

}
