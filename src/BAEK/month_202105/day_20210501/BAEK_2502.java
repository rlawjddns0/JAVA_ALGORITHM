package BAEK.month_202105.day_20210501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2502 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		variable[] dp=new variable[31];
		dp[1]=new variable(1, 0);
		dp[2]=new variable(0, 1);
		
		//미리 방정식 계산
		for(int i=3; i<31; i++) {
			dp[i]=new variable(dp[i-1].x+dp[i-2].x, dp[i-1].y+dp[i-2].y);
		}
//		for(int i=1; i<31; i++) {
//			System.out.println(dp[i].toString());
//		}
		int D=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		//x<=y 이므로 1 1 로 시작
		int x=1;
		int y=1;
		L:while(true) {
			
			int X=dp[D].x*x;
			int Y=dp[D].y*y;
			if((X+Y)==K)break L; //D번째 날 x ,y, 대입 한 값이 K 이면 나와라~
			//if((X+Y)>100000)break;
			y++;
			if(X+Y>100000) {
				x++;
				y=x;
			}
			
		}
		
		System.out.println(x);
		System.out.println(y);
	}

}
class variable{
	int x,y;

	public variable(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "variable [x=" + x + ", y=" + y + "]";
	}
	
	
}