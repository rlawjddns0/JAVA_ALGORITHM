package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_1828 {
	static int count;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		ch[] c=new ch[N];
		for(int i=0; i<N; i++) {
			c[i]=new ch(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(c);
		//System.out.println(Arrays.toString(c));
		solve(c);
		System.out.println(count);
	}
	public static void solve(ch[] c) {
		count++;
		int tmp=c[0].to;
		for(int i=1; i<N; i++) {
			if(tmp>=c[i].from) {
				continue;
			}
			else {
				count++;
				tmp=c[i].to;
			}
		}
	}
	

}
class ch implements Comparable<ch>{
	int from;
	int to;
	ch(int from, int to) {
		this.from=from;
		this.to=to;
	}
	@Override
	public String toString() {
		return "ch [from=" + from + ", to=" + to + "]";
	}
	@Override
	public int compareTo(ch o) {
		// TODO Auto-generated method stub
		if(this.to-o.to==0) {
			return this.from-o.from;
		}
		return this.to-o.to;
	}
	
	
}
