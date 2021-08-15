package BAEK.month_202108.day_20210815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_1495 {
	static int N,S,M;
	static int[] arr;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr = new int[M + 1];

		for (int i = 0; i <= M; i++) {
			arr[i] = -1;
		}
		arr[S] = 0;//0번째에 가능한 볼륨

		int[] volume=new int[N];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			volume[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 1; i <= N; i++) {
			int V = volume[i - 1];
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j <= M; j++) {
				if (arr[j] == i - 1) { // i-1번째에서 가능한 볼륨들을 찾는다.
					int res1 = j + V;
					int res2 = j - V;

					if (0 <= res1 && res1 <= M)
						list.add(res1);
					if (0 <= res2 && res2 <= M)
						list.add(res2);
				}
			}
			
			for (int n : list) {//i번쨔에 가능한 볼륨들 n
				arr[n] = i;
			}
		}

		int max = 0;
		for (int i = 0; i <= M; i++) {
			if (arr[i] == N)
				max = Math.max(max, i);
		}
		
		System.out.println(max);
		
		
		
	}

}
