package SWE.month_202103.day_20210302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class SWE_5656 {
	static int[][] map;
	static int N,W,H;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			map=new int[H][W];
			
			for(int i=0; i<H; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			
			
		
		
		}
	}

}
