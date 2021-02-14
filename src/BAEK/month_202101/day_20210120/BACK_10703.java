package BAEK.month_202101.day_20210120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_10703 {

	public static void main(String[] args) throws IOException, IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine(), " ");
		
		int R=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		
		StringBuilder[] MET=new StringBuilder[R];
		
		

		for(int i=0; i<R; i++) {
			StringBuilder tp=new StringBuilder(br.readLine());
			MET[i]=tp;
		}
		
		
		
		int y=0; //
		int x=0;//운석의 밑바닥
		for(int i=R-1; i>=0; i--)//운석의 맨 밑 위치을 찾는 루프
		{
			if(MET[i].indexOf("X")!=-1) {
				y=MET[i].indexOf("X");
				x=i;
				break;
			}
		}
		int min=10000;//최솟값
		//int count=0;
		
		int tmp=0;
		for(int i=0;i<S;i++) {
	         int count = 0;
	         int state = 0;
	         for(int j=0;j<R;j++) {//위에서부터 밑으로 열을 탐색
	            if(MET[j].charAt(i) == 'X') {//운석을 만나면 state=1
	               state = 1;
	               count = 0;
	            }
	            else if(MET[j].charAt(i) == '#') {//땅을 만나면 break후 전에 나왔던 공기층을 검사
	               break;
	            }
	            if(state == 1) {//전 탐색에서 운석을 만났고 
	               if(MET[j].charAt(i) == '.') {//현재가 공기면 카운트
	                  count++;
	               }
	            }
	         }
	         if(count >0) {//공기층은 무조건 1개 이상
	            if(min > count) {//지금 현재 공기층이 min값보다 작으면 min에 대입
	               min = count;
	            }
	         }
	      }
		int count=min;
		for(int i=x; i>=0; i--) {//아까 찾은 운석의 바닥부터 시작
			for(int j=0; j<S; j++) {
				
				
				if(MET[i].charAt(j)=='X') {//운석의 밑 부분부터
					if(i+count<R) {//배열 넘어가면 안돼
						MET[i+count].setCharAt(j, 'X');//그 X의 위치에서 최소거리를 더한 위치에 X 대입
						MET[i].setCharAt(j, '.');//원래 X를 찾았던 위치에 . 대입
					}
					
					
				}
			}
		}

		
		//StringBuffer sb=new StringBuffer();
		for(int i=0; i<R; i++)//버퍼에 한줄씩 붙임
		{
			//sb.append(MET[i]).append("\n");
			System.out.println(MET[i]);
		}
		
		//System.out.println(sb);
	
	}

}
