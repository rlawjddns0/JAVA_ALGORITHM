package BAEK.month_202106.day_20210611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_7682 {

	public static void main(String[] args) throws IOException {
		char[] input=new char[9];
		char[][] map=new char[3][3];
		while(true) {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str=br.readLine();
			int x=0;
			int o=0;
			int dot=0;
			if(str.equals("end"))break;
			
			for(int i=0; i<9; i++) {
				input[i]=str.charAt(i);
				if(input[i]=='X')x++;
				if(input[i]=='O')o++;
				if(input[i]=='.')dot++;
			}
			
			if((x+o)==9) {//두 개의 합이 9개면(맵이 다 꽉 차있다면
				if(x!=5)System.out.println("invalid");
				continue;
			}
			else {
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

}
