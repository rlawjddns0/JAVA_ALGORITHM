package BAEK.month_202112.day_20211223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_12739 {
	static int N,K;
	static char[] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		input=new char[N];
		input=br.readLine().toCharArray();
		
		
		while(K!=0) {
			char[] before=new char[N];
			before=input.clone();
//			System.out.println(Arrays.toString(before));
			//1
			for(int i=0; i<N; i++) {
				char middle;
				char left;
				char right;
				int red =0;
				int blue=0;
				int green=0;
				if(i==0) {
					middle=input[i];
					left=input[N-1];
					right=input[i+1];
					
					
				}else if(i==N-1) {
					middle=input[i];
					left=input[i-1];
					right=input[0];
				}else {
					middle=input[i];
					left=input[i-1];
					right=input[i+1];
				}
				
				if(middle=='R')red++;
				if(left=='R')red++;
				if(right=='R')red++;
				
				if(middle=='B')blue++;
				if(left=='B')blue++;
				if(right=='B')blue++;
				
				if(middle=='G')green++;
				if(left=='G')green++;
				if(right=='G')green++;
				
				if((middle==left && middle==right && left==right) || (middle!=left && middle!=right && left!=right)) {//3개 색이 같은경우
					before[i]='B';
				}else if(red==2 && green==1) {
					before[i]='R';
				}else if(green==2 && blue==1) {
					before[i]='R';
				}else if(blue==2 && red==1) {
					before[i]='R';
				}else {
					before[i]='G';
				}
				
				
				
			}
			
			
			
			input=before.clone();
			
			
			K--;
		}
		
		int[] cnt=new int[3];
		
		for(int i=0; i<N; i++) {
			if(input[i]=='R')cnt[0]++;
			else if(input[i]=='G')cnt[1]++;
			else cnt[2]++;
		}
		
		for(int i=0; i<3; i++) {
			System.out.print(cnt[i]+" ");
		}
		
		
		
	}
}
