package BAEK.month_2022023.day_20220301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_1931 {
	static int N;
	static time[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		list=new time[N];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list[i]=new time(start,end);
		}
		
		Arrays.sort(list);
		int cnt=1;
//		for(int i=0; i<N; i++)
//		{
//			System.out.println(list[i].toString());
//		}
		
		int conferenceStart=list[0].end;
		for(int i=1; i<N; i++) {
			if(conferenceStart<=list[i].start) {
				conferenceStart=list[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	static class time implements Comparable<time>{
		int start,end;

		public time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		

		public time() {
			super();
		}
		


		@Override
		public String toString() {
			return "time [start=" + start + ", end=" + end + "]";
		}


		@Override

		public int compareTo(time o) {
//			if(this.end<o.end) {
//				return -1;
//			}else if(this.end==o.end) {
//				if(this.start<o.start) return -1; 
//			}
//			return 0;
			if(this.end==o.end)return this.start-o.start;
			return this.end-o.end;
		}
		
	}
}
