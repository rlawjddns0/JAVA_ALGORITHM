package BAEK.month_2022201.day_20220117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_1990 {
	static int a,b;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		arr=new int[100000001];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		
		
		arr[1]=0;
		arr[2]=0;
		
		for(int i=2; i<100000001; i++) {
			if(arr[i]==0) {//소수이면
				
				int j=i*2;
				while(true) {
					if(j>=100000001)break;
					arr[j]=2;
					j+=i;
				}
			}
		}
		
		StringBuffer sb=new StringBuffer();
		for(int i=a; i<=b; i++) {
			if(arr[i]==0) {
				if(check(i)) {
					sb.append(i).append("\n");
				}
			}
		}
		sb.append(-1).append("\n");
		System.out.println(sb);
		
		
	}
	private static boolean check(int num) {

		if(num>=5 && num<10)return true;
	
		String before=Integer.toString(num);
		Stack<Character> stack=new Stack<>();
		for(int i=0; i<before.length(); i++) {
			stack.add(before.charAt(i));
		}
		String after="";
		while(!stack.isEmpty()) {
			after+=stack.pop();
		}
		
		if(before.equals(after))return true;
		
		
		
		
		
		return false;
	}
}
