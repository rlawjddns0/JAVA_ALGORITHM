package BAEK.month_202104.day_20210418;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_3020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();

		int[] top = new int[N / 2];
		int[] bottom = new int[N / 2];
		int q=0,w=0;
		for(int i=0; i<N; i++) {
			int tp=sc.nextInt();
			
			if(i%2==0) {
				bottom[q++]=tp;
			}else {
				top[w++]=tp;
			}
		}
		

		Arrays.sort(bottom);
		Arrays.sort(top);
		int ans=N;
		int cnt=0;
		//System.out.println(Arrays.toString(top));
		//System.out.println(Arrays.toString(bottom));
		for (int h = 1; h <= H; h++) {
			int b=search(bottom,h-1);
			int t=search(top,H-h);
			int tmp= b+t;
			//System.out.println(tmp);
			if(tmp<ans) {
				ans=tmp;
				cnt=1;
			}
			else if(tmp==ans) {
				cnt++;
			}
		}
		System.out.println(ans+" "+cnt);

	}
	public static int search(int[] arr,int h) {
		
		int left=0;
		int right=arr.length-1;
		
		while(left<=right){
			int mid=(left+right)/2;
			
			if(arr[mid]<=h) {
				left=mid+1;
			}else {
				right=mid-1;
			}
			
			
		}
		
		
		return (arr.length-1)-(right);
		
		
	}
}
