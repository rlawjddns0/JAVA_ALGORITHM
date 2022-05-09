package BAEK.month_202204.day_20220426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_12919 {
	static int numA,numB;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String S=br.readLine();
		String T=br.readLine();
		for(int i=0; i<T.length();i++) {
			if(T.charAt(i)=='A')numA++;
			else numB++;
		}
		int sNumA=0,sNumB=0;
		for(int i=0; i<S.length();i++) {
			if(S.charAt(i)=='A')sNumA++;
			else sNumB++;
		}
		permutation(S,T);
		
		System.out.println(ans);
		
	}
	static int ans;
	private static void permutation(String s, String t) {
//		System.out.println(t);
		if(s.equals(t)) {
			System.out.println(1);
			System.exit(1);
		}
		
		if(s.length()>=t.length())
		{
			return;
		}
		StringBuffer sb=new StringBuffer();
		String newT=sb.append(t).reverse().toString();
		String oldT=t;
		
		if(newT.charAt(newT.length()-1)=='B') {
			permutation(s,newT.substring(0, t.length()-1));
			t=oldT;
		}
		
		if(t.charAt(t.length()-1)=='A') {
			permutation(s,t.substring(0, t.length()-1));
		}
		
		
		
		
		
		
	}
}
