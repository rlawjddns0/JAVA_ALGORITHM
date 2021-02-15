package SWE.month_202102.day_20210215;

import java.util.Arrays;
import java.util.Scanner;

public class jungol_1828 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		input[] c=new input[N];
		for(int i=0; i<N; i++) {
			int min=sc.nextInt();
			int max=sc.nextInt();
			c[i]=new input(min,max);
		}
		
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		int count=1;
		int max=c[0].maxD;
		//input tmp=c[c.length-1];
		for(int i=1; i<N; i++) {
			if(c[i].minD>max) {
				max=c[i].maxD;
				count++;
			}
			
		}
		
		System.out.println(count);
		

	}

}
class input implements Comparable<input>{
	int minD;
	int maxD;
	input(int minD, int maxD){
		this.maxD=maxD;
		this.minD=minD;
	}
	@Override
	public int compareTo(input o) {
		// TODO Auto-generated method stub
		return this.maxD-o.maxD;
	}
	@Override
	public String toString() {
		return "input [minD=" + minD + ", maxD=" + maxD + "]";
	}
	
}