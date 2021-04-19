package SWE.month_202104.day_20210419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_8382 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			//원점을 기준으로 옮기기
			x2-=x1;
			y2-=y1;
			
			//양수로 만들기
			x2=Math.abs(x2);
			y2=Math.abs(y2);
			
			if(x2==y2) {
				//2 좌표가 같으면 정사각형
				System.out.println("#"+t+" "+x2*2);
			}else {
				
				int sum=Math.min(x2, y2)*2;//두 좌표중 최소값 구해서 정사각형만큼 길이 구하기
				int tmp=Math.abs(y2-x2);//두 좌표의 차이 구하기
				if(tmp%2==0) {//그 차이의 값이 짝수면
					sum+=tmp*2;
					System.out.println("#"+t+" "+sum);
				}else {//홀수면
					if(tmp==1) {
						System.out.println("#"+t+" "+(sum+1));
					}else {
						System.out.println("#"+t+" "+(sum+(((tmp-1)*2)+1)));
					}
				}
			}
			
			
		}
	
	
	}

}
