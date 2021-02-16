package Jungol;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JUNGOL_1370 {
	static StringBuffer sb=new StringBuffer();
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		meet[] m=new meet[N];
		for(int i=0; i<N; i++) {
			m[i]=new meet(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(m);
		solve(m);
		System.out.println(count);
		System.out.println(sb);
		
	}
	public static void solve(meet[] m){
		count++;
		sb.append(m[0].idx+" ");
		int tmp=m[0].end;
		for(int i=1,size=m.length; i<size; i++) {
			if(tmp<=m[i].start) {
				count++;
				sb.append(m[i].idx+" ");
				tmp=m[i].end;
			}	
		}
		
		
	}
	
	
}

class meet implements Comparable<meet>{
	int idx;
	int start;
	int end;
	meet(int idx, int start, int end){
		this.idx=idx;
		this.start=start;
		this.end=end;
	}
	@Override
	public String toString() {
		return "meet [idx=" + idx + ", start=" + start + ", end=" + end + "]";
	}
	@Override
	public int compareTo(meet o) {
		// TODO Auto-generated method stub
		if(this.end-o.end==0) {
			return this.start-o.start;
		}
		
		return this.end-o.end;
	}
	
	
}
