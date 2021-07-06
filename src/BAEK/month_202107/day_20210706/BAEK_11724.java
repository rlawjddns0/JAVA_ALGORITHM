package BAEK.month_202107.day_20210706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 그래프 연결 요소 구하는 문제
 * @author multicampus
 *
 */
public class BAEK_11724 {
	static int N,M;
	static boolean[] visit;
	static ArrayList[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());//정점 갯수
		M=Integer.parseInt(st.nextToken());//간선 갯수
		visit=new boolean[N+1];//1부터 시작해서 +1
		v=new ArrayList[N+1];//방문체크 배열
		
		for(int i=1; i<=N; i++) {
			v[i]=new ArrayList<>();
		}
		
		
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			v[from].add(to);
			v[to].add(from);
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {//방문안했으면 
				cnt++;//연결요소 +1
				search( i);
			}
		}
		
		System.out.println(cnt);
		
		
	}
	private static void search(int i) {
		
		if(visit[i])return;
		visit[i]=true;
		for(int j=0; j<v[i].size(); j++) {
			search((int) v[i].get(j));
		}
		
	}

}
