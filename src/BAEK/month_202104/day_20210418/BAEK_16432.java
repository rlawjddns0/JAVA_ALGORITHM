package BAEK.month_202104.day_20210418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_16432 {
	static ArrayList<Integer>[] day;
	static int[] ans;
	static boolean flag;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		day=new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			day[i]=new ArrayList<>();
			int tmp=Integer.parseInt(st.nextToken());
			for(int j=0; j<tmp; j++) {
				day[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		flag=false;
		ans=new int[N];
		int before=-1;
		int cnt=0;
		
		for(int i=0; i<day[0].size(); i++) {
			ans[0]=day[0].get(i);
			dfs(1,1,day[0].get(i));
			if(flag)break;
			else {
				System.out.println("-1");
				System.exit(0);
			}
		}
		
		
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
		
		
	}
	private static void dfs(int cnt,int next, int num) {
		
		
		if(cnt==N ) {
			flag=true;
			return ;
		}
		
		
		for(int i=0; i<day[next].size(); i++) {
			if(num!=day[next].get(i)) {
				ans[cnt]=day[next].get(i);
				dfs(cnt+1,next+1,day[next].get(i));
				//if(flag==false)return;
			}
		}
		
		//flag=false;
		//return false;
		
	}

}
