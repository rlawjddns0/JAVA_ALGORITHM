package BAEK.month_202104.day_20210418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_16432 {
	static ArrayList<Integer>[] day;
	static int[] ans;
	static boolean[][] visit;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		day=new ArrayList[N];
		ans=new int[N+1];
		visit=new boolean[N+1][10];
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			day[i]=new ArrayList<>();
			int tmp=Integer.parseInt(st.nextToken());
			for(int j=0; j<tmp; j++) {
				day[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
	
		dfs(0,0,visit);
		System.out.println("-1");
		
		
	}
	private static void dfs(int d,int prev, boolean[][] visit) {
		
		if(d==N) {
			
			for(int i=0; i<N; i++) {
				System.out.println(ans[i]);
			}
			System.exit(0);
			return ;
		}
		
		
		for(int i=0; i<day[d].size(); i++) {
			if(prev!=day[d].get(i) && !visit[d][day[d].get(i)]) {
				ans[d]=day[d].get(i);
				visit[d][day[d].get(i)]=true;
				dfs(d+1,day[d].get(i),visit);
			}
			
		}
		
		
		
		
	}

}
