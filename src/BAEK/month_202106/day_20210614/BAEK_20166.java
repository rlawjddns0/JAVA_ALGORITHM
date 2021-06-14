package BAEK.month_202106.day_20210614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 신이 좋아하는 문자열을 들어올때마다 구하는것은 비효율적임
 * 그래서 일단 신이 좋아하는 문자열중 길이가 가장 긴 문자열의 길이를 구하고
 * 그 길이가 될 때까지 계속 문자열을 구함
 * 중간에 신이 좋아하는 문자열이 완성되면 맵에 카운트 +1
 * 그리고 마지막에 출력만 해주면 된다
 * 
 */
public class BAEK_20166 {
	static int N,M;
	static char[][] map;
	static int K;
	static int cnt,Max;
	static int[] dx= {1,1,0,-1,-1,-1,0,1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	static int starty,startx;
	static HashMap<String, Integer> result;
	static String fav;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		String[] stringArray = new String[K]; // 마지막 출력을 위한 Array
		map=new char[N][M];
		result=new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<K; i++) {
			fav=br.readLine();//신이 좋아하는 문자열
			cnt=0;
			Max=Math.max(Max, fav.length());//그 문자열중에 가장 큰 길이 구하기
			result.put(fav, 0);//맵에 저장 신이 좋아하는 문자열, 갯수 
			stringArray[i] = fav;
			
		}
		for(int j=0; j<N; j++) {
				for(int q=0; q<M; q++) {
					dfs(j,q,Character.toString(map[j][q]),1);//문자열 하나 가지고 시작
			}
		}
		StringBuilder sb = new StringBuilder();
//		System.out.println(result.toString());
		for(String key: stringArray) {
			sb.append(result.get(key)).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	private static void dfs(int y, int x,String str,int len) {
		
		if(result.containsKey(str)) {//지금 온 문자열이 신이 가지고 있는 문자열이면
			result.put(str, result.get(str)+1);//그 문자열의 키값(갯수)+1
		}
		
		
		if(len==Max) {//길이가 맥스를 넘어가면 리턴
			return;
		}
		
		
		for(int d=0; d<8; d++) {
			int ny=(y+dy[d]);
			int nx=(x+dx[d]);
			if(nx < 0)
				nx = M-1;
			else if(nx >= M)
				nx = 0;
			
			if(ny < 0)
				ny = N-1;
			else if(ny >= N)
				ny = 0;
			
			dfs(ny,nx,str+map[ny][nx],len+1);
		}
		
		
		
		
		
	}

}
