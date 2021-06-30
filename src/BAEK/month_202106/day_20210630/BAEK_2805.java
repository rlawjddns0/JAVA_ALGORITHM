package BAEK.month_202106.day_20210630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2805 {
	static int[] tree;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		tree=new int[N];
		int right=0;
		int left=0;
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			tree[i]=Integer.parseInt(st.nextToken());
			right=Math.max(right, tree[i]);
		}
//		System.out.println(right);
		int middle=0;
		int ans=0;
		while(left<=right) {
			middle=(left+right)/2;
			long sum=0;
			
			
			for(int i=0; i<N; i++) {
				if(tree[i]<=middle)continue;
				sum+=(tree[i]-middle);
			}
//			System.out.println(sum);
			if(sum==M) {
				ans=middle;
				break;
			}
			
			if(sum>M) {
				ans=middle;
				left=middle+1;
			}else {
				right=middle-1;
			}
			
			
		}
		System.out.println(ans);
		
		
		
		
		
		
		
	}

}
