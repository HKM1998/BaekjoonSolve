import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX10395 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		byte[] connecter1 = new byte[5];
		byte[] connecter2 = new byte[5];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < 5; i++) {
			connecter1[i] = Byte.parseByte(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < 5; i++) {
			connecter2[i] = Byte.parseByte(st.nextToken());
		}
		
		boolean result = true;
		for(int i = 0; i < 5; i++) {
			if(connecter1[i] == connecter2[i]) result = false;
		}
		if(result) System.out.println("Y");
		else System.out.println("N");
	}

}
