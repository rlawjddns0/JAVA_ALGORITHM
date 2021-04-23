package BAEK.month_202104.day_20210423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BAEK_17255 {
	static HashSet<String> list ;
	static String str;
	static int max;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		max=(str.length()*(str.length()+1))/2;
		list=new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			String tmp = "";
			tmp += str.substring(i, i + 1);
			Ldfs(i, i+1,tmp,1,1);
			Rdfs(i,i+1,tmp,1,1);
			
		}
		
		System.out.println(list.size());

	}
	private static void Ldfs(int curL, int curR, String curString, int cnt,int size) {
		
		if (curString.length()==max) {
			list.add(curString);
			return;
		}
		if (curL - 1 >= 0 ) {
			curString += str.substring(curL - 1, curR);
			Ldfs(curL-1 , curR  ,curString,cnt + 1,curString.length());
			Rdfs(curL-1 , curR  ,curString,cnt + 1,curString.length());
		}

		
	}
	private static void Rdfs(int curL, int curR, String curString, int cnt,int size) {
		
		if (curString.length()==max) {
			list.add(curString);
			return;
		}
		
		
		if (curR + 1 <= str.length()) {
			curString += str.substring(curL , curR+1);
			Rdfs(curL, curR + 1, curString,cnt + 1,curString.length());
			Ldfs(curL, curR + 1, curString,cnt + 1,curString.length());
		}
		
	}

}
