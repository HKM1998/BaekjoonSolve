package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MeetingTime implements Comparable<MeetingTime>{
	int sTime;
	int eTime;
	
	public MeetingTime(int sTime, int eTime) {
		this.sTime = sTime;
		this.eTime = eTime;
	}
	
	@Override
	public int compareTo(MeetingTime o) {
		if(this.eTime == o.eTime) {
			return this.sTime - o.sTime;
		}else {
			return this.eTime - o.eTime;
		}
	}
}

public class EX1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MeetingTime[] metArr= new MeetingTime[n];
		for(int i = 0; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			metArr[i] = new MeetingTime(s, e);
		}
		
		Arrays.sort(metArr);
		
		int count = 0;
		int prev_time = 0;
		for(int i = 0; i < n; i++) {
			if(prev_time <= metArr[i].sTime) {
				prev_time = metArr[i].eTime;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
