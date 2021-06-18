package BAEK.month_202106.day_20210611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 
 * �ܼ��ϰ� ���� ���ǵ��� �������鼭 �ڵ��ϸ� �ȴ�.
 * ����, ����, �밢�� �˻縦 ���� ���� ���� �˾Ƴ���.
- ���� ���� ���� �������� x 
- X�� ������ O�� ������ O�� �̰ܾ� �Ѵ�
- X�� �� ũ�� X�� �̰ܾ� �Ѵ�.
- ���� �ϳ��� ���� ��� X

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
		
		
		if((x+o)==9) {//�� ��������
			if(x-1!=o || Check(map,'O'))
				return false;
			
			return true;
		}
		else {
			
			if(x==o) {//2�� ���� ������ O�� ��������
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
		//����
		for(int i=0; i<3; i++) {
			if(map[i][0]==c && map[i][1]==c && map[i][2]==c) {
				return true;
			}
		}
		
		//����
		for(int i=0; i<3; i++) {
			if(map[0][i]==c && map[1][i]==c && map[2][i]==c) {
				return true;
			}
		}
		//�밢��
		if(map[0][0]==c && map[1][1]==c && map[2][2]==c) {
			return true;
		}
		
		if(map[0][2]==c && map[1][1]==c && map[2][0]==c) {
			return true;
		}
		
		
		return false;
	}

}
