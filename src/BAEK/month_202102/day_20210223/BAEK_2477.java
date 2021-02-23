package BAEK.month_202102.day_20210223;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_2477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] length=new int[6];
		int W=0;
		int w=0;
		int H=0;
		int h=0;
		for (int i = 0; i < 6; i++) {
			int d=sc.nextInt();
			length[i]=sc.nextInt();
		}
		
		for(int i=0; i<6; i++) {
			if(i%2==0) {
				if(W<length[i]) {
					W=length[i];
				}
			}
			else {
				if(H<length[i]) {
					H=length[i];
				}
			}
		}
	
		int sum=W*H;//Å« ³ÐÀÌ
		
		for (int i = 0; i < 6; i++) {
			if(i%2==0) {
				if(H==length[(i+5)%6]+length[(i+1)%6]) {
					w=length[i];
				}
			}
			else {
				if(W==length[(i+5)%6]+length[(i+1)%6]) {
					h=length[i];
				}
			}
			
		}
		
		sum=sum-h*w;
		System.out.println(sum*K);
	
	}
	
}
