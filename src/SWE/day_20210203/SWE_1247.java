package SWE.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;



public class SWE_1247 {
	static int N;
	static boolean v[];
	static int ox;
	static int oy;
	static int hx;
	static int hy;
	static int[][]arr;
	static int disMin=Integer.MAX_VALUE;
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<testCase; t++) {
			disMin=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			
			
			Point company=new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point home=new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point[] cus=new Point[N];
			

			for(int i=0; i<N; i++) {
				cus[i]=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				
			}
			// 순열로 처리
			pumutation(cus,new Point[cus.length],new boolean[cus.length],0,company,home);
			System.out.printf("#%d %d\n", t+1,disMin);
			
			
			
			
		}
		
	}
	private static void pumutation(Point[] cus, Point[] sel, boolean[] v, int k, Point company, Point home) {
		// TODO Auto-generated method stub
		if(k==sel.length) {
			int di=0;
			
			di=Math.abs(company.x-sel[0].x)+Math.abs(company.y-sel[0].y);
			for(int i=0; i<sel.length-1; i++) {
				di+=Math.abs(sel[i].x-sel[i+1].x)+Math.abs(sel[i].y-sel[i+1].y);
			}
			di+=Math.abs(sel[sel.length-1].x-home.x)+Math.abs(sel[sel.length-1].y-home.y);
			
			disMin=Math.min(di, disMin);
			return;
		}
		
		for (int i = 0; i < cus.length; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=cus[i];
				pumutation(cus, sel, v, k+1, company, home);
				v[i]=false;
			}
		} 
	}
	

}
