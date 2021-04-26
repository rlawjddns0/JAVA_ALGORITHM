package SWE.month_202104.day_20210426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_11688 {

	static char[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			
			tree=br.readLine().toCharArray();
			int root=0;
			int cnt=0;
			if(tree[0]=='L') {
				dfs(1,1,1,cnt,t,1/1);

			}else {
				dfs(1,1,2,cnt,t,1/1);

			}
			
			
			
			
			
			
		}
		
		
		
	}
	private static void dfs(int a, int b, int n, int cnt,int t,int res) {
		if(cnt==tree.length) {
			
			System.out.println("#"+t+" "+a+" "+b);
			return;
		}
		
		if(tree[cnt]=='L') {
			dfs(a,a+b,(n*2)+1,cnt+1,t,a/(a+b));
		}else {
			dfs(a+b,b,(n*2)+2,cnt+1,t,(a+b)/b);
		}
		
		
		
	}

}
