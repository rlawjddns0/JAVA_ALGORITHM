package BAEK.month_202106.day_20210611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 
 * 단순하게 여러 조건들을 따져가면서 코딩하면 된다.
 * 가로, 세로, 대각선 검사를 통해 빙고 수를 알아낸다.
- 같은 라인 빙고가 여러개면 x 
- X의 갯수가 O와 같으면 O가 이겨야 한다
- X가 더 크면 X가 이겨야 한다.
- 빙고가 하나도 없는 경우 X

 */
public class BAEK_7682 {
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String str=br.readLine();
			
			
			if(str.equals("end"))break;
			map=new char[3][3];
			for(int i=0; i<9; i++) {
				map[i/3][i%3]=str.charAt(i);
			}
			
			
			if(test(map)) {
				System.out.println("valid");
			}else {
				System.out.println("invalid");
			}
		
		
			
		}
	}
	private static boolean test(char[][] map) {
		int x=0, o=0, dot=0;
		boolean check=false;
		
		for(int i=0; i<9; i++) {
			if(map[i/3][i%3]=='X')x++;
			else if(map[i/3][i%3]=='O')o++;
			else dot++;
		}
		
		
		if((x+o)==9) {//꽉 차있으면
			if(x-1!=o || Check(map,'O'))
				return false;
			
			return true;
		}
		else {
			
			if(x==o) {//2개 수가 같으면 O로 끝나야함
				boolean tmpO=Check(map,'O');
				boolean tmpX=Check(map,'X');
				
				if(tmpO && !tmpX) {
					return true;
				}else {
					return false;
				}
			}
			else if(x-1==o) {
				boolean tmpO=Check(map,'O');
				boolean tmpX=Check(map,'X');
				
				if(!tmpO && tmpX) {
					return true;
				}else {
					return false;
				}
			}
			
			
			
			
			
		}
		
		
		
		
		return false;
	}
	private static boolean Check(char[][] map, char c) {
		//가로
		for(int i=0; i<3; i++) {
			if(map[i][0]==c && map[i][1]==c && map[i][2]==c) {
				return true;
			}
		}
		
		//세로
		for(int i=0; i<3; i++) {
			if(map[0][i]==c && map[1][i]==c && map[2][i]==c) {
				return true;
			}
		}
		//대각성
		if(map[0][0]==c && map[1][1]==c && map[2][2]==c) {
			return true;
		}
		
		if(map[0][2]==c && map[1][1]==c && map[2][0]==c) {
			return true;
		}
		
		
		return false;
	}

}
