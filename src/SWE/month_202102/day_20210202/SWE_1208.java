package SWE.month_202102.day_20210202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWE_1208 {
	public static int[] box;//≥Ù¿Ã
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc=new Scanner(System.in);
		for(int t=0; t<10; t++) {
			
			int count=sc.nextInt();
			box=new int[100];
			for(int i=0; i<100; i++)
				box[i]=sc.nextInt();
			
			flatt(box,0,count);
			Arrays.sort(box);
			System.out.println("#"+(t+1)+" "+(box[box.length-1]-box[0]));
			
			
		}
		

	}
	
	public static void flatt(int box[], int idx,int count) {
		if(idx==count) {
			return;
		}
		Arrays.sort(box);
		box[0]++;
		box[box.length-1]--;
		flatt(box,idx+1,count);
	}
}
