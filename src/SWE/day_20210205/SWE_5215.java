package SWE.day_20210205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWE_5215 {
	public static int ans;
	public static int N;
	public static hamburger[] h;
	public static int L;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t=1; t<=testCase; t++) {
			ans=0;
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());//재료의 수 
			L=Integer.parseInt(st.nextToken());//제한 칼로리
			h= new hamburger[N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				h[i]=new hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	//point, kal
			}
			powerSet(0,new boolean[N]);
			System.out.println("#"+t+" "+ans);
		}
		
		
	}
	private static void powerSet(int idx, boolean[] sel) {
		// TODO Auto-generated method stub
		if(idx==sel.length) {
			int totalcal=0;
			int totalpoint=0;
			for(int i=0; i<sel.length; i++)
			{	
				if(sel[i]==true) {
					totalpoint+=h[i].point;
					totalcal+=h[i].cal;
					if(totalcal>L) {
						return;
					}
				}
			}
			ans=Math.max(ans, totalpoint);
			
			return;
		}
		sel[idx]=true;
		powerSet(idx+1,sel);//선택
		sel[idx]=false;
		powerSet(idx+1,sel);
	}
	

}

class hamburger{
	
	int point;
	int cal;
	hamburger(int point, int cal){
		this.point=point;
		this.cal=cal;
	}
	
	
}
