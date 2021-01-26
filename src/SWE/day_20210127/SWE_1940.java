package SWE.day_20210127;

import java.util.Arrays;
import java.util.Scanner;
/** 
 * 0:현재 속도 유지.
 * 1:가속
 * 2:감속
 * 
 * 시간은 무조건 1초씩 증가 입력 마다 가속인지 감속인지 유지인지 확인해서 전에 속도와 함꼐 거리를 구한
 * */
public class SWE_1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		
		for(int t=0; t<testCase; t++) {
			int Command=sc.nextInt();
			int state=0;;
			int v=0;
			int tmpV=0;
			int dis=0;//거리
			for(int i=0; i<Command; i++) {
				state=sc.nextInt();
				if(state!=0) {
					v=sc.nextInt();
				}
				
				if(state==0)//유지
				{
					dis+=v*1;
				}
				else if(state==1) {//가속
					v+=tmpV;;
					dis+=v*1;
					tmpV=v;
				}
				else {//감속
					if(v>tmpV) {
						v=0;
						dis+=v*1;
						tmpV=v;
					}
					else
					{
						v=tmpV-v;
						dis+=v*1;
						tmpV=v;
					}
					
				}
				
			}
			System.out.println("#"+(t+1)+" "+dis);
			
			
		}
		
		
	}

}
