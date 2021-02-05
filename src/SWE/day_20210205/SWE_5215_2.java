package SWE.day_20210205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_5215_2 {
	public static int ans;
	public static hamburger1[] h;
	public static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= testCase; t++) {
			ans=0;
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 재료의 수
			L = Integer.parseInt(st.nextToken());// 제한 칼로리
			h = new hamburger1[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				h[i] = new hamburger1(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // point, kal
			}
			comb(0,0,0);
			System.out.println("#" + t + " " + ans);
		}

	}

	private static void comb(int idx, int cSum, int tSum) {
		// TODO Auto-generated method stub
		
		
		
		if(idx==h.length) {
			if(cSum<=L) {
				ans=Math.max(ans, tSum);
			}
			
			return;
		}
		
		
		
		comb(idx+1, cSum+h[idx].kal, tSum+h[idx].point);//담고 넘억가ㅗ
		
		comb(idx+1, cSum, tSum);//안감고 넘어가고
		
		
		
		
		
	}

}

class hamburger1{

	int point;
	int kal;

	hamburger1(int point, int kal) {
		this.point = point;
		this.kal = kal;
	}

}
