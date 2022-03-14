package BAEK.month_2022023.day_20220311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2630 {
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cntB=0;
		int cntW=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0)cntW++;
				else cntB++;
			}
		}
		
		if(cntW==N*N && cntB==0) {
			System.out.println("1");
			System.out.println("0");
			System.exit(0);
		}else if(cntB==N*N && cntW==0) {
			System.out.println("0");
			System.out.println("1");
			System.exit(0);
		}else {
			solution(0,0,N/2);
			solution(0,N/2,N/2);
			solution(N/2,0,N/2);
			solution(N/2,N/2,N/2);
		}
		
		System.out.println(ansCntW);
		System.out.println(ansCntB);
		
		
		
	}
	static int ansCntB;
	static int ansCntW;
	private static void solution(int startY, int startX, int length) {
		if(length<=1) {
			if(map[startY][startX]==0)ansCntW++;
			else ansCntB++;
			return;
		}
		int cntW=0;
		int cntB=0;
		for(int i=startY; i<startY+length; i++) {
			for(int j=startX; j<startX+length; j++) {
				if(map[i][j]==0) {
					cntW++;
				}else {
					cntB++;
				}
			}
		}
//		System.out.println("길이: "+length);
//		System.out.println("파란색: "+cntB);
//		System.out.println("하얀색: "+cntW);
//		System.out.println();
		if(cntW==length*length && cntB==0) {
			ansCntW++;
			return;
		}else if(cntB==length*length && cntW==0) {
			ansCntB++;
			return;
		}else {
			solution(startY,startX,length/2);
			solution(startY,startX+length/2,length/2);
			solution(startY+length/2,startX,length/2);
			solution(startY+length/2,startX+length/2,length/2);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
