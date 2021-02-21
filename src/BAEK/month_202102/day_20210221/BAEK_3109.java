package BAEK.month_202102.day_20210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BAEK_3109 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][];
		visited=new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i]=br.readLine().toCharArray();
		}
		makePipe();
		System.out.println(ans);
	}
	private static void makePipe() {
		//������� �õ�\
		ans=0;
		for(int i=0; i<R; i++) {
			visited[i][0]=true;
			dfs(i,0);
		}
		
		
	}
	static int[] dr= {-1,0,1};//�������� ����.
	static int ans;
	private static boolean dfs(int r, int c) {
		
		if(c==C-1) {
			ans++;
			return true;//������ ���� ����
		}
		
		
		int nr,nc=c+1;
		for(int d=0; d<3; d++) {
			nr=r+dr[d];
			if(nr<0 || nr>=R || map[nr][nc]=='x' || visited[nr][nc])continue;
			visited[nr][nc]=true;
			if(dfs(nr,nc)) return true;
			//visited[nr][nc]=false;//�����ߴ� ������ ������ �ʴ´� ���� �������� ������ ���纸�� �����Ҽ��� ����
		}
		return false;
	}
	
	
	
	
	

}
