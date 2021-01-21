package BACK.day_20210120;

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
		
		
		
		int y=0; //¿î¼®ÀÇ ¹Ø¹Ù´Ú
		int x=0;
		for(int i=R-1; i>=0; i--)
		{
			if(MET[i].indexOf("X")!=-1) {
				y=MET[i].indexOf("X");
				x=i;
				break;
			}
		}
		int min=10000;
		//int count=0;
		int tmp=0;
		for(int i=0;i<S;i++) {
	         int count = 0;
	         int state = 0;
	         for(int j=0;j<R;j++) {
	            if(MET[j].charAt(i) == 'X') {
	               state = 1;
	               count = 0;
	            }
	            else if(MET[j].charAt(i) == '#') {
	               break;
	            }
	            if(state == 1) {
	               if(MET[j].charAt(i) == '.') {
	                  count++;
	               }
	            }
	         }
	         if(count != 0) {
	            if(min > count) {
	               min = count;
	            }
	         }
	      }
		for(int i=x; i>=0; i--) {
			for(int j=0; j<S; j++) {
				int count1=min;
				
				if(MET[i].charAt(j)=='X') {//
					int tp=i;
					if(i+count1<R) {
						MET[i+count1].setCharAt(j, 'X');
						MET[tp].setCharAt(j, '.');
					}
					
					
				}
			}
		}

		
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<R; i++)
		{
			sb.append(MET[i]).append("\n");
		}
		
		System.out.println(sb);
	
	}

}
