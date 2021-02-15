package SWE.month_202101.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetToNumber {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String Alpha=br.readLine();
		for(int i=0; i<Alpha.length(); i++) {
			int num= (int)Alpha.charAt(i);
			System.out.print(num-64+ " ");
		}
	}

}
