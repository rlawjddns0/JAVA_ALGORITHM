package BAEK.month_202104.day_20210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 다시 풀기
 * 
 */
public class BAEK_2580 {
	static int[][] board;
	static int cnt;
	static ArrayList<pos> list;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		board=new int[9][9];
		
		cnt=0;
		list=new ArrayList<>();
		for(int i=0; i<9; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<9; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==0) {
					cnt++;
					list.add(new pos(i,j));
				}
			}
		}
		
		//System.out.println(cnt);
		
		sudoku(0);
		
		
		
	}
	private static void print() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void sudoku(int N) {
		if(N==cnt) {
			//System.out.println(N);
			print();
			//System.out.println();
			System.exit(0);
		}
	
		for(int j=1; j<=9; j++) {
			
			board[list.get(N).y][list.get(N).x]=j;
			if(check(list.get(N))) {
				sudoku(N+1);
				//if(flag)return;

			}
//			print();
//			System.out.println(N);
//			System.out.println();
			//if(flag)return;
		}
		
		board[list.get(N).y][list.get(N).x]=0;
		return;
		
		
		
	}
	private static boolean check(pos pos) {
		
		int y=pos.y;
		int x=pos.x;
		
		for(int i=0; i<9; i++) {
			if(board[i][x]==board[y][x] && i!=y)return false;
			if(board[y][i]==board[y][x] && i!=x)return false;
		}
		
		int tmpx=pos.x/3;
		int tmpy=pos.y/3;
		
		for(int i=3*tmpy; i<3*tmpy+3; i++) {
			for(int j=3*tmpx; j<3*tmpx+3; j++) {
				if(board[i][j]==board[y][x]) {
					if(i!=y && j!=x)
						return false;
				}
			}
		}
		
		return true;
	}

}
class pos{
	int y,x;

	public pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}