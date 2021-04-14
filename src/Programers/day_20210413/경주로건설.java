package Programers.day_20210413;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
	//static int[][] board= {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
	//static int[][] board= {{0,0,0},{0,0,0},{0,0,0}};
	//static int[][] board= {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
	//static int[][] board= {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};

	public static void main(String[] args) {
		int[][] board= {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.println(solution(board));
		
	}
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	private static int solution(int[][] board) {
		int answer=0;
		int n=board.length;
		int[][] dp=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		
		
		Queue<pos> q=new LinkedList<>();
		if(board[0][1]!=1)q.offer(new pos(0,1,100,1));//오
		if(board[1][0]!=1)q.offer(new pos(1,0,100,0));//밑
		dp[0][0]=-1;

		while(!q.isEmpty()) {
			pos tmp=q.poll();			
			int dir=tmp.dir;
			for(int d=0; d<4; d++) {
				if(d == (dir+2)%4) continue; //지나온방향은 패쓰
				int ny=tmp.y+dy[d];
				int nx=tmp.x+dx[d];
				if(ny>=n || ny<0 || nx>=n || nx<0)continue;
				if(board[ny][nx]==1)continue;
				int add_money=0;
				if(d==dir)add_money=100;
				if(d!=dir)add_money=600;
				if(dp[ny][nx]>=add_money+tmp.money) {
					dp[ny][nx]=add_money+tmp.money;
					q.offer(new pos(ny,nx,add_money+tmp.money,d));
					
				}
			}
			
		}
		
		return dp[n-1][n-1];
	}
	
	private static void print(int[][] board) {
		for(int i=0; i<board.length; i++) {
			System.out.println(Arrays.toString(board[i]));	
		}	
	}

}
class pos{
	int y,x,money,dir;

	

	@Override
	public String toString() {
		return "pos [y=" + y + ", x=" + x + ", money=" + money + ", dir=" + dir + "]";
	}



	public pos(int y, int x, int money, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.money = money;
		this.dir=dir;
	}
	
	
	
}