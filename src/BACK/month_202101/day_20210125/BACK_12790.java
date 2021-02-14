package BACK.month_202101.day_20210125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BACK_12790 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		//Scanner sc=new Scanner(System.in);
		int testCase=Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int HP=Integer.parseInt(st.nextToken());
			int MP=Integer.parseInt(st.nextToken());
			int attack=Integer.parseInt(st.nextToken());
			int shiled=Integer.parseInt(st.nextToken());
			
			int hpPlus=Integer.parseInt(st.nextToken());
			int mpPlus=Integer.parseInt(st.nextToken());
			int attackPlus=Integer.parseInt(st.nextToken());
			int shiledPlus=Integer.parseInt(st.nextToken());
			
			
			int sumOfHp=HP+hpPlus;
			if(sumOfHp<1) {
				sumOfHp=1;
			}
			int sumOfMp=MP+mpPlus;
			if(sumOfMp<1)
				sumOfMp=1;
			
			int sumOfAttack=attack+attackPlus;
			if(sumOfAttack<0)
				sumOfAttack=0;
			
			
			int result=0;
			
			result=1*(sumOfHp)+5*(sumOfMp)+ 2*(sumOfAttack)+ 2*(shiled+shiledPlus);
			System.out.println(result);
			
			
			
		}
	}

}
