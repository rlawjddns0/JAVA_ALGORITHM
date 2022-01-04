package BAEK.month_2022201.day_20220104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1929 {
	static int N,M;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		visit=new boolean[1000001];
		
		visit[0]=true;
		visit[1]=true;
		
    
    //에라토스테네스의 채 이용
		for(int i=2; i<=1000000; i++) {
			if(visit[i])continue;
			for(int j=2*i; j<=1000000; j+=i) {
				visit[j]=true;
			}
		}
		
		
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		
		StringBuffer sb=new StringBuffer();
		for(int i=N; i<=M; i++) {
			if(!visit[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
	
}
