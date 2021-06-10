package BAEK.month_202106.day_20210609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_13305 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		long[] city=new long[N];
		long[] road=new long[N-1];
		car car=new car(N);
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N-1; i++) {
			road[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			city[i]=Integer.parseInt(st.nextToken());
		}
		
		long min=city[0];
		long ans=0;
		for(int i=0; i<N-1; i++) {
			if(min>city[i]) {
				min=city[i];
			}
			
			ans+=(min*road[i]);
		}
		System.out.println(ans);
	
	}

}
class car{
	long[] city;
	public car(int n) {
		super();
		this.city=new long[n];
	}
	
}