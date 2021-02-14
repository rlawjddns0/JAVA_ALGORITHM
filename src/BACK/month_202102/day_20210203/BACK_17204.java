package BACK.month_202102.day_20210203;

import java.util.Scanner;

public class BACK_17204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numOfHuman=sc.nextInt();//사람 수
		int bosung=sc.nextInt();//보성
		int[] arr=new int[numOfHuman];
		for(int i=0; i<numOfHuman; i++)
			arr[i]=sc.nextInt();
		int count=0;
		int choice=arr[0];
		if(choice==bosung)
		{
			System.out.println("1");
			return ;
		}
		int i=0;
		while(true) {
			count++;
			choice=arr[choice];
			if(choice==bosung) {
				break;
			}
			if(count>numOfHuman)
				break;
			
		}
		if(count>numOfHuman)
			System.out.println("-1");
		else {
			System.out.println(count+1);
		}
		
		
		
		
	}

}
