package SWE.month_202102.day_20210219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_4613 {
	static char[][] map;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new char[N][M];
			for(int i=0; i<N; i++) {
				map[i]=br.readLine().toCharArray();
			}
			
			
			
			
			
			
		}
		
		
		
	}
	public static void solve() {
		
	}

}
