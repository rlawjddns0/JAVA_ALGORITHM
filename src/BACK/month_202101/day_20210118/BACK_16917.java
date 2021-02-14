package BACK.month_202101.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_16917 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		int YANG=Integer.parseInt(st.nextToken());//양념 가격
		int HOO=Integer.parseInt(st.nextToken());//후라이드 가격
		int BAN=Integer.parseInt(st.nextToken());//반반 가격
		int x=Integer.parseInt(st.nextToken());//양념 갯수
		int y=Integer.parseInt(st.nextToken());//후라이드 갯수
		
		int tmp=2*BAN;
		int sum=0;
		if((HOO+YANG)<=tmp) {
			System.out.println(HOO*y+YANG*x);
		}
		else {
			int max=Math.max(x, y);
			int min=Math.min(x, y);
			int abs=Math.abs(x-y);
			int temp1=tmp*max;//반반으로 다 산거
			
			int temp2=0;
			temp2=tmp*min+((x<y)?(abs*HOO):(abs*YANG));//반반으로 사고 남은거 후라이드 또는 양념으로 채운 값
			if(temp1<temp2)//2개 비교해서 출력
				System.out.println(temp1);
			else
				System.out.println(temp2);
			
			
			
		}
		
		
		
	}

}
