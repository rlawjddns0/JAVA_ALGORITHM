package BAEK.month_202105.day_20210508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14465 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=0,K=0,B=0;
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		long ans=Integer.MAX_VALUE;
		boolean[] road=new boolean[N+1];
		for(int i=0; i<B; i++) {
			int n=Integer.parseInt(br.readLine());
			road[n]=true;
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(road[i]) {
				int tmp=0;
				for(int j=i; j<=N; j++) {
					if(!road[j]) {
						cnt++;
					}
					if(road[j]) {
						tmp++;
					}
					
					if((cnt+tmp)==K) {
						ans=Math.min(ans,tmp);
						break;
					}
				}
				cnt=0;
			}
			else if(!road[i]) {
				cnt++;
				if(cnt==K) {
					System.out.println("0");
					System.exit(0);
				}
			}
			
		}
		System.out.println(ans);
		
		
		
		
		
		
	}

}
