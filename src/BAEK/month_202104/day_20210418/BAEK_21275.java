package BAEK.month_202104.day_20210418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BAEK_21275 {
	static HashMap<Character, Integer> arr;
	static long MAX=(long) Math.pow(2, 63);
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		arr=new HashMap<>();
		for(int i=0; i<=9; i++) {
			arr.put(Integer.toString(i).charAt(0), i);
		}
		for(int i=10; i<=35; i++) {
			arr.put((char)(87+i), i);
		}
		//System.out.println(arr.toString());
		String num1=st.nextToken();
		String num2=st.nextToken();
		
		int num1_max=0;
		int num2_max=0;
		//System.out.println(num1);
		for(int i=0; i<num1.length(); i++) {
			num1_max=Math.max(num1_max, arr.get(num1.charAt(i)));
		}
		
		for(int i=0; i<num2.length(); i++) {
			num2_max=Math.max(num2_max, arr.get(num2.charAt(i)));
		}
		int cnt=0;
		int answer1=0;
		int answer2=0;
		//System.out.println((long)Math.pow(2, 63));
		//System.out.println(num1_max);
		//System.out.println(num2_max);
		for(int i=num1_max+1; i<=35; i++) {
			long tmp=change(num1,i);
			for(int j=num2_max+1; j<=35; j++) {
				if(i==j)continue;
				if(tmp==change(num2,j)) {
					if(tmp>=MAX)continue;
					answer1=i;
					answer2=j;
					cnt++;
				}
			}
		}
		
		if(cnt==0) {
			System.out.println("Impossible");
		}else if(cnt==1) {
			System.out.println(change(num1,answer1)+" "+answer1+" "+answer2);
		}else {
			System.out.println("Multiple");
		}
		
		
		
		
		
		
	}
	public static long change(String str,int k) {
		long sum=0;
		for(int i=str.length()-1,j=0; i>=0;j++, i--) {
			sum+=(long)(Math.pow(k, j)*arr.get(str.charAt(i)));
		}
		return sum;
	}

}
