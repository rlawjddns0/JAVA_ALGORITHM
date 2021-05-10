package BAEK.month_202105.day_20210509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_15565 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=0,K=0;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		ArrayList<Integer> list=new ArrayList<Integer>();
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]==1) {
				list.add(i);
			}
		}
		if(list.size()<K) {
			System.out.println("-1");
			return;
		}
		int ans=Integer.MAX_VALUE;
		int cnt=list.size();
		for(int i=0; i<list.size(); i++) {
			int start=i;
			if(start+K-1<list.size()) {
				ans=Math.min(ans, list.get(start+K-1)-list.get(i)+1);
			}
			
		}
		
		System.out.println(ans);
		
		
		
		
		
		
		
		
				
	}

}
