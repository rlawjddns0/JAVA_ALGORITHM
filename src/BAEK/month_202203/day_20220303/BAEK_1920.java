package BAEK.month_2022023.day_20220304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BAEK_1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N,M;
		HashMap<Integer, Boolean> map=new HashMap<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			map.put(Integer.parseInt(st.nextToken()), true);
		}
		M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine()," ");
		StringBuffer sb=new StringBuffer();
		
		for(int i=0; i<M; i++) {
			int num=Integer.parseInt(st.nextToken());
			if(map.get(num)==null || map.get(num)==false || map.containsKey(num)==false) {
				sb.append(0+"\n");
			}else {
				sb.append(1+"\n");
			}
		}
		System.out.println(sb);
		
		
		
		
	}
}
