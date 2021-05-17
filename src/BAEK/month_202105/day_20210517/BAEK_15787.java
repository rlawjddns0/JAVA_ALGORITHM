package BAEK.month_202105.day_20210517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BAEK_15787 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cus = new int[N+1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");

			int num = Integer.parseInt(st.nextToken());

			if (num == 1) {
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				cus[i] = cus[i] | (1 << x);
			} else if (num == 2) {
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				cus[i] = cus[i] & (~(1 << x));
			} else if (num == 3) {
				int i = Integer.parseInt(st.nextToken());
				
				cus[i] = cus[i] << 1;
				cus[i]=cus[i]&((1 << 21)-1);
			} else if (num == 4) {
				int i = Integer.parseInt(st.nextToken());
				cus[i] = cus[i] >> 1;
				cus[i] &=~1;
			}
			//System.out.println(Arrays.toString(cus));

		}
		
		//System.out.println(Arrays.toString(cus));
		HashSet<Integer> result=new HashSet<>();
		for(int i=1; i<=N; i++) {
			result.add(cus[i]);
		}
		//System.out.println(result.toString());
		System.out.println(result.size());
		
		
		

	}

}
