package BAEK.month_202106.day_20210624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_8972 {
	static int R,C;
	static int jongsuy, jongsux;
	static char[][] map;
	static ArrayList<crazy> list;
	static int dx[]= {0,-1,0,1,1,1,0,-1,-1};
	static int dy[]= {0,1,1,1,0,-1,-1,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		list=new ArrayList<>();
		for(int i=0; i<R; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j]=tmp[j];
				if(map[i][j]=='R') {
					list.add(new crazy(i,j));
				}
				if(map[i][j]=='I') {
					jongsux=j;
					jongsuy=i;
				}
			}
		}
		
		
		
		
	}

}
class crazy{
	int y,x;

	public crazy(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "crazy [y=" + y + ", x=" + x + "]";
	}
	
}