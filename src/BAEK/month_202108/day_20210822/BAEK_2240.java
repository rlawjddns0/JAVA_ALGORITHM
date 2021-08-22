package BAEK.month_202108.day_20210822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2240 {

	static int T,W;
	static int[] fruit;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		T=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		fruit=new int[T];
		for(int i=0; i<T; i++) {
			fruit[i]=Integer.parseInt(br.readLine());
		}
		
		//dp[시간횟수][이동횟수]
		dp=new int[T+1][W+1];
		//0초 일때
		for(int i=0; i<T; i++) {
			
			if(fruit[i]==1) {//시작 위치가 1번이니까
				dp[i+1][0]=dp[i][0]+1;		//전에 위치에서 받은거 +1		
			}else {
				dp[i+1][0]=dp[i][0];
			}
		}
		
		for(int t=1; t<=T; t++) {
			for(int j=1; j<=W; j++) {
				//짝수면 나무 1에 위치
				if(j%2==0) {
					if(fruit[t-1]==1) {//자두가 1번 위치로 떨어진다.
						//전에 위치에서 그냥 움직이지 않고 받는경우, 움직여서 받는 경우
						dp[t][j]=Math.max(dp[t-1][j-1], dp[t-1][j]+1);
					}
					else {
						dp[t][j]=Math.max(dp[t-1][j-1]+1, dp[t-1][j]);
					}
					
				}else {//나무 2에 위치
					
					if(fruit[t-1]==1) {//자두가1번 위치로 떨어진다.
						//전에 위치에서 움직여야 하는 경우 그냥 안받는 경우
						dp[t][j]=Math.max(dp[t-1][j-1]+1, dp[t-1][j]);
					}
					else {
						//자두가 2번 위치로 떨어진다. 
						//지금 위치에서 그냥 받는경우 , 
						dp[t][j]=Math.max(dp[t-1][j-1], dp[t-1][j]+1);
						
					}
					
				}
			}
		}
		
		int ans=0;
		for(int i=0; i<=W; i++) {
			ans=Math.max(ans, dp[T][i]);
		}
		System.out.println(ans);
		
		
		
		
		
		
	}

}
