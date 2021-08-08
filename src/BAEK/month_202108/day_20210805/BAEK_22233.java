package BAEK.month_202108.day_20210805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEK_22233 {
	static int N,M;
	static ArrayList<String> word=new ArrayList<>();
	static LinkedHashSet<String> set=new LinkedHashSet();
	static HashMap<String, Integer> map=new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<N; i++) {
			String tmp=br.readLine();
			map.put(tmp, 0);
		}
		
		int cnt=N;
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine(),",");
			
			while(st.hasMoreTokens()) {
				String tmp=st.nextToken();
				try {
					if(map.get(tmp)==0) {
						cnt--;
						map.remove(tmp);
					}
				} catch (Exception e) {
					continue;
				}
				
			}
			System.out.println(cnt);
			
			
		}
		
		
		
		
		
		
		
	}

}
