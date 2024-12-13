package template;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str =  "aset56486cvz!@#";
		
		// 숫자를 제외한 문자열기준 split
		// 대괄호 안의 ^ 는 제외 밖의 ^은 시작
		String[] array1 = str.split("[^0-9]+");
		String[] array2 = str.split("^[a-zA-Z]+");
		
		// 숫자를 기준
		String[] array3 = str.split("^[0-9]*$");
		
		// ^[가-힣]*$  한글 
		// \\w+@\\w+\\.\\w+(\\.\\w+)?  이메일
		// ^\d{2,3}-\d{3,4}-\d{4}$  전화번호
		// ^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$  휴대전화번호
		// \d{6} \- [1-4]\d{6} 주만등록번호
		// ^\d{3}-\d{2}$  우편번호
	}

}
