package BAEK.month_2022201.day_20220117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_1990 {
	static int a,b;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		arr=new boolean[100000001];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		
		
		eratosthenes();
		StringBuffer sb=new StringBuffer();
		for(int i=a; i<=b; i++) {
			if(!isPrime[i]) {
				if(check(i)) {
					sb.append(i).append("\n");
				}
			}
		}
		sb.append(-1).append("\n");
		System.out.println(sb);
		
		
	}
	public static boolean[] isPrime = new boolean[100_000_001];

	public static void eratosthenes() {
	    isPrime[0] = isPrime[1] = true;

	    for (int i = 2; i * i <= 100_000_000; i++) {
	        if (!isPrime[i]) {
	            for (int j = i * i; j <= 100_000_000; j += i) {
	                isPrime[j] = true;
	            }
	        }
	    }
	}

	private static boolean check(int num) {
		if (num >= 5 && num < 10)
			return true;

		String before = Integer.toString(num);
		StringBuffer sb=new StringBuffer(before);
		String after=sb.reverse().toString();
		
		if(before.equals(after)) return true;

		return false;
	}
}
