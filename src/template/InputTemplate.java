package template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputTemplate {
	
	// 입력을 받을때 BufferedReader.readLine() 사용하는 경우
	// try-catch 혹은 throws 를 통해 IOException 을 처리해 주어야 한다.
	String getInputLine_BufferedReader() throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		/*
		 *
		 * String str = null;
		 * 
		 * try { str = in.readLine(); } catch (IOException e) { str = ""; }
		 */
		String str = null;
		str = in.readLine();
		
		// 아래 처럼 StringTokenizer 를 활용하여 데이터 핸들링
		//StringTokenizer st = new StringTokenizer(str);
		//int a = Integer.parseInt(st.nextToken()); //첫번째 호출
		//int b = Integer.parseInt(st.nextToken()); //두번째 호출
		
		return str;
	}
}
