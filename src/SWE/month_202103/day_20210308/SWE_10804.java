package SWE.month_202103.day_20210308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_10804 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringBuffer sb = new StringBuffer();
			char[] ch = br.readLine().toCharArray();

			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == 'b') {
					sb.append("d");
				} else if (ch[i] == 'q') {
					sb.append("p");

				} else if (ch[i] == 'p') {
					sb.append("q");

				} else if (ch[i] == 'd') {
					sb.append("b");

				}
			}
			
			System.out.println("#"+t+" "+sb.reverse());

		}
	}

}
