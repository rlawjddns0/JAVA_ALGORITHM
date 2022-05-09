package BAEK.month_202204.day_20220425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_3034 {
	static int N,W,H;
	static int[] matcheses;  
	static StringBuffer sb=new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			int matches=Integer.parseInt(br.readLine());
			if(matches<=W) {
				sb.append("DA").append("\n");
				
				continue;
			}
			if(matches<=H) {
				sb.append("DA").append("\n");
				continue;
				
			}
			if(Math.pow(matches, 2)<=Math.pow(H,2)+Math.pow(W,2)) {
				sb.append("DA").append("\n");
				continue;
			}
			
			sb.append("NE").append("\n");
			
			
		}
		System.out.println(sb);
		
		
	}

}
