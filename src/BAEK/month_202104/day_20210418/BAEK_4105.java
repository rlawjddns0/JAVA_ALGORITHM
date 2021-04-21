package BAEK.month_202104.day_20210418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_4105 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		while(true) {
			
			st=new StringTokenizer(br.readLine()," ");
			if(!(check(st)))break;
			
			double AX=Double.parseDouble(st.nextToken());
			double AY=Double.parseDouble(st.nextToken());
			double BX=Double.parseDouble(st.nextToken());
			double BY=Double.parseDouble(st.nextToken());
			double CX=Double.parseDouble(st.nextToken());
			double CY=Double.parseDouble(st.nextToken());
			double DX=Double.parseDouble(st.nextToken());
			double DY=Double.parseDouble(st.nextToken());
			double EX=Double.parseDouble(st.nextToken());
			double EY=Double.parseDouble(st.nextToken());
			double FX=Double.parseDouble(st.nextToken());
			double FY=Double.parseDouble(st.nextToken());
			
			//삼각형 크기
			double triangle=(get_distance(DX,DY,FY,FY)*get_distance(DX, DY, EX, EY))/2;
			
			//평행사변형 밑변
			double AH=triangle/get_distance(AX, AY, BX, BY);
			
			
			
			
			
			
			
		}
		
		
		
		
	
	
	}
	public static double get_distance(double ax,double ay, double bx,double by) {
		
		
		return Math.sqrt(Math.pow(ax-bx, 2)+Math.pow(ay-by, 2));
		
	}

	private static boolean check(StringTokenizer st) {
		
		int cnt=0;
		for(int i=0; i<12; i++) {
			
			if(Double.parseDouble(st.nextToken())==0.0) {
				cnt++;
			}
		}
		
		if(cnt==12) {
			return false;
		}
		
		
		return true;
	}

}
