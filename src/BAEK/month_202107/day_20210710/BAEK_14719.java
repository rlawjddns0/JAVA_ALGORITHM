package BAEK.month_202107.day_20210710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * 빈 블록의 양 옆을 탐색하여 막혀 있으면 빗물이 찬다
 *
 */
public class BAEK_14719 {
	static int H,W;
	static int[][] map;
	static int[] rain;
	static int[] dx= {1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map=new int[H][W];
		rain=new int[W];
		//입력
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<W; i++) {
			rain[i]=Integer.parseInt(st.nextToken());
		}
		
		
		//입력으로 블록 쌓기
		//1이면 블록이고 0이면 빈 공간
		for(int i=0; i<W; i++) {
			for(int j=0; j<rain[i]; j++) {
				map[j][i]=1;
			}
		}
		
		
		
		
//		print();
		
		
		
		int cnt=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]==0) {
					if(check(i,j)) {//빈 공간 검사해여 막혀잇으면 빗물이 고인다.
						cnt++;
					}
				}
			}
		}
		
		
		
		System.out.println(cnt);
		
	}
	private static boolean check(int y, int x) {
		
		int cnt=0;//빈 공간에서 양 옆으로 블록이 막혀 있는지 블록의 갯수 체크
		
		//오른쪽 검사
		int nx=x;
		while(true) {
			if(nx<0 || nx>=W)break;
			if(map[y][nx]==1) {//오른쪽으로 쭉 가봤더니 블록으로 막혀있다.
				cnt++;//갯수 체크
				break;
			}
			nx+=dx[0];
		}
		
		//왼쪽 검사
		nx=x;
		while(true) {
			if(nx<0 || nx>=W)break;
			if(map[y][nx]==1) {//왼쪽으로 쭉 가봤더니 막혀있다.
				cnt++;//갯수 체크
				break;
			}
			nx+=dx[1];
		}
		
		if(cnt!=2)return false;//갯수가 2개가 아니다 ->막혀있지 않다.
		
		
		
		return true;//양 옆으로 블록으로 막혀있다.->블록의 갯수 체크가 2개다
	}
	private static void print() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
