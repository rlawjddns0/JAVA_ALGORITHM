package SWE.day_20210115;

import java.util.Scanner;

public class Password {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int A=scanner.nextInt();
		for(int i=A; i>=0; i--)
		{
			if(i==0) {
				System.out.print(i);
			}
			else {
				System.out.print(i +" ");
			}
		}
	}

}
