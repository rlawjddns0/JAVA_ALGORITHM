package BACK.month_202102.day_20210211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BAEK_8911 {
	//static int dir;
	static int[] dx= {0,-1,0,1};//À§ ¿Þ ¾Æ ¿À
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<TC; t++) {
			int x1=0,y1=0,x2=0,y2=0;
			String str=br.readLine();
			int dir=0;
			int ansX1=0;
			int ansY1=0;
			int ansX2=0;
			int ansY2=0;
			for(int i=0; i<str.length(); i++) {
				switch(str.charAt(i)) {
				case 'F':
					x1+=dx[dir];
					y1+=dy[dir];
					break;
				case 'B':
					x1-=dx[dir];
					y1-=dy[dir];
					break;
				case 'L':
					if(dir==0) {dir=1;}
					else if(dir==1) {dir=2;}
					else if(dir==2) {dir=3;}
					else dir=0;
					break;
				case 'R':
					if(dir==0) {dir=3;}
					else if(dir==1) {dir=0;}
					else if(dir==2) {dir=1;}
					else dir=2;
					break;
				}
				ansX1=Math.max(ansX1,x1);
				ansY1=Math.max(ansY1,y1);
				ansX2=Math.min(ansX2,x1);
				ansY2=Math.min(ansY2,y1);
//				System.out.println(dir);
//				System.out.println(ansX1+" "+ansY1+" "+ansX2+" "+ansY2);
			
			}
			
			System.out.println((ansX1-ansX2)*(ansY1-ansY2));
			
			
			
		}
		
	}
	public static void init() {
		
	}

}
