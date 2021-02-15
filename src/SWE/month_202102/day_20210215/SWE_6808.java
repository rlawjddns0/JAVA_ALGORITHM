package SWE.month_202102.day_20210215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_6808 {
	static boolean[] arr;//true가 규영 false가 인영
	static int[] gyu=new int[9];
	static int[] in=new int[9];
	static boolean[] v=new boolean[9];
	static int win,lose,k,j;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			win=0;
			lose=0;
			k=0;
			j=0;
			arr=new boolean[19];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=1; i<10; i++) {
				arr[Integer.parseInt(st.nextToken())]=true;
			}
			
			for(int i=1; i<19; i++) {
				if(arr[i]==true) {
					gyu[k++]=i;
					
				}else {
					in[j++]=i;
				}
			}
			
			solve(new int[9],0,v);
			System.out.println("#"+t+" "+win+" "+lose);

		}
		
		
	}
	
	public static void solve(int[] sel, int k, boolean[] v) {
		
		if(k==9) {
			int sumG=0;
			int sumI=0;
			for(int i=0; i<9; i++) {
				if(sel[i]<gyu[i])//규영이가 더 큰 경우 
				{
					sumG+=sel[i]+gyu[i];
				}
				else if(sel[i]>gyu[i]) {//인영이가 큰 경우
					sumI+=sel[i]+gyu[i];
				}
			}
			if(sumG>sumI) {
				win++;
			}
			else if( sumG<sumI){
				lose++;
			}
			return;
		}
		
		
		for(int i=0; i<9; i++) {
			if(v[i]==false) {
				sel[k]=in[i];
				v[i]=true;
				solve(sel,k+1,v);
				v[i]=false;
			}
		}
		
	}

}
