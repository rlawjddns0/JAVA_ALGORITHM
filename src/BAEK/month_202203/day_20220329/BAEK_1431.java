package BAEK.month_2022023.day_20220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEK_1431 {
	static int N;
	static input[] str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		str=new input[N];
		
		
		for(int i=0; i<N; i++) {
			String tmp=br.readLine();
			str[i]=new input(tmp);
		}
		Arrays.sort(str);
		
		for(int i=0; i<N; i++) {
			System.out.println(str[i].str);
		}
		
		
		
		
		
		
	}
	static class input implements Comparable<input>{
		String str;

		public input(String str) {
			super();
			this.str = str;
		}

		@Override
		public int compareTo(input o) {
			if(o.str.length()<this.str.length()) {
				return this.str.length()-o.str.length();
			}else if(o.str.length()==this.str.length()) {
				int A=0;
				for(int i=0; i<o.str.length(); i++) {
					if(o.str.charAt(i)>='0' && o.str.charAt(i)<='9') {
						A+=o.str.charAt(i)-'0';
					}
				}
				
				int B=0;
				for(int i=0; i<this.str.length(); i++) {
					if(this.str.charAt(i)>='0' && this.str.charAt(i)<='9') {
						B+=this.str.charAt(i)-'0';
					}
				}
				
				
				if(A<B) return B-A;
				else if(A>B)return B-A;
				else {
					return this.str.compareTo(o.str);
				}
				
				
			}
			return -1;
		}

		@Override
		public String toString() {
			return "input [str=" + str + "]";
		}
		
		
		
	}

}
